package com.example.applic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

import androidx.annotation.RequiresApi;

import static java.lang.Thread.sleep;


public class MyView extends View {
    int N = 8; // количество шариков
    float[] x = new float[N];
    float[] y = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    float[] Green = new float[N];
    float[] Red = new float[N];
    float[] Orange = new float[N];
    float[] vb = new float[N];

    float rand(float min, float max) {
        return (float) (Math.random() * (max - min + 1)) + min;
    }

    // Заполняет массив псевдослучайными числами в полуинтервале [min, max)
    void fillRandom(float[] array, float min, float max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand(min, max);
        }
    }

    public MyView(Context context) {
        super(context);
        for (int i = 0; i < N; i++) {
            fillRandom(x, 0, 500);
            fillRandom(y, 0, 500);
            fillRandom(vx, -3, 3);
            fillRandom(vy, -3,  3);
            fillRandom(Green, 0, 500);
            fillRandom(Red, 0, 500);
            fillRandom(Orange, -3, 3);
            fillRandom(vb, -3,  3);
        }
    }

    void add(float[] array, float[] values) {
        for (int i = 0; i < array.length; i++) {
            array[i] += values[i];
        }
    }

    Paint paint = new Paint();
    void drawBalls(Canvas canvas){
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
            if (x[i] < 0 || x[i] > this.getWidth()) {
                vx[i] = -vx[i];
            }
            if (y[i] < 0 || y[i] > this.getHeight()) {
                vy[i] = -vy[i];
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onDraw(Canvas canvas) {
        add(x, vx);
        add(y, vy);
        drawBalls(canvas);
        paint.setColor(Color.BLUE);
            invalidate();
        }

    }




