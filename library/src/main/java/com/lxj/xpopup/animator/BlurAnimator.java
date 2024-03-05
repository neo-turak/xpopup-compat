package com.lxj.xpopup.animator;

import android.animation.FloatEvaluator;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.util.XPopupUtils;

/**
 * Description: 背景模糊动画器
 * Create by dance, at 2018/12/9
 */
public class BlurAnimator extends PopupAnimator {

    private final FloatEvaluator evaluate = new FloatEvaluator();
    public int shadowColor;
    public BlurAnimator(View target,  int shadowColor) {
        super(target, 0);
        this.shadowColor = shadowColor;
    }
    public Bitmap decorBitmap;
    public boolean hasShadowBg = false;

    public BlurAnimator() {}
    @Override
    public void initAnimator() {
        Bitmap blurBmp = XPopupUtils.renderScriptBlur(targetView.getContext(), decorBitmap,  10, true);
        BitmapDrawable drawable = new BitmapDrawable(targetView.getResources(), blurBmp);
        if(hasShadowBg) drawable.setColorFilter(shadowColor, PorterDuff.Mode.SRC_OVER);
        targetView.setBackground(drawable);
    }

    @Override
    public void animateShow() {

    }

    @Override
    public void animateDismiss() {
    }


}
