package com.android.loonies.UIElements;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RegularTextView extends androidx.appcompat.widget.AppCompatTextView {

    public RegularTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RegularTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Regular.ttf");
        setTypeface(tf);
    }

}