package com.muhammad_adi_yusuf.projeksubmission2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.muhammad_adi_yusuf.projeksubmission2.R;
import com.muhammad_adi_yusuf.projeksubmission2.adapter.AdapterVpager;
import com.muhammad_adi_yusuf.projeksubmission2.fragment.MovieList;
import com.muhammad_adi_yusuf.projeksubmission2.fragment.TvShowList;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tbScroll = findViewById(R.id.tb_activity_main);
        setSupportActionBar(tbScroll);
        TabLayout tabLayout = findViewById(R.id.tl_activity_main);
        ViewPager viePager = findViewById(R.id.vp_activity_main);
        AdapterVpager adapTer = new AdapterVpager(getSupportFragmentManager());

        adapTer.AddFragment(new MovieList(), getString(R.string.tab1));
        adapTer.AddFragment(new TvShowList(), getString(R.string.tab2));


        viePager.setAdapter(adapTer);
        tabLayout.setupWithViewPager(viePager);

        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setElevation(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.change_language) {
            Intent newIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(newIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
