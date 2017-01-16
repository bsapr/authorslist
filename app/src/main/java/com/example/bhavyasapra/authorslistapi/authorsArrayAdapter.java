package com.example.bhavyasapra.authorslistapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bhavya Sapra on 16-01-2017.
 */

public class authorsArrayAdapter extends ArrayAdapter<authorname>
{
    Context context;
    ArrayList<authorname> genredetail ;

    public authorsArrayAdapter(Context context,ArrayList<authorname> objects) {
        super(context,0, objects);
        this.context=context;
        this.genredetail=objects;

    }

    public static class ViewHolder
    {

        public TextView Genrename;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.authors_layout, null);
            ViewHolder vh = new ViewHolder();
            vh.Genrename = (TextView) convertView.findViewById(R.id.textViewGenreName);
            convertView.setTag(vh);
        }
        authorname currentGenre = genredetail.get(position);

        ViewHolder vh = (ViewHolder) convertView.getTag();
        vh.Genrename.setText(currentGenre.getname());




        return convertView;
    }



}