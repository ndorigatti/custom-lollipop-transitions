package com.alexjlockwood.transitions.custom;

import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionSet;

import java.util.List;

public final class TransitionUtils {

    /**
     * Returns a modified enter transition that excludes the navigation bar and status
     * bar as targets during the animation. This ensures that the navigation bar and
     * status bar won't appear to "blink" as they fade in/out during the transition.
     */
    public static Transition makeEnterTransition() {
        Transition fade = new Fade();
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        return fade;
    }

    /**
     * Returns a transition that will (1) move the shared element to its correct size
     * and location on screen, (2) gradually increase/decrease the shared element's
     * text size, and (3) gradually alters the shared element's text color through out
     * the transition.
     */
    public static Transition makeSharedElementEnterTransition(Context context) {
        TransitionSet set = new TransitionSet();
        set.setOrdering(TransitionSet.ORDERING_TOGETHER);

        Transition recolor = new Recolor();
        recolor.addTarget(R.id.hello_world);
        recolor.addTarget(context.getString(R.string.hello_world));
        set.addTransition(recolor);

        Transition changeBounds = new ChangeBounds();
        changeBounds.addTarget(R.id.hello_world);
        changeBounds.addTarget(context.getString(R.string.hello_world));
        set.addTransition(changeBounds);

        Transition textSize = new TextSizeTransition();
        textSize.addTarget(R.id.hello_world);
        textSize.addTarget(context.getString(R.string.hello_world));
        set.addTransition(textSize);

        return set;
    }

    public static Transition makeSharedElementEnterTransition(List<String> textTransitionNames,
                                                              List<String> imageNames) {
        TransitionSet set = new TransitionSet();
        set.setOrdering(TransitionSet.ORDERING_TOGETHER);

        Transition recolor = new Recolor();
        Transition changeBounds = new ChangeBounds();
        Transition textSize = new TextSizeTransition();

        for (String textTName : textTransitionNames) {
            changeBounds.addTarget(textTName);
            textSize.addTarget(textTName);
            recolor.addTarget(textTName);
        }

        set.addTransition(recolor);
        set.addTransition(changeBounds);
        set.addTransition(textSize);


        Transition imageTransf = new ChangeImageTransform();
        Transition imageClip = new ChangeClipBounds();
        Transition changeTransform = new ChangeTransform();
        for (String imgName : imageNames) {
            changeBounds.addTarget(imgName);
            imageTransf.addTarget(imgName);
            imageClip.addTarget(imgName);
            changeTransform.addTarget(imgName);
        }

        set.addTransition(imageTransf);
        //set.addTransition(imageClip);
        set.addTransition(changeTransform);


        //set.setDuration(5000);
        return set;
    }

    private TransitionUtils() {
    }
}
