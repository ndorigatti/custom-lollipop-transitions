package com.alexjlockwood.transitions.custom.activity;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexjlockwood.transitions.custom.EnterSharedElementCallback2;
import com.alexjlockwood.transitions.custom.R;
import com.alexjlockwood.transitions.custom.TransitionUtils;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        TextView bigtitle = (TextView) findViewById(R.id.title_big);
        bigtitle.setText(getIntent().getStringExtra("bigtitle"));
        //ViewCompat.setTransitionName(bigtitle, "bigtitle");

        TextView subtitle = (TextView) findViewById(R.id.subtitle);
        subtitle.setText(getIntent().getStringExtra("subtitle"));
        //ViewCompat.setTransitionName(subtitle, "subtitle");

        ImageView image = (ImageView) findViewById(R.id.thumbnail);
        ViewCompat.setTransitionName(image, "thumbnail");

        List<String> textNames = new ArrayList<>();
        textNames.add("bigtitle");
        textNames.add("subtitle");
        List<String> imgNames = new ArrayList<>();
        imgNames.add("thumbnail");
        //getWindow().setEnterTransition(TransitionUtils.makeEnterTransition());
        getWindow().setSharedElementEnterTransition(TransitionUtils.makeSharedElementEnterTransition(textNames, imgNames, textNames));
        setEnterSharedElementCallback(new EnterSharedElementCallback2(this));
    }

}
