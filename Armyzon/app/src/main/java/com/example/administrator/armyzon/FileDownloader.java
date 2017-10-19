package com.example.administrator.armyzon;

/**
 * Created by Administrator on 2017-10-19.
 */
import android.content.Context;
import android.util.Log;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;

import cz.msebera.android.httpclient.Header;

public class FileDownloader {
    private final Context context;

    public FileDownloader(Context context) {
        this.context = context;
    }

    private static AsyncHttpClient client = new AsyncHttpClient();
    public void downFile(String fileUrl, String fileName) {
        final File filePath = new File(context.getFilesDir().getPath() + "/" + fileName);

        if(!filePath.exists()) {
            client.get(fileUrl, new FileAsyncHttpResponseHandler(context) {
                @Override
                public void onFailure(int i, Header[] headers, Throwable throwable, File file) {

                }

                @Override
                public void onSuccess(int i, Header[] headers, File file) {
                    Log.i("test", "responsePath: " + file.getAbsolutePath());
                    Log.i("test", "originalPath: " + filePath.getAbsolutePath());
                    file.renameTo(filePath);
                }
            });
        }
    }
}
