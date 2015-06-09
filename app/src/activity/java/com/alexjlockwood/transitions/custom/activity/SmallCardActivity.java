package com.alexjlockwood.transitions.custom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alexjlockwood.transitions.custom.R;

public class SmallCardActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_row_layout_simple);
        findViewById(R.id.container).setOnClickListener(this);
        //getWindow().setEnterTransition(TransitionUtils.makeEnterTransition());

//        List<String> textNames = new ArrayList<>();
//        textNames.add("bigtitle");
//        textNames.add("subtitle");
//        List<String> imgNames = new ArrayList<>();
//        imgNames.add("thumbnail");

        //getWindow().setSharedElementEnterTransition(TransitionUtils.makeSharedElementEnterTransition(textNames, imgNames, textNames));
//        TextView bigTitle = (TextView) findViewById(R.id.title_big);
//        bigTitle.getTextSize();

       // setEnterSharedElementCallback(new EnterSharedElementCallback2(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_small_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        SmallCardActivity.this,
                        Pair.create(v.findViewById(R.id.title_big), "bigtitle"),
                        Pair.create(v.findViewById(R.id.subtitle), "subtitle"),
                        Pair.create(v.findViewById(R.id.card_row_thumbnail), "thumbnail"));

        Intent intent = new Intent(SmallCardActivity.this, DetailActivity.class);
        intent.putExtra("bigtitle", "Gazzetta Dello Sport");
        intent.putExtra("subtitle", "Sabato 13 Dicembre, 2014");
        intent.putExtra("status", false);
        ActivityCompat.startActivity(SmallCardActivity.this, intent, options.toBundle());

    }
}
