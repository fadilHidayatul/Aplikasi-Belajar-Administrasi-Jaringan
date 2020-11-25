package com.example.aplikasibelajar.Silabus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.aplikasibelajar.R;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class SilabusActivity extends AppCompatActivity implements DownloadFile.Listener {
    Context context;
    PDFPagerAdapter adapter;
    RemotePDFViewPager remotePDFViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silabus);
        context = this;

        remotePDFViewPager = new RemotePDFViewPager(this,"https://media.neliti.com/media/publications/132386-ID-analisis-kualitas-aplikasi-ujian-online.pdf",this);

    }

    @Override
    public void onSuccess(String url, String destinationPath) {
    adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
    remotePDFViewPager.setAdapter(adapter);

    LinearLayout container = (LinearLayout)findViewById(R.id.container);
        container.addView(remotePDFViewPager,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(context, "PDF tidak bisa ditampilkan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }
}
