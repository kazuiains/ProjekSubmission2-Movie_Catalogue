package com.muhammad_adi_yusuf.projeksubmission2.fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muhammad_adi_yusuf.projeksubmission2.R;
import com.muhammad_adi_yusuf.projeksubmission2.activity.DetailActivity;
import com.muhammad_adi_yusuf.projeksubmission2.adapter.AdapterRview;
import com.muhammad_adi_yusuf.projeksubmission2.listener.IcsRecyclerView;
import com.muhammad_adi_yusuf.projeksubmission2.model.DataList;

import java.util.ArrayList;

public class MovieList extends Fragment {

    private String[] dataTitle, dataGenre, dataRelease, dataOverview, dataLanguage, dataRuntime, dataCrew, dataRate;
    private TypedArray dataImage;

    private ArrayList<DataList> dataListmovie;

    public MovieList() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup conTainer, @Nullable
            Bundle savedInstanceState) {

        View viEw = inflater.inflate(R.layout.fragment_movie_list, conTainer, false);

        RecyclerView rvMovie = viEw.findViewById(R.id.rv_movie);
        AdapterRview rvAdapter = new AdapterRview(getContext(), dataListmovie);
        rvMovie.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvMovie.setAdapter(rvAdapter);

        IcsRecyclerView.addTo(rvMovie).setOnItemClickListener(new IcsRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int poSition, View v) {

                DataList iTem = dataListmovie.get(poSition);
                Intent intentJump = new Intent(getContext(), DetailActivity.class);
                intentJump.putExtra(DetailActivity.EXTRA_MOVIE_MAY, iTem);
                startActivity(intentJump);

            }
        });

        return viEw;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InisialArray();
        AddItem();

    }

    private void AddItem() {
        dataListmovie = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            DataList liSt = new DataList();
            liSt.setDataImage(dataImage.getResourceId(i, 1));
            liSt.setDataTitle(dataTitle[i]);
            liSt.setDataRate(dataRate[i]);
            liSt.setDataRelease(dataRelease[i]);
            liSt.setDataGenre(dataGenre[i]);
            liSt.setDataLanguage(dataLanguage[i]);
            liSt.setDataRuntime(dataRuntime[i]);
            liSt.setDataCrew(dataCrew[i]);
            liSt.setDataOverview(dataOverview[i]);
            dataListmovie.add(liSt);
        }
    }

    private void InisialArray() {
        dataTitle = getResources().getStringArray(R.array.data_title_movie);
        dataGenre = getResources().getStringArray(R.array.data_genre_movie);
        dataRate = getResources().getStringArray(R.array.data_rating_movie);
        dataRelease = getResources().getStringArray(R.array.data_release_movie);
        dataLanguage = getResources().getStringArray(R.array.data_language_movie);
        dataRuntime = getResources().getStringArray(R.array.data_runtime_movie);
        dataCrew = getResources().getStringArray(R.array.data_crew_movie);
        dataOverview = getResources().getStringArray(R.array.data_overview_movie);
        dataImage = getResources().obtainTypedArray(R.array.data_poster_movie);
    }

}
