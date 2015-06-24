package it.dorigatti.android.circularrevealshared;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class CircularRevealActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_circular_reveal_start);
        setContentView(R.layout.activity_circular_reveal_start);
        FrameLayout fl = (FrameLayout) findViewById(R.id.card_row_thumb_feedback);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch(v);
            }
        });
    }

    public void launch(View view) {
        //view.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        Intent intent = new Intent(this, DetailActivity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, view, "hello");
        startActivity(intent, options.toBundle());
    }
}
