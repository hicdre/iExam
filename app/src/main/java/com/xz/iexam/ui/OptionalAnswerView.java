package com.xz.iexam.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xz.iexam.R;

/**
 * TODO: document your custom view class.
 */
public class OptionalAnswerView extends LinearLayout {
    private TextView textView;

    public OptionalAnswerView(Context context) {
        super(context);
    }

    public OptionalAnswerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.optional_answer_view, this);
        textView=(TextView)findViewById(R.id.textView1);
    }

    /**
     * 设置显示的文字
     */
    public void setTextViewText(String text) {
        textView.setText(text);
    }
}
