package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.content.Intent;


import java.util.Random;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int COLUMN_COUNT = 10;

    // save the TextViews of all cells in an array, so later on,
    // when a TextView is clicked, we know which cell it is
    private ArrayList<TextView> cell_tvs;
    private boolean flagging;
    private int flagsLeft = 4;
    private boolean visited[];
    {
        visited = new boolean[120];

    }
    private int mineLocations [];
    {
        mineLocations = new int[4];
    }

    private int clock = 0;
    private boolean running = true;
    private int visitedCount = 0;
    private boolean displayWin = false;
    private boolean displayLoss = false;

    private int dpToPixel(int dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cell_tvs = new ArrayList<TextView>();

        if (savedInstanceState != null) {
            clock = savedInstanceState.getInt("clock");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();

        // Method (1): add statically created cells
        TextView tv00 = (TextView) findViewById(R.id.textView00);
        TextView tv01 = (TextView) findViewById(R.id.textView01);
        TextView tv02 = (TextView) findViewById(R.id.textView02);
        TextView tv03 = (TextView) findViewById(R.id.textView03);
        TextView tv04 = (TextView) findViewById(R.id.textView04);
        TextView tv05 = (TextView) findViewById(R.id.textView05);
        TextView tv06 = (TextView) findViewById(R.id.textView06);
        TextView tv07 = (TextView) findViewById(R.id.textView07);
        TextView tv08 = (TextView) findViewById(R.id.textView08);
        TextView tv09 = (TextView) findViewById(R.id.textView09);

        TextView tv10 = (TextView) findViewById(R.id.textView10);
        TextView tv11 = (TextView) findViewById(R.id.textView11);
        TextView tv12 = (TextView) findViewById(R.id.textView12);
        TextView tv13 = (TextView) findViewById(R.id.textView13);
        TextView tv14 = (TextView) findViewById(R.id.textView14);
        TextView tv15 = (TextView) findViewById(R.id.textView15);
        TextView tv16 = (TextView) findViewById(R.id.textView16);
        TextView tv17 = (TextView) findViewById(R.id.textView17);
        TextView tv18 = (TextView) findViewById(R.id.textView18);
        TextView tv19 = (TextView) findViewById(R.id.textView19);

        TextView tv20 = (TextView) findViewById(R.id.textView20);
        TextView tv21 = (TextView) findViewById(R.id.textView21);
        TextView tv22 = (TextView) findViewById(R.id.textView22);
        TextView tv23 = (TextView) findViewById(R.id.textView23);
        TextView tv24 = (TextView) findViewById(R.id.textView24);
        TextView tv25 = (TextView) findViewById(R.id.textView25);
        TextView tv26 = (TextView) findViewById(R.id.textView26);
        TextView tv27 = (TextView) findViewById(R.id.textView27);
        TextView tv28 = (TextView) findViewById(R.id.textView28);
        TextView tv29 = (TextView) findViewById(R.id.textView29);

        TextView tv30 = (TextView) findViewById(R.id.textView30);
        TextView tv31 = (TextView) findViewById(R.id.textView31);
        TextView tv32 = (TextView) findViewById(R.id.textView32);
        TextView tv33 = (TextView) findViewById(R.id.textView33);
        TextView tv34 = (TextView) findViewById(R.id.textView34);
        TextView tv35 = (TextView) findViewById(R.id.textView35);
        TextView tv36 = (TextView) findViewById(R.id.textView36);
        TextView tv37 = (TextView) findViewById(R.id.textView37);
        TextView tv38 = (TextView) findViewById(R.id.textView38);
        TextView tv39 = (TextView) findViewById(R.id.textView39);

        TextView tv40 = (TextView) findViewById(R.id.textView40);
        TextView tv41 = (TextView) findViewById(R.id.textView41);
        TextView tv42 = (TextView) findViewById(R.id.textView42);
        TextView tv43 = (TextView) findViewById(R.id.textView43);
        TextView tv44 = (TextView) findViewById(R.id.textView44);
        TextView tv45 = (TextView) findViewById(R.id.textView45);
        TextView tv46 = (TextView) findViewById(R.id.textView46);
        TextView tv47 = (TextView) findViewById(R.id.textView47);
        TextView tv48 = (TextView) findViewById(R.id.textView48);
        TextView tv49 = (TextView) findViewById(R.id.textView49);

        TextView tv50 = (TextView) findViewById(R.id.textView50);
        TextView tv51 = (TextView) findViewById(R.id.textView51);
        TextView tv52 = (TextView) findViewById(R.id.textView52);
        TextView tv53 = (TextView) findViewById(R.id.textView53);
        TextView tv54 = (TextView) findViewById(R.id.textView54);
        TextView tv55 = (TextView) findViewById(R.id.textView55);
        TextView tv56 = (TextView) findViewById(R.id.textView56);
        TextView tv57 = (TextView) findViewById(R.id.textView57);
        TextView tv58 = (TextView) findViewById(R.id.textView58);
        TextView tv59 = (TextView) findViewById(R.id.textView59);

        TextView tv60 = (TextView) findViewById(R.id.textView60);
        TextView tv61 = (TextView) findViewById(R.id.textView61);
        TextView tv62 = (TextView) findViewById(R.id.textView62);
        TextView tv63 = (TextView) findViewById(R.id.textView63);
        TextView tv64 = (TextView) findViewById(R.id.textView64);
        TextView tv65 = (TextView) findViewById(R.id.textView65);
        TextView tv66 = (TextView) findViewById(R.id.textView66);
        TextView tv67 = (TextView) findViewById(R.id.textView67);
        TextView tv68 = (TextView) findViewById(R.id.textView68);
        TextView tv69 = (TextView) findViewById(R.id.textView69);

        TextView tv70 = (TextView) findViewById(R.id.textView70);
        TextView tv71 = (TextView) findViewById(R.id.textView71);
        TextView tv72 = (TextView) findViewById(R.id.textView72);
        TextView tv73 = (TextView) findViewById(R.id.textView73);
        TextView tv74 = (TextView) findViewById(R.id.textView74);
        TextView tv75 = (TextView) findViewById(R.id.textView75);
        TextView tv76 = (TextView) findViewById(R.id.textView76);
        TextView tv77 = (TextView) findViewById(R.id.textView77);
        TextView tv78 = (TextView) findViewById(R.id.textView78);
        TextView tv79 = (TextView) findViewById(R.id.textView79);

        TextView tv80 = (TextView) findViewById(R.id.textView80);
        TextView tv81 = (TextView) findViewById(R.id.textView81);
        TextView tv82 = (TextView) findViewById(R.id.textView82);
        TextView tv83 = (TextView) findViewById(R.id.textView83);
        TextView tv84 = (TextView) findViewById(R.id.textView84);
        TextView tv85 = (TextView) findViewById(R.id.textView85);
        TextView tv86 = (TextView) findViewById(R.id.textView86);
        TextView tv87 = (TextView) findViewById(R.id.textView87);
        TextView tv88 = (TextView) findViewById(R.id.textView88);
        TextView tv89 = (TextView) findViewById(R.id.textView89);

        TextView tv90 = (TextView) findViewById(R.id.textView90);
        TextView tv91 = (TextView) findViewById(R.id.textView91);
        TextView tv92 = (TextView) findViewById(R.id.textView92);
        TextView tv93 = (TextView) findViewById(R.id.textView93);
        TextView tv94 = (TextView) findViewById(R.id.textView94);
        TextView tv95 = (TextView) findViewById(R.id.textView95);
        TextView tv96 = (TextView) findViewById(R.id.textView96);
        TextView tv97 = (TextView) findViewById(R.id.textView97);
        TextView tv98 = (TextView) findViewById(R.id.textView98);
        TextView tv99 = (TextView) findViewById(R.id.textView99);

        TextView tv100 = (TextView) findViewById(R.id.textView100);
        TextView tv101 = (TextView) findViewById(R.id.textView101);
        TextView tv102 = (TextView) findViewById(R.id.textView102);
        TextView tv103 = (TextView) findViewById(R.id.textView103);
        TextView tv104 = (TextView) findViewById(R.id.textView104);
        TextView tv105 = (TextView) findViewById(R.id.textView105);
        TextView tv106 = (TextView) findViewById(R.id.textView106);
        TextView tv107 = (TextView) findViewById(R.id.textView107);
        TextView tv108 = (TextView) findViewById(R.id.textView108);
        TextView tv109 = (TextView) findViewById(R.id.textView109);

        TextView tv110 = (TextView) findViewById(R.id.textView110);
        TextView tv111 = (TextView) findViewById(R.id.textView111);
        TextView tv112 = (TextView) findViewById(R.id.textView112);
        TextView tv113 = (TextView) findViewById(R.id.textView113);
        TextView tv114 = (TextView) findViewById(R.id.textView114);
        TextView tv115 = (TextView) findViewById(R.id.textView115);
        TextView tv116 = (TextView) findViewById(R.id.textView116);
        TextView tv117 = (TextView) findViewById(R.id.textView117);
        TextView tv118 = (TextView) findViewById(R.id.textView118);
        TextView tv119 = (TextView) findViewById(R.id.textView119);
        //_______________________________________
        tv00.setTextColor(Color.GRAY);
        tv00.setBackgroundColor(Color.GREEN);
        tv00.setOnClickListener(this::onClickTV);

        tv01.setTextColor(Color.GRAY);
        tv01.setBackgroundColor(Color.GREEN);
        tv01.setOnClickListener(this::onClickTV);

        tv02.setTextColor(Color.GRAY);
        tv02.setBackgroundColor(Color.GREEN);
        tv02.setOnClickListener(this::onClickTV);

        tv03.setTextColor(Color.GRAY);
        tv03.setBackgroundColor(Color.GREEN);
        tv03.setOnClickListener(this::onClickTV);

        tv04.setTextColor(Color.GRAY);
        tv04.setBackgroundColor(Color.GREEN);
        tv04.setOnClickListener(this::onClickTV);

        tv05.setTextColor(Color.GRAY);
        tv05.setBackgroundColor(Color.GREEN);
        tv05.setOnClickListener(this::onClickTV);

        tv06.setTextColor(Color.GRAY);
        tv06.setBackgroundColor(Color.GREEN);
        tv06.setOnClickListener(this::onClickTV);

        tv07.setTextColor(Color.GRAY);
        tv07.setBackgroundColor(Color.GREEN);
        tv07.setOnClickListener(this::onClickTV);

        tv08.setTextColor(Color.GRAY);
        tv08.setBackgroundColor(Color.GREEN);
        tv08.setOnClickListener(this::onClickTV);

        tv09.setTextColor(Color.GRAY);
        tv09.setBackgroundColor(Color.GREEN);
        tv09.setOnClickListener(this::onClickTV);
        //_______________________________________
        tv10.setTextColor(Color.GRAY);
        tv10.setBackgroundColor(Color.GREEN);
        tv10.setOnClickListener(this::onClickTV);

        tv11.setTextColor(Color.GRAY);
        tv11.setBackgroundColor(Color.GREEN);
        tv11.setOnClickListener(this::onClickTV);

        tv12.setTextColor(Color.GRAY);
        tv12.setBackgroundColor(Color.GREEN);
        tv12.setOnClickListener(this::onClickTV);

        tv13.setTextColor(Color.GRAY);
        tv13.setBackgroundColor(Color.GREEN);
        tv13.setOnClickListener(this::onClickTV);

        tv14.setTextColor(Color.GRAY);
        tv14.setBackgroundColor(Color.GREEN);
        tv14.setOnClickListener(this::onClickTV);

        tv15.setTextColor(Color.GRAY);
        tv15.setBackgroundColor(Color.GREEN);
        tv15.setOnClickListener(this::onClickTV);

        tv16.setTextColor(Color.GRAY);
        tv16.setBackgroundColor(Color.GREEN);
        tv16.setOnClickListener(this::onClickTV);

        tv17.setTextColor(Color.GRAY);
        tv17.setBackgroundColor(Color.GREEN);
        tv17.setOnClickListener(this::onClickTV);

        tv18.setTextColor(Color.GRAY);
        tv18.setBackgroundColor(Color.GREEN);
        tv18.setOnClickListener(this::onClickTV);

        tv19.setTextColor(Color.GRAY);
        tv19.setBackgroundColor(Color.GREEN);
        tv19.setOnClickListener(this::onClickTV);
        //_______________________________________
        tv20.setTextColor(Color.GRAY);
        tv20.setBackgroundColor(Color.GREEN);
        tv20.setOnClickListener(this::onClickTV);

        tv21.setTextColor(Color.GRAY);
        tv21.setBackgroundColor(Color.GREEN);
        tv21.setOnClickListener(this::onClickTV);

        tv22.setTextColor(Color.GRAY);
        tv22.setBackgroundColor(Color.GREEN);
        tv22.setOnClickListener(this::onClickTV);

        tv23.setTextColor(Color.GRAY);
        tv23.setBackgroundColor(Color.GREEN);
        tv23.setOnClickListener(this::onClickTV);

        tv24.setTextColor(Color.GRAY);
        tv24.setBackgroundColor(Color.GREEN);
        tv24.setOnClickListener(this::onClickTV);

        tv25.setTextColor(Color.GRAY);
        tv25.setBackgroundColor(Color.GREEN);
        tv25.setOnClickListener(this::onClickTV);

        tv26.setTextColor(Color.GRAY);
        tv26.setBackgroundColor(Color.GREEN);
        tv26.setOnClickListener(this::onClickTV);

        tv27.setTextColor(Color.GRAY);
        tv27.setBackgroundColor(Color.GREEN);
        tv27.setOnClickListener(this::onClickTV);

        tv28.setTextColor(Color.GRAY);
        tv28.setBackgroundColor(Color.GREEN);
        tv28.setOnClickListener(this::onClickTV);

        tv29.setTextColor(Color.GRAY);
        tv29.setBackgroundColor(Color.GREEN);
        tv29.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv30.setTextColor(Color.GRAY);
        tv30.setBackgroundColor(Color.GREEN);
        tv30.setOnClickListener(this::onClickTV);

        tv31.setTextColor(Color.GRAY);
        tv31.setBackgroundColor(Color.GREEN);
        tv31.setOnClickListener(this::onClickTV);

        tv32.setTextColor(Color.GRAY);
        tv32.setBackgroundColor(Color.GREEN);
        tv32.setOnClickListener(this::onClickTV);

        tv33.setTextColor(Color.GRAY);
        tv33.setBackgroundColor(Color.GREEN);
        tv33.setOnClickListener(this::onClickTV);

        tv34.setTextColor(Color.GRAY);
        tv34.setBackgroundColor(Color.GREEN);
        tv34.setOnClickListener(this::onClickTV);

        tv35.setTextColor(Color.GRAY);
        tv35.setBackgroundColor(Color.GREEN);
        tv35.setOnClickListener(this::onClickTV);

        tv36.setTextColor(Color.GRAY);
        tv36.setBackgroundColor(Color.GREEN);
        tv36.setOnClickListener(this::onClickTV);

        tv37.setTextColor(Color.GRAY);
        tv37.setBackgroundColor(Color.GREEN);
        tv37.setOnClickListener(this::onClickTV);

        tv38.setTextColor(Color.GRAY);
        tv38.setBackgroundColor(Color.GREEN);
        tv38.setOnClickListener(this::onClickTV);

        tv39.setTextColor(Color.GRAY);
        tv39.setBackgroundColor(Color.GREEN);
        tv39.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv40.setTextColor(Color.GRAY);
        tv40.setBackgroundColor(Color.GREEN);
        tv40.setOnClickListener(this::onClickTV);

        tv41.setTextColor(Color.GRAY);
        tv41.setBackgroundColor(Color.GREEN);
        tv41.setOnClickListener(this::onClickTV);

        tv42.setTextColor(Color.GRAY);
        tv42.setBackgroundColor(Color.GREEN);
        tv42.setOnClickListener(this::onClickTV);

        tv43.setTextColor(Color.GRAY);
        tv43.setBackgroundColor(Color.GREEN);
        tv43.setOnClickListener(this::onClickTV);

        tv44.setTextColor(Color.GRAY);
        tv44.setBackgroundColor(Color.GREEN);
        tv44.setOnClickListener(this::onClickTV);

        tv45.setTextColor(Color.GRAY);
        tv45.setBackgroundColor(Color.GREEN);
        tv45.setOnClickListener(this::onClickTV);

        tv46.setTextColor(Color.GRAY);
        tv46.setBackgroundColor(Color.GREEN);
        tv46.setOnClickListener(this::onClickTV);

        tv47.setTextColor(Color.GRAY);
        tv47.setBackgroundColor(Color.GREEN);
        tv47.setOnClickListener(this::onClickTV);

        tv48.setTextColor(Color.GRAY);
        tv48.setBackgroundColor(Color.GREEN);
        tv48.setOnClickListener(this::onClickTV);

        tv49.setTextColor(Color.GRAY);
        tv49.setBackgroundColor(Color.GREEN);
        tv49.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv50.setTextColor(Color.GRAY);
        tv50.setBackgroundColor(Color.GREEN);
        tv50.setOnClickListener(this::onClickTV);

        tv51.setTextColor(Color.GRAY);
        tv51.setBackgroundColor(Color.GREEN);
        tv51.setOnClickListener(this::onClickTV);

        tv52.setTextColor(Color.GRAY);
        tv52.setBackgroundColor(Color.GREEN);
        tv52.setOnClickListener(this::onClickTV);

        tv53.setTextColor(Color.GRAY);
        tv53.setBackgroundColor(Color.GREEN);
        tv53.setOnClickListener(this::onClickTV);

        tv54.setTextColor(Color.GRAY);
        tv54.setBackgroundColor(Color.GREEN);
        tv54.setOnClickListener(this::onClickTV);

        tv55.setTextColor(Color.GRAY);
        tv55.setBackgroundColor(Color.GREEN);
        tv55.setOnClickListener(this::onClickTV);

        tv56.setTextColor(Color.GRAY);
        tv56.setBackgroundColor(Color.GREEN);
        tv56.setOnClickListener(this::onClickTV);

        tv57.setTextColor(Color.GRAY);
        tv57.setBackgroundColor(Color.GREEN);
        tv57.setOnClickListener(this::onClickTV);

        tv58.setTextColor(Color.GRAY);
        tv58.setBackgroundColor(Color.GREEN);
        tv58.setOnClickListener(this::onClickTV);

        tv59.setTextColor(Color.GRAY);
        tv59.setBackgroundColor(Color.GREEN);
        tv59.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv60.setTextColor(Color.GRAY);
        tv60.setBackgroundColor(Color.GREEN);
        tv60.setOnClickListener(this::onClickTV);

        tv61.setTextColor(Color.GRAY);
        tv61.setBackgroundColor(Color.GREEN);
        tv61.setOnClickListener(this::onClickTV);

        tv62.setTextColor(Color.GRAY);
        tv62.setBackgroundColor(Color.GREEN);
        tv62.setOnClickListener(this::onClickTV);

        tv63.setTextColor(Color.GRAY);
        tv63.setBackgroundColor(Color.GREEN);
        tv63.setOnClickListener(this::onClickTV);

        tv64.setTextColor(Color.GRAY);
        tv64.setBackgroundColor(Color.GREEN);
        tv64.setOnClickListener(this::onClickTV);

        tv65.setTextColor(Color.GRAY);
        tv65.setBackgroundColor(Color.GREEN);
        tv65.setOnClickListener(this::onClickTV);

        tv66.setTextColor(Color.GRAY);
        tv66.setBackgroundColor(Color.GREEN);
        tv66.setOnClickListener(this::onClickTV);

        tv67.setTextColor(Color.GRAY);
        tv67.setBackgroundColor(Color.GREEN);
        tv67.setOnClickListener(this::onClickTV);

        tv68.setTextColor(Color.GRAY);
        tv68.setBackgroundColor(Color.GREEN);
        tv68.setOnClickListener(this::onClickTV);

        tv69.setTextColor(Color.GRAY);
        tv69.setBackgroundColor(Color.GREEN);
        tv69.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv70.setTextColor(Color.GRAY);
        tv70.setBackgroundColor(Color.GREEN);
        tv70.setOnClickListener(this::onClickTV);

        tv71.setTextColor(Color.GRAY);
        tv71.setBackgroundColor(Color.GREEN);
        tv71.setOnClickListener(this::onClickTV);

        tv72.setTextColor(Color.GRAY);
        tv72.setBackgroundColor(Color.GREEN);
        tv72.setOnClickListener(this::onClickTV);

        tv73.setTextColor(Color.GRAY);
        tv73.setBackgroundColor(Color.GREEN);
        tv73.setOnClickListener(this::onClickTV);

        tv74.setTextColor(Color.GRAY);
        tv74.setBackgroundColor(Color.GREEN);
        tv74.setOnClickListener(this::onClickTV);

        tv75.setTextColor(Color.GRAY);
        tv75.setBackgroundColor(Color.GREEN);
        tv75.setOnClickListener(this::onClickTV);

        tv76.setTextColor(Color.GRAY);
        tv76.setBackgroundColor(Color.GREEN);
        tv76.setOnClickListener(this::onClickTV);

        tv77.setTextColor(Color.GRAY);
        tv77.setBackgroundColor(Color.GREEN);
        tv77.setOnClickListener(this::onClickTV);

        tv78.setTextColor(Color.GRAY);
        tv78.setBackgroundColor(Color.GREEN);
        tv78.setOnClickListener(this::onClickTV);

        tv79.setTextColor(Color.GRAY);
        tv79.setBackgroundColor(Color.GREEN);
        tv79.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv80.setTextColor(Color.GRAY);
        tv80.setBackgroundColor(Color.GREEN);
        tv80.setOnClickListener(this::onClickTV);

        tv81.setTextColor(Color.GRAY);
        tv81.setBackgroundColor(Color.GREEN);
        tv81.setOnClickListener(this::onClickTV);

        tv82.setTextColor(Color.GRAY);
        tv82.setBackgroundColor(Color.GREEN);
        tv82.setOnClickListener(this::onClickTV);

        tv83.setTextColor(Color.GRAY);
        tv83.setBackgroundColor(Color.GREEN);
        tv83.setOnClickListener(this::onClickTV);

        tv84.setTextColor(Color.GRAY);
        tv84.setBackgroundColor(Color.GREEN);
        tv84.setOnClickListener(this::onClickTV);

        tv85.setTextColor(Color.GRAY);
        tv85.setBackgroundColor(Color.GREEN);
        tv85.setOnClickListener(this::onClickTV);

        tv86.setTextColor(Color.GRAY);
        tv86.setBackgroundColor(Color.GREEN);
        tv86.setOnClickListener(this::onClickTV);

        tv87.setTextColor(Color.GRAY);
        tv87.setBackgroundColor(Color.GREEN);
        tv87.setOnClickListener(this::onClickTV);

        tv88.setTextColor(Color.GRAY);
        tv88.setBackgroundColor(Color.GREEN);
        tv88.setOnClickListener(this::onClickTV);

        tv89.setTextColor(Color.GRAY);
        tv89.setBackgroundColor(Color.GREEN);
        tv89.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv90.setTextColor(Color.GRAY);
        tv90.setBackgroundColor(Color.GREEN);
        tv90.setOnClickListener(this::onClickTV);

        tv91.setTextColor(Color.GRAY);
        tv91.setBackgroundColor(Color.GREEN);
        tv91.setOnClickListener(this::onClickTV);

        tv92.setTextColor(Color.GRAY);
        tv92.setBackgroundColor(Color.GREEN);
        tv92.setOnClickListener(this::onClickTV);

        tv93.setTextColor(Color.GRAY);
        tv93.setBackgroundColor(Color.GREEN);
        tv93.setOnClickListener(this::onClickTV);

        tv94.setTextColor(Color.GRAY);
        tv94.setBackgroundColor(Color.GREEN);
        tv94.setOnClickListener(this::onClickTV);

        tv95.setTextColor(Color.GRAY);
        tv95.setBackgroundColor(Color.GREEN);
        tv95.setOnClickListener(this::onClickTV);

        tv96.setTextColor(Color.GRAY);
        tv96.setBackgroundColor(Color.GREEN);
        tv96.setOnClickListener(this::onClickTV);

        tv97.setTextColor(Color.GRAY);
        tv97.setBackgroundColor(Color.GREEN);
        tv97.setOnClickListener(this::onClickTV);

        tv98.setTextColor(Color.GRAY);
        tv98.setBackgroundColor(Color.GREEN);
        tv98.setOnClickListener(this::onClickTV);

        tv99.setTextColor(Color.GRAY);
        tv99.setBackgroundColor(Color.GREEN);
        tv99.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv100.setTextColor(Color.GRAY);
        tv100.setBackgroundColor(Color.GREEN);
        tv100.setOnClickListener(this::onClickTV);

        tv101.setTextColor(Color.GRAY);
        tv101.setBackgroundColor(Color.GREEN);
        tv101.setOnClickListener(this::onClickTV);

        tv102.setTextColor(Color.GRAY);
        tv102.setBackgroundColor(Color.GREEN);
        tv102.setOnClickListener(this::onClickTV);

        tv103.setTextColor(Color.GRAY);
        tv103.setBackgroundColor(Color.GREEN);
        tv103.setOnClickListener(this::onClickTV);

        tv104.setTextColor(Color.GRAY);
        tv104.setBackgroundColor(Color.GREEN);
        tv104.setOnClickListener(this::onClickTV);

        tv105.setTextColor(Color.GRAY);
        tv105.setBackgroundColor(Color.GREEN);
        tv105.setOnClickListener(this::onClickTV);

        tv106.setTextColor(Color.GRAY);
        tv106.setBackgroundColor(Color.GREEN);
        tv106.setOnClickListener(this::onClickTV);

        tv107.setTextColor(Color.GRAY);
        tv107.setBackgroundColor(Color.GREEN);
        tv107.setOnClickListener(this::onClickTV);

        tv108.setTextColor(Color.GRAY);
        tv108.setBackgroundColor(Color.GREEN);
        tv108.setOnClickListener(this::onClickTV);

        tv109.setTextColor(Color.GRAY);
        tv109.setBackgroundColor(Color.GREEN);
        tv109.setOnClickListener(this::onClickTV);

        //_______________________________________
        tv110.setTextColor(Color.GRAY);
        tv110.setBackgroundColor(Color.GREEN);
        tv110.setOnClickListener(this::onClickTV);

        tv111.setTextColor(Color.GRAY);
        tv111.setBackgroundColor(Color.GREEN);
        tv111.setOnClickListener(this::onClickTV);

        tv112.setTextColor(Color.GRAY);
        tv112.setBackgroundColor(Color.GREEN);
        tv112.setOnClickListener(this::onClickTV);

        tv113.setTextColor(Color.GRAY);
        tv113.setBackgroundColor(Color.GREEN);
        tv113.setOnClickListener(this::onClickTV);

        tv114.setTextColor(Color.GRAY);
        tv114.setBackgroundColor(Color.GREEN);
        tv114.setOnClickListener(this::onClickTV);

        tv115.setTextColor(Color.GRAY);
        tv115.setBackgroundColor(Color.GREEN);
        tv115.setOnClickListener(this::onClickTV);

        tv116.setTextColor(Color.GRAY);
        tv116.setBackgroundColor(Color.GREEN);
        tv116.setOnClickListener(this::onClickTV);

        tv117.setTextColor(Color.GRAY);
        tv117.setBackgroundColor(Color.GREEN);
        tv117.setOnClickListener(this::onClickTV);

        tv118.setTextColor(Color.GRAY);
        tv118.setBackgroundColor(Color.GREEN);
        tv118.setOnClickListener(this::onClickTV);

        tv119.setTextColor(Color.GRAY);
        tv119.setBackgroundColor(Color.GREEN);
        tv119.setOnClickListener(this::onClickTV);
        //__________________________________________

        cell_tvs.add(tv00);
        cell_tvs.add(tv01);
        cell_tvs.add(tv02);
        cell_tvs.add(tv03);
        cell_tvs.add(tv04);
        cell_tvs.add(tv05);
        cell_tvs.add(tv06);
        cell_tvs.add(tv07);
        cell_tvs.add(tv08);
        cell_tvs.add(tv09);

        cell_tvs.add(tv10);
        cell_tvs.add(tv11);
        cell_tvs.add(tv12);
        cell_tvs.add(tv13);
        cell_tvs.add(tv14);
        cell_tvs.add(tv15);
        cell_tvs.add(tv16);
        cell_tvs.add(tv17);
        cell_tvs.add(tv18);
        cell_tvs.add(tv19);

        cell_tvs.add(tv20);
        cell_tvs.add(tv21);
        cell_tvs.add(tv22);
        cell_tvs.add(tv23);
        cell_tvs.add(tv24);
        cell_tvs.add(tv25);
        cell_tvs.add(tv26);
        cell_tvs.add(tv27);
        cell_tvs.add(tv28);
        cell_tvs.add(tv29);

        cell_tvs.add(tv30);
        cell_tvs.add(tv31);
        cell_tvs.add(tv32);
        cell_tvs.add(tv33);
        cell_tvs.add(tv34);
        cell_tvs.add(tv35);
        cell_tvs.add(tv36);
        cell_tvs.add(tv37);
        cell_tvs.add(tv38);
        cell_tvs.add(tv39);

        cell_tvs.add(tv40);
        cell_tvs.add(tv41);
        cell_tvs.add(tv42);
        cell_tvs.add(tv43);
        cell_tvs.add(tv44);
        cell_tvs.add(tv45);
        cell_tvs.add(tv46);
        cell_tvs.add(tv47);
        cell_tvs.add(tv48);
        cell_tvs.add(tv49);

        cell_tvs.add(tv50);
        cell_tvs.add(tv51);
        cell_tvs.add(tv52);
        cell_tvs.add(tv53);
        cell_tvs.add(tv54);
        cell_tvs.add(tv55);
        cell_tvs.add(tv56);
        cell_tvs.add(tv57);
        cell_tvs.add(tv58);
        cell_tvs.add(tv59);

        cell_tvs.add(tv60);
        cell_tvs.add(tv61);
        cell_tvs.add(tv62);
        cell_tvs.add(tv63);
        cell_tvs.add(tv64);
        cell_tvs.add(tv65);
        cell_tvs.add(tv66);
        cell_tvs.add(tv67);
        cell_tvs.add(tv68);
        cell_tvs.add(tv69);

        cell_tvs.add(tv70);
        cell_tvs.add(tv71);
        cell_tvs.add(tv72);
        cell_tvs.add(tv73);
        cell_tvs.add(tv74);
        cell_tvs.add(tv75);
        cell_tvs.add(tv76);
        cell_tvs.add(tv77);
        cell_tvs.add(tv78);
        cell_tvs.add(tv79);

        cell_tvs.add(tv80);
        cell_tvs.add(tv81);
        cell_tvs.add(tv82);
        cell_tvs.add(tv83);
        cell_tvs.add(tv84);
        cell_tvs.add(tv85);
        cell_tvs.add(tv86);
        cell_tvs.add(tv87);
        cell_tvs.add(tv88);
        cell_tvs.add(tv89);

        cell_tvs.add(tv90);
        cell_tvs.add(tv91);
        cell_tvs.add(tv92);
        cell_tvs.add(tv93);
        cell_tvs.add(tv94);
        cell_tvs.add(tv95);
        cell_tvs.add(tv96);
        cell_tvs.add(tv97);
        cell_tvs.add(tv98);
        cell_tvs.add(tv99);

        cell_tvs.add(tv100);
        cell_tvs.add(tv101);
        cell_tvs.add(tv102);
        cell_tvs.add(tv103);
        cell_tvs.add(tv104);
        cell_tvs.add(tv105);
        cell_tvs.add(tv106);
        cell_tvs.add(tv107);
        cell_tvs.add(tv108);
        cell_tvs.add(tv109);

        cell_tvs.add(tv110);
        cell_tvs.add(tv111);
        cell_tvs.add(tv112);
        cell_tvs.add(tv113);
        cell_tvs.add(tv114);
        cell_tvs.add(tv115);
        cell_tvs.add(tv116);
        cell_tvs.add(tv117);
        cell_tvs.add(tv118);
        cell_tvs.add(tv119);

        //________________________________

        TextView digandflag = (TextView) findViewById(R.id.digandflag);
//        TextView flagText = (TextView) findViewById(R.id.flagText);
//        TextView clockText = (TextView) findViewById(R.id.clockText);

        digandflag.setOnClickListener(this::onClickAction);

        //place 4 mines
        for(int i=0; i<4; i++){
            placeMine(i);
        }
    }

    private int findIndexOfCellTextView(TextView tv) {
        for (int n=0; n<cell_tvs.size(); n++) {
            if (cell_tvs.get(n) == tv)
                return n;
        }
        return -1;
    }

    public void dig(int n){

        if(n >= cell_tvs.size() || n < 0){
            return;
        }
        else if(visited[n] == true || cell_tvs.get(n).getText() == "@"){
            return;
        }
        //if not visited, set as visited
        visited[n] = true;
        visitedCount++;
        int count = 0;

        if(!cell_tvs.get(n).getText().equals("\uD83D\uDEA9") && !cell_tvs.get(n).getText().equals("\uD83D\uDEA9@")){
            cell_tvs.get(n).setBackgroundColor(Color.LTGRAY);
        }

        //check surrounding cells, if there is bomb, change text to number of bombs
        if(n%COLUMN_COUNT != 9 && n+1 >= 0 && n+1 < cell_tvs.size() && (cell_tvs.get(n+1).getText() == "@" || cell_tvs.get(n+1).getText() == "\uD83D\uDEA9@")){
            count++;
        }
        if(n%COLUMN_COUNT != 0 && n-1 >= 0 && n-1 < cell_tvs.size() && (cell_tvs.get(n-1).getText() == "@" || cell_tvs.get(n-1).getText() == "\uD83D\uDEA9@")){
            count++;
        }
        if(n/COLUMN_COUNT != 0 && n-10 >= 0 && n-10 <cell_tvs.size() && (cell_tvs.get(n-10).getText() == "@" || cell_tvs.get(n-10).getText() == "\uD83D\uDEA9@")){
            count++;
        }
        if(n/COLUMN_COUNT != 11 && n+10 >= 0 && n+10 <cell_tvs.size() && (cell_tvs.get(n+10).getText() == "@" || cell_tvs.get(n+10).getText() == "\uD83D\uDEA9@")){
            count++;
        }
        if(n/COLUMN_COUNT != 0 && n%COLUMN_COUNT != 0 && n-11 >= 0 && n-11 <cell_tvs.size() && (cell_tvs.get(n-11).getText() == "@" || cell_tvs.get(n-11).getText() == "\uD83D\uDEA9@")){
            count++;
        }
        if(n/COLUMN_COUNT != 11 && n%COLUMN_COUNT != 9 && n+11 >= 0 && n+11 <cell_tvs.size() && (cell_tvs.get(n+11).getText() == "@" || cell_tvs.get(n+11).getText() == "\uD83D\uDEA9@")){
            count++;
        }
        if(n/COLUMN_COUNT != 0 && n%COLUMN_COUNT != 9 && n-9 >= 0 && n-9 <cell_tvs.size() && (cell_tvs.get(n-9).getText() == "@" || cell_tvs.get(n-9).getText() == "\uD83D\uDEA9@")){
            count++;
        }
        if(n/COLUMN_COUNT != 11 && n%COLUMN_COUNT != 0 && n+9 >= 0 && n+9 <cell_tvs.size() && (cell_tvs.get(n+9).getText() == "@" || cell_tvs.get(n+9).getText() == "\uD83D\uDEA9@")){
            count++;
        }

        if(count > 0 && !cell_tvs.get(n).getText().equals("\uD83D\uDEA9")){
            cell_tvs.get(n).setText(String.valueOf(count));
            if(count == 1){
                cell_tvs.get(n).setTextColor(Color.BLUE);
            }
            else if(count == 2){
                cell_tvs.get(n).setTextColor(Color.MAGENTA);
            }
            else if(count == 3){
                cell_tvs.get(n).setTextColor(Color.RED);
            }
            else if(count == 4){
                cell_tvs.get(n).setTextColor(Color.CYAN);
            }
            return;
        }

        dig(n-11);
        dig(n-10);
        dig(n-9);
        dig(n-1);
        dig(n+10);
        dig(n+1);
        dig(n+9);
        dig(n+11);

    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("clock", clock);
        savedInstanceState.putBoolean("running", running);
    }

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.clockText);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int seconds = clock%60;
                timeView.setText(Integer.toString(seconds));
                if (running) {
                    clock++;
                }
                handler.postDelayed(this, 1000);
            }
        } );
    }

    private void flagUpdate(){
        final TextView flagView = (TextView) findViewById(R.id.flagText);
        flagView.setText(Integer.toString(flagsLeft));
    }

    public void onClickAction(View view){
        TextView tv = (TextView) view;

        if(tv.getText().equals("⛏")){
            tv.setText("\uD83D\uDEA9");
            flagging = true;
        }
        else if(tv.getText().equals("\uD83D\uDEA9")) {
            tv.setText("\u26CF");
            flagging = false;
        }

    }

    public boolean checkWin(){
        //check all bombs have been flagged
        for(int i=0; i<4; i++){
            if(!cell_tvs.get(mineLocations[i]).getText().equals("\uD83D\uDEA9@")){
                return false;
            }
        }

        //check all un-flagged cells have been visited
        for(int i=0; i<120; i++){
           if((!cell_tvs.get(i).getText().equals("\uD83D\uDEA9@") && !cell_tvs.get(i).getText().equals("\uD83D\uDEA9") && visited[i] == false)){
                return false;
           }
        }
        return true;
    }

    public void onClickTV(View view){
        TextView tv = (TextView) view;
        int n = findIndexOfCellTextView(tv);
        int i = n/COLUMN_COUNT;
        int j = n%COLUMN_COUNT;

        //System.out.println(visitedCount);
        if(visitedCount == 116){
            for(int m=0; m<4; m++){
                cell_tvs.get(mineLocations[m]).setText("\uD83D\uDCA3");
                cell_tvs.get(mineLocations[m]).setBackgroundColor(Color.parseColor("red"));
            }
            onClickAction(view);

            boolean winQ = true;
            for(int m=0; m<4; m++){
                if(visited[mineLocations[m]] == true){
                    winQ = false;
                }
            }
            if(winQ){
                //send win message after clicking somewhere
                displayWin = true;
            }
        }
        if(displayLoss){
            sendLossMessage();
        }
        if(displayWin){
            sendWinMessage();
        }

        if(flagging == false){
            if(tv.getText() == "\uD83D\uDEA9@" || tv.getText() == "\uD83D\uDEA9"){
                //nothing happens
            }
            else if(tv.getText() == "@"){
                //clicked on mine
                tv.setText("\uD83D\uDCA3");
                tv.setBackgroundColor(Color.parseColor("red"));

                for(int m=0; m<4; m++){
                    cell_tvs.get(mineLocations[m]).setText("\uD83D\uDCA3");
                    cell_tvs.get(mineLocations[m]).setBackgroundColor(Color.parseColor("red"));
                }
                running = false;
                displayLoss = true;
            }
            else if(tv.getText() != "\uD83D\uDCA3"){
                tv.setBackgroundColor(Color.LTGRAY);
                if(n!=-1){
                    dig(n);
                }
            }
        }
        else{
            //flagging mode
            System.out.println(tv.getText());
            if((tv.getText() != "\uD83D\uDEA9" && tv.getText() != "\uD83D\uDEA9@")&& visited[n] == false){
                //has not been flagged
                if(tv.getText() == "@"){
                    System.out.println("1");
                    tv.setText("\uD83D\uDEA9@");
                }
                else{
                    System.out.println("2");
                    tv.setText("\uD83D\uDEA9");
                }
                flagsLeft -= 1;
                flagUpdate();

            }
            else if(tv.getText() == "\uD83D\uDEA9"){
                //has been flagged, not remove flag
                System.out.println("3");
                tv.setText("");
                //visited[n] = false;
                if(flagsLeft < 4){
                    flagsLeft += 1;
                    flagUpdate();
                }
            }
            else if(tv.getText() == "\uD83D\uDEA9@"){
                System.out.println("4");
                tv.setText("@");
                tv.setTextColor(Color.GREEN);
                if(flagsLeft < 4) {
                    flagsLeft += 1;
                    flagUpdate();
                }
            }
        }

        if(flagsLeft == 0){
            boolean win = checkWin();
            if(win){
                running = false;
                //display location of mines even if they win
                for(int m=0; m<4; m++){
                    cell_tvs.get(mineLocations[m]).setText("\uD83D\uDCA3");
                    cell_tvs.get(mineLocations[m]).setBackgroundColor(Color.parseColor("red"));
                }
                displayWin = true;
            }
        }
    }

    public void sendWinMessage(){
        TextView time = (TextView) findViewById(R.id.clockText);
        String message = "Used " + time.getText() +" seconds.";

        Intent intent = new Intent(this, DisplayEndGame.class);
        intent.putExtra("com.example.sendmessage.MESSAGE", message);

        startActivity(intent);
    }

    public void sendLossMessage(){
        TextView time = (TextView) findViewById(R.id.clockText);
        String message = "Used " + time.getText() +" seconds.";
        Intent intent = new Intent(this, DisplayLoss.class);
        intent.putExtra("com.example.sendmessage.MESSAGE", message);

        startActivity(intent);
    }

    public void placeMine(int i){
        Random rand = new Random();
        int randomNum = rand.nextInt((119 - 0) + 1);
        for(int j=0; j<4; j++){
            while(randomNum == mineLocations[j]){
                Random rand2 = new Random();
                randomNum = rand2.nextInt((119 - 0) + 1);
                System.out.println("duplicate#########");
            }
        }
        mineLocations[i] = randomNum;
        cell_tvs.get(randomNum).setText("@");
        cell_tvs.get(randomNum).setTextColor(Color.GREEN);
    }
}