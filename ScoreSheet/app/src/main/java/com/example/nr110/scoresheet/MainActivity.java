package com.example.nr110.scoresheet;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;


public class MainActivity extends Activity {
    private ListView listView_a,listView_b;
    private ItemArrayAdapter adpt_a,adpt_b;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_a = (ListView) findViewById(R.id.listView_a);
        listView_b = (ListView)findViewById(R.id.listView_b);



        adpt_a = new ItemArrayAdapter(getApplicationContext(), R.layout.item_layout);
        adpt_b = new ItemArrayAdapter(getApplicationContext(), R.layout.item_layout);

        Parcelable state_a = listView_a.onSaveInstanceState();
        Parcelable state_b = listView_a.onSaveInstanceState();

        listView_a.setAdapter(adpt_a);
        listView_b.setAdapter(adpt_b);


        listView_a.onRestoreInstanceState(state_a);
        listView_b.onRestoreInstanceState(state_b);


        InputStream st = getResources().openRawResource(R.raw.scorelog);
        CSVFile csvFile = new CSVFile(st);
        List<String[]> scList = csvFile.read();

        for(String[] scData:scList) {

            if(scData[0].equals("0")) {
                adpt_a.add(scData);
            }else{
                String temp = scData[1];
                scData[1] = scData[2];
                scData[2] = temp;

                adpt_b.add(scData);
            }

        }


    }
}