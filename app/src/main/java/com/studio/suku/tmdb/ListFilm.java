package com.studio.suku.tmdb;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListFilm extends AppCompatActivity {

    RecyclerView rc;
    FilmAdapter adapter;
    List<MoviesResults> beanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_film);

        rc = findViewById(R.id.list);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(this));

        FilmViewModel filmViewModel = ViewModelProviders.of(this).get(FilmViewModel.class);

        filmViewModel.getFilms().observe(this, new Observer<MoviesResults>() {
            @Override
            public void onChanged(@Nullable MoviesResults moviesResults) {
                beanList.add(moviesResults);
                adapter = new FilmAdapter(ListFilm.this, beanList);
                rc.setAdapter(adapter);
            }
        });

    }
}
