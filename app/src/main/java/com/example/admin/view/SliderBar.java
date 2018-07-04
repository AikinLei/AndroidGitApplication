package com.example.admin.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author leixinqiao
 * @version 1.0
 * @since: on 2018/07/02  17:16
 * @Description
 */
public class SliderBar extends View {

    private Paint mPaint = new Paint();
    private String[] mLetterArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    public SliderBar(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
    }

    public SliderBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public SliderBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();

        int singleHeight = measuredHeight / mLetterArray.length;


        for (int i = 0; i < mLetterArray.length; i++) {
            float pointX = measuredWidth / 2 - mPaint.measureText(mLetterArray[i]) / 2;
            if (i == mIndex) {
                mPaint.setColor(Color.RED);
            } else {
                mPaint.setColor(Color.BLACK);
            }
            float pointY = singleHeight * i + singleHeight;
            canvas.drawText(mLetterArray[i], pointX, pointY, mPaint);
        }

    }


    private int mIndex = -1;


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float y = event.getY();
        int v = (int) (y / (getHeight() / mLetterArray.length));

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mIndex = v;
                break;

            case MotionEvent.ACTION_MOVE:
                mIndex = v;
                break;

            case MotionEvent.ACTION_UP:
                mIndex = v;
                break;
        }

        Log.i("Lei", "onTouchEvent: --index--" + mIndex + "----->letter-->" + mLetterArray[mIndex]);

        invalidate();

        return true;
    }
}
