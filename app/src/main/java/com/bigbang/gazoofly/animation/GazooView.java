package com.bigbang.gazoofly.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.bigbang.gazoofly.R;

public class GazooView extends View {

    private Bitmap littleGazoo;
    private float xPosition = 0f;
    private float yPosition = 0f;

    private float speed = 10.25f;

    private float xSpeed = speed;
    private float ySpeed = speed;
    private Paint paint = new Paint();

    private boolean paused = false;

    public void setPaused() {
        paused = !paused;
    }

    public GazooView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        littleGazoo = BitmapFactory.decodeResource(getResources(),
                R.drawable.gazoo);
        littleGazoo = Bitmap.createScaledBitmap(littleGazoo, (littleGazoo.getWidth() / 2), (littleGazoo.getHeight() / 2), false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(0x00000000);


        if (xPosition > (getWidth() - littleGazoo.getWidth()) || xPosition < 0)
            xSpeed *= -1;
        if (yPosition > (getHeight() - littleGazoo.getHeight()) || yPosition < 0)
            ySpeed *= -1;

        if (!paused) {
            xPosition += xSpeed;
            yPosition += ySpeed;
        }

        canvas.drawBitmap(littleGazoo, xPosition, yPosition, paint);
        invalidate();
    }
}
