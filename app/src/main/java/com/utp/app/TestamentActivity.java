package com.utp.app;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestamentActivity extends AppCompatActivity {

    RadioGroup rgImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testament);

        rgImage = findViewById(R.id.radioImage);
    }

    public void onClickSaveImage(View v) {
        int radioButtonID = rgImage.getCheckedRadioButtonId();
        View radioButton = rgImage.findViewById(radioButtonID);

        String radioButtonIdSelected = getResources().getResourceEntryName(radioButton.getId());

        Toast.makeText(
                this,
                StorageManager.save(this, radioButtonIdSelected)
                        ? "Image saved successfully"
                        : "Image was not saved",
                Toast.LENGTH_SHORT).show();
    }

    public void onClickGoBack(View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

}

 /*
    public void onClickSaveImage(View v) {

        int radioButtonID = rgImage.getCheckedRadioButtonId();
        View radioButton = rgImage.findViewById(radioButtonID);

        String radioButtonIdSelected = getResources().getResourceEntryName(radioButton.getId());

        Log.i("result", String.valueOf(StorageManager.save(this, radioButtonIdSelected)));


            ActivityCompat.requestPermissions(TestamentActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.christian);

            File path = Environment.getExternalStorageDirectory();

            File dir = new File(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Camera/");
            dir.mkdirs();

            File file = new File(dir, "christian.jpg");

            OutputStream outputStream = null;

            try {
                outputStream = new FileOutputStream(file);
                image.compress(Bitmap.CompressFormat.JPEG,100, outputStream);
                outputStream.flush();
                outputStream.close();
                Log.i("saved", "was saved");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
*/
