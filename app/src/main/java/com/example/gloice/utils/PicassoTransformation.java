package com.example.gloice.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Transformation;

public class PicassoTransformation implements Transformation {
    private Context context;
    private ImageView imageView;

    public PicassoTransformation(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = null;
        if (wm != null) {
            display = wm.getDefaultDisplay();
        }
        Point size = new Point();
        int height = 600;
        if (display != null) {
            display.getSize(size);
            height = size.y;
        }
        Log.d("size",height+"");
        if (source.getWidth() < source.getHeight()) {
            imageView.getLayoutParams().height = (int) (height * 0.756);
        } else {
            imageView.getLayoutParams().height = (int) (height * 0.55);
        }

        return source;
    }

    @Override
    public String key() {
        return "new Transform";
    }
}
