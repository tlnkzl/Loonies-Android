package com.android.loonies.UIElements;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class LightTextView extends androidx.appcompat.widget.AppCompatTextView {
    public LightTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LightTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Light.ttf");
        setTypeface(tf);
    }
}
