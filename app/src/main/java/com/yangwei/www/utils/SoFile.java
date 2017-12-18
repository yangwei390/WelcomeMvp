package com.yangwei.www.utils;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by yangwei on 2017/12/18.
 */

public class SoFile {
    /**
     * 加载 so 文件
     *
     * @param context
     * @param fromPath 下载到得sdcard目录
     */
    public static void loadSoFile(Context context, String fromPath) {
        File dir = context.getDir("libs", Context.MODE_PRIVATE);
        if (!isLoadSoFile(dir)) {
            copy(fromPath, dir.getAbsolutePath());
        }
    }

    /**
     * 判断 so 文件是否存在
     *
     * @param dir
     * @return
     */
    public static boolean isLoadSoFile(File dir) {
        File[] currentFiles;
        currentFiles = dir.listFiles();
        boolean hasSoLib = false;
        if (currentFiles == null) {
            return false;
        }
        for (int i = 0; i < currentFiles.length; i++) {
            if (currentFiles[i].getName().contains("libwedsa23")) {
                hasSoLib = true;
            }
        }
        return hasSoLib;
    }

    /**
     * @param fromFile 指定的下载目录
     * @param toFile   应用的包路径
     * @return
     */
    public static int copy(String fromFile, String toFile) {
        //要复制的文件目录
        File[] currentFiles;
        File root = new File(fromFile);
        //如同判断SD卡是否存在或者文件是否存在,如果不存在则 return出去
        if (!root.exists()) {
            return -1;
        }
        //如果存在则获取当前目录下的全部文件 填充数组
        currentFiles = root.listFiles();

        //目标目录
        File targetDir = new File(toFile);
        //创建目录
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        //遍历要复制该目录下的全部文件
        for (int i = 0; i < currentFiles.length; i++) {
            if (currentFiles[i].isDirectory()) {
                //如果当前项为子目录 进行递归
                copy(currentFiles[i].getPath() + "/", toFile + currentFiles[i].getName() + "/");
            } else {
                //如果当前项为文件则进行文件拷贝
                if (currentFiles[i].getName().contains(".so")) {
                    int id = copySdcardFile(currentFiles[i].getPath(), toFile + File.separator + currentFiles[i].getName());
                }
            }
        }
        return 0;
    }


    //文件拷贝
    //要复制的目录下的所有非子目录(文件夹)文件拷贝
    public static int copySdcardFile(String fromFile, String toFile) {
        try {
            FileInputStream fosfrom = new FileInputStream(fromFile);
            FileOutputStream fosto = new FileOutputStream(toFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fosfrom.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            // 从内存到写入到具体文件
            fosto.write(baos.toByteArray());
            // 关闭文件流
            baos.close();
            fosto.close();
            fosfrom.close();
            return 0;
        } catch (Exception ex) {
            return -1;
        }
    }
}
