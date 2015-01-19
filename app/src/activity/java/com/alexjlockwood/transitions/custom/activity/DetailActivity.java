package com.alexjlockwood.transitions.custom.activity;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexjlockwood.transitions.custom.EnterSharedElementCallback;
import com.alexjlockwood.transitions.custom.R;
import com.alexjlockwood.transitions.custom.TransitionUtils;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView image = (ImageView) findViewById(R.id.thumbnail);
        ViewCompat.setTransitionName(image, "thumbnail");

        TextView bigtitle = (TextView) findViewById(R.id.title_big);
        bigtitle.setText(getIntent().getStringExtra("bigtitle"));
        //ViewCompat.setTransitionName(bigtitle, "bigtitle");

        TextView subtitle = (TextView) findViewById(R.id.subtitle);
        subtitle.setText(getIntent().getStringExtra("subtitle"));
        //ViewCompat.setTransitionName(subtitle, "subtitle");
        getWindow().setEnterTransition(TransitionUtils.makeEnterTransition());
        getWindow().setSharedElementEnterTransition(TransitionUtils.makeSharedElementEnterTransition(this));
        setEnterSharedElementCallback(new EnterSharedElementCallback(this));
    }

}
