package com.example.nr110.scoresheet;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile extends Activity{

    private InputStream inputStream;
   /* private TextView name,score;
    private View left,right;
    */
    public CSVFile(InputStream inputStream){

        this.inputStream = inputStream;


    }

    public List<String[]> read(){
        //int idx = 0;
        //setContentView(R.layout.item_layout);
  /*      name = (TextView)findViewById(R.id.name);
        score = (TextView)findViewById(R.id.score);

        left = (View)findViewById(R.id.left_1);
        right = (View)findViewById(R.id.right_1);
 */
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int point,now_a = 1,now_b = 1,sum;
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                point = Integer.parseInt(row[2]);
                String mark = " ";
                switch(point){
                    case 1:
                        mark = "・";
                        break;
                    case 2:
                    case 3:
                        mark = "/";
                        break;
                }
                if(row[0].equals("0")){
                    /*left.setBackgroundColor(0xffc0cb);
                    name.setBackgroundColor(0xffc0cb);

                    right.setBackgroundColor(0x98fb98);
                    score.setBackgroundColor(0x98fb98);
                    */
                    sum = now_a+point-1;
                    while(now_a < sum){

                        String[] obj = {"0","","" + now_a};
                        resultList.add(obj);
                        now_a++;
                        //Log.d("a",""+(++idx));
                    }
                    row[2] = mark + now_a;
                    now_a++;
                }else {
                    /*
                    left.setBackgroundColor(0x98fb98);
                    name.setBackgroundColor(0x98fb98);

                    right.setBackgroundColor(0xffc0cb);
                    score.setBackgroundColor(0xffc0cb);
                    */
                    sum = now_b + point-1;
                    while(now_b < sum){

                        String[] obj = {"1", "", "" + now_b};
                        resultList.add(obj);
                        now_b++;
                        //Log.d("b",""+(++idx));
                    }
                    row[2] = now_b + mark;
                    now_b++;
                }


                resultList.add(row);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }
}
