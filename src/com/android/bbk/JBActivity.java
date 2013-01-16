package com.android.bbk;

import android.app.Activity;
import android.os.Bundle;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
public class JBActivity extends Activity {
    /** Called when the activity is first created. */
    
    Toast mToast;
    ImageView mContent;
    int mCount;
    final Handler mHandler = new Handler();

    private View makeView() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        LinearLayout view = new LinearLayout(this);
        view.setOrientation(LinearLayout.VERTICAL);
        view.setLayoutParams(
                new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ));
        final int p = (int)(8 * metrics.density);
        view.setPadding(p, p, p, p);

        Typeface light = Typeface.create("sans-serif-light", Typeface.NORMAL);
        Typeface normal = Typeface.create("sans-serif", Typeface.BOLD);

        final float size = 14 * metrics.density;
        final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER_HORIZONTAL;
        lp.bottomMargin = (int) (-4*metrics.density);

        TextView tv = new TextView(this);
        if (light != null) tv.setTypeface(light);
        tv.setTextSize(1.25f*size);
        tv.setTextColor(0xFFFFFFFF);
        tv.setShadowLayer(4*metrics.density, 0, 2*metrics.density, 0x66000000);
        tv.setText("Android " + Build.VERSION.RELEASE);
        view.addView(tv, lp);
   
        tv = new TextView(this);
        if (normal != null) tv.setTypeface(normal);
        tv.setTextSize(size);
        tv.setTextColor(0xFFFFFFFF);
        tv.setShadowLayer(4*metrics.density, 0, 2*metrics.density, 0x66000000);
        tv.setText("JELLY BEAN");
        view.addView(tv, lp);

        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToast = Toast.makeText(this, "", Toast.LENGTH_LONG);
        mToast.setView(makeView());

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        mContent = new ImageView(this);
        mContent.setImageResource(R.drawable.platlogo_alt_jb);
        mContent.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        
        final int p = (int)(32 * metrics.density);
        mContent.setPadding(p, p, p, p);

        mContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToast.show();
                mContent.setImageResource(R.drawable.platlogo_jb);
            }
        });

        mContent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                	Intent intent = new Intent();
                	intent.setClass(JBActivity.this,BeanBag.class);
                	startActivity(intent);
                /*    startActivity(new Intent(Intent.ACTION_MAIN)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                        .addCategory("com.android.internal.category.PLATLOGO"));
                        //.setClassName("com.android.systemui","com.android.systemui.BeanBag"));
                         */
                } catch (ActivityNotFoundException ex) {
                    android.util.Log.e("PlatLogoActivity", "Couldn't find a bag of beans.");
                }
                finish();
                return true;
            }
        });
        
        setContentView(mContent);
    }
}
