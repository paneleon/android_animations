package com.example.playing_with_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class DrawingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Paint paint;
    int color = Color.WHITE;
    int lineThickness = 5;
    Spinner spinner;
    Canvas canvas;
    DrawingView drawingImage;

    // constant variables
    final int INITIAL_COORDINATES = 20;
    final int LINE_INCREMENT = 20;

    // X and Y coordinates for drawing
    private int xStart = INITIAL_COORDINATES;
    private int yStart = INITIAL_COORDINATES;
    private int xEnd = INITIAL_COORDINATES;
    private int yEnd = INITIAL_COORDINATES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        // create a new paint object
        paint = new Paint();
        // find drawing view image
        drawingImage = (DrawingView) findViewById(R.id.drawing_image);
        // set
        drawingImage.setImageResource(R.drawable.drawing_canvas);

        spinner = (Spinner) findViewById(R.id.line_thickness);
        // set event handler for spinner
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // set paint color and width
        paint.setColor(color);
        paint.setStrokeWidth(lineThickness);

        // create a bitmap object
        Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        // use that bitmap to create a canvas
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.BLACK); //background
        //setup the image view and set it for the bitmap format/content
        drawingImage.setImageBitmap(bitmap);
        drawingImage.setVisibility(View.VISIBLE);
        drawingImage.setCanvas(canvas);
        drawingImage.setPaint(paint);
    }

    // event handler for picking the line thickness in spinner
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        lineThickness = Integer.parseInt(spinner.getSelectedItem().toString());
        paint.setStrokeWidth(lineThickness);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // event handler for color buttons
    public void ChooseColor(View view){
        // choose line color
        switch (view.getId()) {
            case R.id.paint1:
                color = getResources().getColor(R.color.paint1);
                break;
            case R.id.paint2:
                color = getResources().getColor(R.color.paint2);
                break;
            case R.id.paint3:
                color = getResources().getColor(R.color.paint3);
                break;
            case R.id.paint4:
                color = getResources().getColor(R.color.paint4);
                break;
        }

        paint.setColor(color);
    }

    // event handler for up, down, left and right drawing buttons
    public void KeyPressed(View view){
        switch (view.getId()) {
            case R.id.key_up:
                // decrement by line size and set new Y coordinates
                yEnd = yEnd - LINE_INCREMENT;
                draw(canvas);
                break;
            case R.id.key_down:
                // increment by line size and set new Y coordinates
                yEnd = yEnd + LINE_INCREMENT;
                draw(canvas);
                break;
            case R.id.key_left:
                // decrement by line size and set new X coordinates
                xEnd = xEnd - LINE_INCREMENT;
                draw(canvas);
                break;
            case R.id.key_right:
                // increment by line size and set new X coordinates
                xEnd = xEnd + LINE_INCREMENT;
                draw(canvas);
                break;
        }
    }

    // event handler for clear button
    public void clearCanvas(View v)
    {
        // draw over the canvas
        canvas.drawColor(Color.BLACK);
        // set coordinates back to initial
        xStart = INITIAL_COORDINATES;
        yStart = INITIAL_COORDINATES;
        xEnd = INITIAL_COORDINATES;
        yEnd = INITIAL_COORDINATES;
    }

    public void draw(Canvas canvas)
    {
        // set focus on image
        drawingImage.setFocusable(true);
        drawingImage.requestFocus();
        // draw line from start coordinates
        canvas.drawLine(xStart, yStart, xEnd, yEnd, paint);
        // change start x and y coordinate to the new ones after drawing
        xStart = xEnd;
        yStart = yEnd;
    }
}

