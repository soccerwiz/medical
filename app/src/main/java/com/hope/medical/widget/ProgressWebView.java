package com.hope.medical.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.hope.medical.activity.MainActivity;


/**
 * Created by wutao on 2016/2/25.
 */
public class ProgressWebView  extends WebView{
    public static CircleLoadingView circleLoadingView;
    Context context;

    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        circleLoadingView = new CircleLoadingView(context,
                  attrs);
        circleLoadingView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                  LayoutParams.MATCH_PARENT, 0, 0));
        addView(circleLoadingView);
        circleLoadingView.startLoading();
        // setWebViewClient(new WebViewClient(){});
        //是否可以缩放
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) circleLoadingView.getLayoutParams();
        lp.x = l;
        lp.y = t;
        circleLoadingView.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
