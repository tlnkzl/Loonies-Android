package com.android.loonies.UIElements;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SemiBoldTextView extends androidx.appcompat.widget.AppCompatTextView {

    public SemiBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public SemiBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SemiBoldTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-SemiBold.ttf");
        setTypeface(tf);
    }
}

