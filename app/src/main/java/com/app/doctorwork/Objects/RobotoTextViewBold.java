package com.app.doctorwork.Objects;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Anagh Vijayvargia on 3/12/2016.
 */
public class RobotoTextViewBold extends android.support.v7.widget.AppCompatTextView {
    public RobotoTextViewBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoTextViewBold(Context context) {
        super(context);
        init();
    }

    public void init() {

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Bold.ttf");
        setTypeface(tf, 1);

    }
}