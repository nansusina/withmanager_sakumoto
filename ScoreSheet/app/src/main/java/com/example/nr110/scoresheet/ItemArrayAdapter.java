package com.example.nr110.scoresheet;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ItemArrayAdapter extends ArrayAdapter {
    private List<String[]> scoreList = new ArrayList<String[]>();
    String[] data = new String[2];

    static class ItemViewHolder {
        TextView name;
        TextView score;
    }

    public ItemArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    //@Override
    public void add(String[] object) {
        //if(object[0].equals(""))
           // Log.d("aaa",object[0] + " " + object[1]);
        scoreList.add(object);
        super.add(object);
    }

   /* public void addnull(int oldpnt,int point){
        for(int i = oldpnt+1; i < oldpnt+point; i++) {
            data[0] = "";
            data[1] = "" + i;
            //Log.d("bbb",data[0] + " " + data[1]);
            //Log.d("ccc",data[1]);
            add(data);
        }
    }
*/

    @Override
    public int getCount() {
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int index) {
        return this.scoreList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.score = (TextView) row.findViewById(R.id.score);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder)row.getTag();
        }
        String[] stat = getItem(position);

        viewHolder.name.setText(stat[0]);
        viewHolder.name.setTextColor(Color.BLACK);

        viewHolder.score.setText(stat[1]);
        viewHolder.score.setTextColor(Color.BLACK);

        return row;
    }
}