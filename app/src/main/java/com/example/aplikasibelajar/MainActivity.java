package com.example.aplikasibelajar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.aplikasibelajar.About.AboutActivity;
import com.example.aplikasibelajar.Jobsheet.JobsheetActivity;
import com.example.aplikasibelajar.Materi.MateriActivity;
import com.example.aplikasibelajar.RPP.RppActivity;
import com.example.aplikasibelajar.SharedPreferences.PrefManager;
import com.example.aplikasibelajar.Silabus.SilabusActivity;
import com.example.aplikasibelajar.Soal.SoalActivity;
import com.example.aplikasibelajar.Video.VideoActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;

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
        cardJobsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jobsheet = new Intent(getApplicationContext(), JobsheetActivity.class);
                startActivity(jobsheet);
            }
        });
        cardVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(video);
            }
        });
        cardSilabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent silabus = new Intent(getApplicationContext(), SilabusActivity.class);
                startActivity(silabus);
            }
        });
        cardSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent soal = new Intent(getApplicationContext(), SoalActivity.class);
                startActivity(soal);
            }
        });
        cardrpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpp = new Intent(getApplicationContext(), RppActivity.class);
                startActivity(rpp);
            }
        });
    }
}
