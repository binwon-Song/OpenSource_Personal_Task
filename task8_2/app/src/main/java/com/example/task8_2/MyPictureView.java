package com.example.task8_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyPictureView extends View {
    public String imagePath = null;
    private Bitmap bitmap=null;
    public MyPictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (imagePath != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                // 이미지 파일을 decode하여 Bitmap 객체 생성
                bitmap = BitmapFactory.decodeFile(imagePath);
                if (bitmap == null) {
                    // 이미지 파일이 존재하지 않는 경우 예외 처리
                    return;
                }
            }
            canvas.drawBitmap(bitmap, 0, 0, null);
        }
}}