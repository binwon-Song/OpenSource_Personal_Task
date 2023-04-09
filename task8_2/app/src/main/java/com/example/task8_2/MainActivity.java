package com.example.task8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button prev, next;
    MyPictureView view;
    int curNum = 0;
    File[] imageFiles;
    String imageFname;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        prev = (Button) findViewById(R.id.previous);
        next = (Button) findViewById(R.id.next);
        view = (MyPictureView) findViewById(R.id.image);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        }
        File[] allFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        List<File> imageFiles = new ArrayList<>();

        for (File file : allFiles) {
            String fileName = file.getName();
            if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
                imageFiles.add(file);
            }
        }

        File[] imageArray = imageFiles.toArray(new File[imageFiles.size()]);

        imageFname = imageArray[curNum].toString();
        view.imagePath = imageFname;

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum <= 0) {
                    Toast.makeText(getApplicationContext(), "첫번째 그림입니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    view.imagePath=imageFname;
                    view.invalidate();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum >= imageFiles.length-2) {
                    Toast.makeText(getApplicationContext(), "마지막 그림입니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    curNum++;
                    imageFname=imageFiles[curNum].toString();
                    view.imagePath=imageFname;
                    view.invalidate();
                }
            }
        });
    }
}