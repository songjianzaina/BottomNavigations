package com.wy.bottomNavigations.adaptablebottomnavigation.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wy.bottomNavigations.R;
import com.wy.bottomNavigations.adaptablebottomnavigation.view.AdaptableBottomNavigationView;
import com.wy.bottomNavigations.adaptablebottomnavigation.view.ViewSwapper;


public class AdaptableActivity extends AppCompatActivity {

    private AdaptableBottomNavigationView bottomNavigationView;
    private ViewSwapperAdapter viewSwapperAdapter;
    private ViewSwapper viewSwapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptable);

        bottomNavigationView = (AdaptableBottomNavigationView)
                findViewById(R.id.view_bottom_navigation);
        viewSwapper = (ViewSwapper) findViewById(R.id.view_swapper);
        viewSwapperAdapter = new ViewSwapperAdapter(getSupportFragmentManager());

        viewSwapper.setAdapter(viewSwapperAdapter);
        bottomNavigationView.setupWithViewSwapper(viewSwapper);
    }
}
