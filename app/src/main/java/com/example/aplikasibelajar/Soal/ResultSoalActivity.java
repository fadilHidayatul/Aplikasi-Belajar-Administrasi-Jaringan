package com.example.aplikasibelajar.Soal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aplikasibelajar.MainActivity;
import com.example.aplikasibelajar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultSoalActivity extends AppCompatActivity {

    Context context;

    @BindView(R.id.toolbarResult)
    Toolbar toolbarResult;
    @BindView(R.id.txtresult)
    TextView txtresult;
    @BindView(R.id.txtCompliment)
    TextView txtCompliment;
    @BindView(R.id.imgCompliment)
    ImageView imgCompliment;
    @BindView(R.id.btnReplay)
    Button btnReplay;
    @BindView(R.id.btnHome)
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_soal);
        ButterKnife.bind(this);
        context = this;

        setSupportActionBar(toolbarResult);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("SKOR");

        showResult();
        playButton();
    }

    private void showResult() {
        Intent intent = getIntent();
        String hasilSkor = intent.getStringExtra("skor");
        txtresult.setText(hasilSkor);

        int cekskor = Integer.parseInt(hasilSkor);

        if (cekskor >= 80){
            txtCompliment.setText("Excellent");
            imgCompliment.setImageResource(R.drawable.excellent);
        }else if(cekskor >= 50){
            txtCompliment.setText("Not Bad");
            imgCompliment.setImageResource(R.drawable.notbad);
        }else if(cekskor >= 0){
            txtCompliment.setText("Try Harder");
            imgCompliment.setImageResource(R.drawable.tryharder);
        }else{
            Toast.makeText(this, "Not Define", Toast.LENGTH_SHORT).show();
        }
    }

    private void playButton() {
        Intent intent = getIntent();
        String idSoal = intent.getStringExtra("idSoal");
        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent rollback = new Intent(ResultSoalActivity.this, SoalLatihanActivity.class);
                rollback.putExtra("idSoal",idSoal);
                startActivity(rollback);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent goHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goHome);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
