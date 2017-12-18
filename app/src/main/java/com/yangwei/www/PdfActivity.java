package com.yangwei.www;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.artifex.mupdfdemo.MuPDFActivity;
import com.joanzapata.pdfview.PDFView;
import com.yangwei.www.base.BaseActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yangwei on 2017/12/18.
 */

public class PdfActivity extends BaseActivity {
    public static final String SAMPLE_FILE = "sample.pdf";

    @BindView(R.id.pdf_v)
    PDFView pdfV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        initView();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

//        File file = new File("/storage/emulated/0/jieyueloan/cache/12.pdf");
//        File file = new File("/storage/emulated/0/jieyueloan/cache/");
//        Uri uri = Uri.parse(file.getAbsolutePath());
        Intent intent = new Intent(this, MuPDFActivity.class);
        intent.putExtra("pdf_title", "asd");
        intent.putExtra("file_path", "/storage/emulated/0/jieyueloan/cache/12.pdf");
        intent.putExtra("so_path", "/storage/emulated/0/jieyueloan/cache/libmupdf.so");
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.putExtra("key_pdf_name", "12.pdf");
////        intent.setData(uri);
//        intent.putExtra("file_path", file.getAbsolutePath());
//        intent.putExtra("firstView", true);
        startActivity(intent);
    }
}
