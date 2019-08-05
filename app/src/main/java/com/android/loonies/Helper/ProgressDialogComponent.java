package com.android.loonies.Helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.android.loonies.R;


public class ProgressDialogComponent extends Dialog {

    private Context mContext;

    public ProgressDialogComponent(final Context context) {
        super(context, R.style.progress_dialog_transparent);
        this.setContentView(R.layout.component_progress_dialog);

        mContext = context;
        setCancelable(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ((Activity) mContext).finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView text = getTextView();
        text.setVisibility(TextUtils.isEmpty(text.getText()) ? View.GONE
                : View.VISIBLE);
    }

    public void setText(String text) {
        getTextView().setText(text);
    }

    private TextView getTextView() {
        return (TextView) findViewById(R.id.text);
    }

}
