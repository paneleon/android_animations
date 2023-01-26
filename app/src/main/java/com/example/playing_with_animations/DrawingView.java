package com.example.playing_with_animations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;

// Drawing View class extends Image View
public class DrawingView extends androidx.appcompat.widget.AppCompatImageView {

    private Paint paint;
    private Path path;
    private Canvas canvas;
    int lineThickness = 5;

    // constructor
    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // creates new Paint and Path objects
        paint = new Paint();
        path = new Path();

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }
    // setter method for canvas
    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }
    // setter method for paint
    public void setPaint(Paint paint){
        this.paint = paint;
    }

    // setter method for line thickness
    public void setLineThickness(int thickness){
        lineThickness = thickness;
        paint.setStrokeWidth(lineThickness);
    }

    // drawing method
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    // on touch screen event handler
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Get the coordinates of the touch event.
        float eventX = event.getX();
        float eventY = event.getY();

        // identify the moving action
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                // draw point
                canvas.drawPoint(eventX, eventY, paint);
                break;
            default:
                return false;
        }

        // makes view repaint and call onDraw
        invalidate();
        return true;
    }

}
