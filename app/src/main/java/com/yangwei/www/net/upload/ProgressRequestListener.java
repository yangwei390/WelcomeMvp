package com.yangwei.www.net.upload;

/**
 * Created by h2h on 2015/9/8.
 */
public interface ProgressRequestListener {
        void onRequestProgress(long bytesWritten, long contentLength, boolean done);
}