package com.natodriod.customview.shapescustomview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.natodriod.customview.shapescustomview.R;

/**
 * Created by natiqmustafa on 07.06.2017.
 */

public class ShapeDraw extends android.view.View {


    private static final int SQUARE_SIZE_DEF = 200;

    private Rect mRect;
    private Paint p;
    private int mSquareColor;
    private int mSquareSize;
    private Paint mPaintCircle;

    public ShapeDraw(Context context) {
        super(context);
        init(null);
    }

    public ShapeDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ShapeDraw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ShapeDraw(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        mRect = new Rect();

        p = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setColor(Color.parseColor("#00ccff"));


        if (set == null)
            return;

        TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.ShapeDraw);
        mSquareColor = typedArray.getColor(R.styleable.ShapeDraw_square_color, Color.GREEN);
        mSquareSize = typedArray.getDimensionPixelSize(R.styleable.ShapeDraw_square_size, SQUARE_SIZE_DEF);
        p.setColor(mSquareColor);

    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(Color.RED);


        mRect.left =  50;
        mRect.top = 50;
        mRect.right = mRect.left + mSquareSize;
        mRect.bottom= mRect.top + mSquareSize;
        canvas.drawRect(mRect, p);


        float cx, cy;
        float radius = 100f;

        cx = getWidth() - radius - 50f;
        cy = mRect.top + (mRect.height() / 2);

        canvas.drawCircle(cx, cy, radius, mPaintCircle);

    }

    public void swapColor(){
//        Log.d("Custom_View", "swapColor: " + c);
        p.setColor(p.getColor() == mSquareColor ? Color.RED : mSquareColor);
        postInvalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
    }

}
