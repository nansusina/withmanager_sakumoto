package com.example.nr110.function_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView team_a,team_b;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team_a = (ListView)findViewById(R.id.team_a_num);
        team_b = (ListView)findViewById(R.id.team_b_num);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1);
        for(int i = 4; i <= 15; i++){
            adapter.add(""+i);
        }
        team_a.setAdapter(adapter);
        team_b.setAdapter(adapter);


        /*team_a.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int pos,long id){
                ListView lv = (ListView)parent;
                item = (String)lv.getItemAtPosition(pos);
                //view.setSelected(true);
                Toast.makeText(MainActivity.this,item, Toast.LENGTH_LONG).show();

            }


        });*/

    }
}
