package com.example.appsenzen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Circle extends View {

    private Paint color;
    private float radius;
    private RectF mArcBounds = new RectF();

    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint(){
        color = new Paint(Paint.ANTI_ALIAS_FLAG);
        color.setStyle(Paint.Style.STROKE);
        color.setColor(Color.parseColor("#6200EE"));
        color.setStrokeWidth(5 * getResources().getDisplayMetrics().density);
        color.setStrokeCap(Paint.Cap.SQUARE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        radius = Math.min(w, h) / 2f;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        int size = Math.min(w, h);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Float drawUpto = 46f;

        float mouthInset = radius / 3f;
        mArcBounds.set(mouthInset, mouthInset, radius * 2 - mouthInset, radius * 2 - mouthInset);

        canvas.drawArc(mArcBounds, 270f, drawUpto, false, color);


    }

}
