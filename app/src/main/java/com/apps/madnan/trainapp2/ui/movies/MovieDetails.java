package com.apps.madnan.trainapp2.ui.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.madnan.trainapp2.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetails extends AppCompatActivity {

    @BindView(R.id.details_titleTV)
    TextView detailsTitleTV;
    @BindView(R.id.details_overviewTV)
    TextView detailsOverviewTV;
    @BindView(R.id.datailsIV)
    ImageView datailsIV;

    String title, overview, poster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        ButterKnife.bind(this);

        title = getIntent().getStringExtra("title");
        overview = getIntent().getStringExtra("overview");
        poster = getIntent().getStringExtra("poster");

        detailsTitleTV.setText(title);
        detailsOverviewTV.setText(overview);

        Glide.with(this)
                .load(poster)
                .into(datailsIV);
    }
}
