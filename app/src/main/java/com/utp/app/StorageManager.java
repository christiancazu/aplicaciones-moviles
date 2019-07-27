package com.utp.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StorageManager {

    public static final String  PATH_STORAGE = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Camera/";

    public static boolean save(Context ctx, String idName) {
        Bitmap image = null;

        // ActivityCompat.requestPermissions(TestamentActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        File dir = new File(PATH_STORAGE);
        dir.mkdirs();

        File file = null;

        if (idName.equals("firstImage")) {
            image = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.christian);
        } else {
            image = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.ciber);
        }

        file = new File(dir, "profile.jpg");

        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
