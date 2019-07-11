package com.awatef.loggin;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by awatef on 2/24/2019.
 */

public class AnimationUtil {
    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown){
        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator animatorTranslateY= ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true ? 300 : -300, 0);
       animatorTranslateY.setDuration(1000);
        animatorSet.playTogether(animatorTranslateY);
        animatorSet.start();
    }
}
