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
import com.example.aplikasibelajar.SharedPreferences.PrefManager;
import com.example.aplikasibelajar.UtilsApi.ApiInterface;
import com.example.aplikasibelajar.UtilsApi.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultSoalActivity extends AppCompatActivity {

    Context context;
    PrefManager manager;
    ApiInterface apiInterface;

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
        manager = new PrefManager(context);
        apiInterface = UtilsApi.getApiLogin();

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
        String hasilSkor = intent.getStringExtra("skor");
        
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
                sendScore(hasilSkor,idSoal);
            }
        });
    }

    private void sendScore(String hasilSkor, String idSoal) {
        String idSiswa = manager.getIdSiswa();
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        apiInterface.sendScore(idSiswa,idSoal,date,hasilSkor).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject object = new JSONObject(response.body().string());
                        if (object.getString("status").equals("200")){
                            Toast.makeText(context, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                            Intent goHome = new Intent(getApplicationContext(), MainActivity.class);
                            goHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            finish();
                            startActivity(goHome);
                        }else {
                            Toast.makeText(context, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        JSONObject object = new JSONObject(response.errorBody().string());
                        Toast.makeText(context, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, "Cek Koneksi Internet", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}
