package com.xheghun.rowtian.tech.app.protoype;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.animation.Interpolator;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class NavigationIconClickListener implements View.OnClickListener {
   private final AnimatorSet animatorSet = new AnimatorSet();
   private Context mContext;
   private View sheet;
   private Interpolator interpolator;
   private int height;
   private boolean backdropShown = false;
   private Drawable openIcon;
   private Drawable closeIcon;

    public NavigationIconClickListener(Context mContext, View sheet) {this.mContext = mContext; this.sheet = sheet;}

    public NavigationIconClickListener(Context mContext, View sheet, @Nullable Interpolator interpolator) {
        this(mContext, sheet, interpolator, null,null);
    }

    public NavigationIconClickListener(
            Context mContext, View sheet, Interpolator interpolator,
            @Nullable Drawable openIcon,@Nullable Drawable closeIcon) {
        this.mContext = mContext;
        this.sheet = sheet;
        this.interpolator = interpolator;
        this.openIcon = openIcon;
        this.closeIcon = closeIcon;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
    }

    @Override
    public void onClick(View view) {
        backdropShown = !backdropShown;

        animatorSet.removeAllListeners();
        animatorSet.end();
        animatorSet.cancel();

        updateIcon(view);

        final int translateY = height -
                mContext.getResources().getDimensionPixelSize(R.dimen.item_grid);
        ObjectAnimator animator = ObjectAnimator.ofFloat(sheet, "translationY", backdropShown ? translateY : 0);
        animator.setDuration(500);
        if (interpolator != null) {
            animator.setInterpolator(interpolator);
        }
        animatorSet.play(animator);
        animator.start();
    }

    private void updateIcon(View view) {
        if (openIcon != null && closeIcon != null) {
            if (!(view instanceof ImageView)) {
                throw new IllegalArgumentException("updateIcon() must be called on an ImageView");
            }
            if (backdropShown) {
                ((ImageView) view).setImageDrawable(closeIcon);
            }else {
                ((ImageView) view).setImageDrawable(openIcon);
            }

        }
    }
}