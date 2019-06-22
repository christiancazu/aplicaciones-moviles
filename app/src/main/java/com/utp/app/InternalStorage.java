package com.utp.app;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalStorage {

    private static final String FILENAME = "myInternalStorage";

    public static void setData(Context context, String input) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(input.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getData(Context context) throws IOException {
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(FILENAME);
            String data = getFileContent(fis, "UTF-8");
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis == null) fis.close();
        }
        return null;
    }

    private static String getFileContent(FileInputStream fis, String encoding) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(fis, encoding)))
        {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append((line));
                sb.append('\n');
            }
            return sb.toString();
        }
    }

}
