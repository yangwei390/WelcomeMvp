package com.yangwei.www.net.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ____ Bye丶 on 2016/9/21.
 */

public class OkHttpDownLoad {
    private static OkHttpDownLoad instance = null;
    private OkHttpClient client = null;
    private final int PROCESS = 1;
    private final int FAILURE = 2;
    private final int SUCCESS = 3;
    private OkHttpDownListener listener;
    private int progress = 0;

    private OkHttpDownLoad() {
    }

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case PROCESS:
                    listener.onProcess(msg.arg1);
                    break;
                case FAILURE:
                    listener.onFailure();
                    break;
                case SUCCESS:
                    listener.onSuccess();
                    break;
            }
        }
    };

    public static OkHttpDownLoad getInstance() {
        synchronized (OkHttpDownLoad.class) {
            if (instance == null) {
                instance = new OkHttpDownLoad();
            }
        }
        return instance;
    }

    public void startDownload(String downloadUrl, final String filePath, final String fileName, final OkHttpDownListener listener) {
        try {
            this.listener = listener;
            Request.Builder builder = new Request.Builder();
            builder.tag(this).get().url(downloadUrl);
            Request request = builder.build();
            OkHttpDownHelper.addProgressResponseListener(getClient(), new ProgressResponseListener() {
                @Override
                public void onResponseProgress(long totalBytesRead, long l, boolean b) {
                    int p = (int) (totalBytesRead * 100 / l);
                    if (progress != p) {
                        Message message = new Message();
                        message.what = PROCESS;
                        message.arg1 = progress;
                        progress = p;
                        handler.sendMessage(message);
                    }
                }
            }).newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                    handler.sendEmptyMessage(FAILURE);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    saveFile2Local(response, filePath, fileName);
                }
            });
        } catch (Exception e) {
            handler.sendEmptyMessage(FAILURE);
        }

    }

    private OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient.Builder().build();
        }
        return client;
    }

    /**
     * 保存本地
     *
     * @param response
     * @param dir
     */
    public File saveFile2Local(Response response, String dir, String fileName) {

        InputStream inputStream = null;
        OutputStream output = null;
        File file;
        try {
            File dirFile = new File(dir);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            inputStream = response.body().byteStream();
            file = new File(dir, fileName);
            if (file.exists()) {
                file.delete();
            }
            output = new FileOutputStream(file);
            byte[] buff = new byte[1024 * 4];
            while (true) {
                int readed = inputStream.read(buff);
                if (readed == -1) {
                    break;
                }
                //write buff
                output.write(buff, 0, readed);
            }
            output.flush();
            handler.sendEmptyMessage(SUCCESS);
            return file;
        } catch (IOException e) {
            file = null;
            handler.sendEmptyMessage(FAILURE);
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
