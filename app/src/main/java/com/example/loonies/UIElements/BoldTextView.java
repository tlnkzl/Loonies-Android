package com.example.loonies.UIElements;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class BoldTextView  extends android.support.v7.widget.AppCompatTextView{
    public BoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BoldTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-ExtraBold.ttf");
        setTypeface(tf);
    }
}
