package com.example.aplikasibelajar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.aplikasibelajar.About.AboutActivity;
import com.example.aplikasibelajar.Materi.MateriActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cardSilabus)
    CardView cardSilabus;
    @BindView(R.id.cardrpp)
    CardView cardrpp;
    @BindView(R.id.cardmateri)
    CardView cardmateri;
    @BindView(R.id.cardVideo)
    CardView cardVideo;
    @BindView(R.id.cardSoal)
    CardView cardSoal;
    @BindView(R.id.cardJobsheet)
    CardView cardJobsheet;
    @BindView(R.id.cardAbout)
    CardView cardAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        cardAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(about);
            }
        });
        cardmateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materi = new Intent(getApplicationContext(), MateriActivity.class);
                startActivity(materi);
            }
        });
    }
}
