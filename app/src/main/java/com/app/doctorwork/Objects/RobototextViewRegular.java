package com.app.doctorwork.Objects;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by abhishek on 10/5/2016.
 */

public class RobototextViewRegular extends android.support.v7.widget.AppCompatTextView {

    public RobototextViewRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobototextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobototextViewRegular(Context context) {
        super(context);
        init();
    }

    public void init() {

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
        setTypeface(tf, 1);

    }

}