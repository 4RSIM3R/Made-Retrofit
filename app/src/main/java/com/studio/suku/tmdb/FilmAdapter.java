package com.studio.suku.tmdb;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {

    Context context;
    List<MoviesResults> list;

    public FilmAdapter(Context context, List<MoviesResults> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public FilmAdapter.FilmHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.FilmHolder filmHolder, int i) {
        MoviesResults moviesResults = list.get(i);
        filmHolder.txt.setText(moviesResults.getResults().get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FilmHolder extends RecyclerView.ViewHolder {

        TextView txt;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}
