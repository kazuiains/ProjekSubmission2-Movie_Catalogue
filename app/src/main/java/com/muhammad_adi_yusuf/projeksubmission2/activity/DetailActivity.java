package com.muhammad_adi_yusuf.projeksubmission2.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.muhammad_adi_yusuf.projeksubmission2.R;
import com.muhammad_adi_yusuf.projeksubmission2.model.DataList;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE_MAY = "extra_movie_may";
    TextView dataTitle, dataTitle2, dataGenre, dataRelease, dataOverview, dataLanguage, dataRuntime, dataCrew, dataRate;
    ImageView dataImage, dataBackimage;
    public String toolBartitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolBar = findViewById(R.id.tb_activity_detail);
        setSupportActionBar(toolBar);

        initCollapsingToolbar();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        dataTitle = findViewById(R.id.tv_detail_title);
        dataTitle2 = findViewById(R.id.tv_Dtitle);
        dataGenre = findViewById(R.id.tv_Dgenre);
        dataRelease = findViewById(R.id.tv_Drelease);
        dataOverview = findViewById(R.id.tv_Doverview);
        dataLanguage = findViewById(R.id.tv_Dlanguage);
        dataRuntime = findViewById(R.id.tv_Druntime);
        dataCrew = findViewById(R.id.tv_Dcrew);
        dataRate = findViewById(R.id.tv_detail_rate);

        dataImage = findViewById(R.id.iv_detail_image);
        dataBackimage = findViewById(R.id.iv_backimage);

        DataList detailItem = getIntent().getParcelableExtra(EXTRA_MOVIE_MAY);
        assert detailItem != null;
        dataTitle.setText(detailItem.getDataTitle());
        dataTitle2.setText(detailItem.getDataTitle());
        dataGenre.setText(detailItem.getDataGenre());
        dataRelease.setText(detailItem.getDataRelease());
        dataOverview.setText(detailItem.getDataOverview());
        dataLanguage.setText(detailItem.getDataLanguage());
        dataRuntime.setText(detailItem.getDataRuntime());
        dataCrew.setText(detailItem.getDataCrew());
        dataRate.setText(detailItem.getDataRate());
        dataImage.setImageResource(detailItem.getDataImage());
        dataBackimage.setImageResource(detailItem.getDataImage());

        toolBartitle = detailItem.getDataTitle();
    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout coolToolbar = findViewById(R.id.ctbl_collapsing);
        coolToolbar.setTitle(" ");
        AppBarLayout appBlayout = findViewById(R.id.al_activity_detail);
        appBlayout.setExpanded(true);

        appBlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBlayout, int verticalValue) {
                if (scrollRange == -1) {
                    scrollRange = appBlayout.getTotalScrollRange();
                }
                if (scrollRange + verticalValue == 0) {
                    coolToolbar.setTitle(toolBartitle);
                    isShow = true;
                } else if (isShow) {
                    coolToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
