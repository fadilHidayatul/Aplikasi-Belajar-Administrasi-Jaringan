package com.example.aplikasibelajar.RPP;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

    @BindView(R.id.toolbarReadRpp)
    Toolbar toolbarReadRpp;
    @BindView(R.id.container)
    LinearLayout container;

    Context context;
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
        String idRPP = intent.getStringExtra("idRPP"); //tampil berdasarkan id
        String pdf = intent.getStringExtra("pdf");

        remotePDFViewPager = new RemotePDFViewPager(this,"https://jaringan.mantagi.com/Rpp/download/"+pdf,this);

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
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
