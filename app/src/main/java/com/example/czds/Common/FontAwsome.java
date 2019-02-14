package com.example.czds.Common;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class FontAwsome extends android.support.v7.widget.AppCompatTextView {

        public FontAwsome(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }

        public FontAwsome(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public FontAwsome(Context context) {
            super(context);
            init();
        }

        private void init() {
            //Font name should not contain "/".
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                    "fontawesome.ttf");
            setTypeface(tf);

    }
}
