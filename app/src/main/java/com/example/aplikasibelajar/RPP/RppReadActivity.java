package com.example.aplikasibelajar.RPP;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aplikasibelajar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class RppReadActivity extends AppCompatActivity implements DownloadFile.Listener {

    Context context;
    @BindView(R.id.toolbarReadRpp)
    Toolbar toolbarReadRpp;
    @BindView(R.id.container)
    LinearLayout container;

    RemotePDFViewPager remotePDFViewPager;
    PDFPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpp_read);
        ButterKnife.bind(this);
        context = this;

        setSupportActionBar(toolbarReadRpp);
        getSupportActionBar().setTitle("RPP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        String idRPP = intent.getStringExtra("idRPP");
        Toast.makeText(context, ""+idRPP, Toast.LENGTH_SHORT).show();

        remotePDFViewPager = new RemotePDFViewPager(this,"https://media.neliti.com/media/publications/132386-ID-analisis-kualitas-aplikasi-ujian-online.pdf",this);

    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter);

        LinearLayout linearLayout = findViewById(R.id.container);
        linearLayout.addView(remotePDFViewPager,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(context, "PDF Cannot open", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.close();
    }
}