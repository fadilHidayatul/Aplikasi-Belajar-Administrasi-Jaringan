package com.example.aplikasibelajar.Soal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aplikasibelajar.R;

public class ResultSoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_soal);

        Intent intent = getIntent();
        String hasilSkor = intent.getStringExtra("skor");

        Toast.makeText(this, ""+hasilSkor, Toast.LENGTH_SHORT).show();
    }
}
