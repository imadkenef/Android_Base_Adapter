package com.example.androidbaseadapter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidbaseadapter.R;

public class CoutriesAdapters extends BaseAdapter {
    private Context context;
    private String[] countries;
    private int[] flags;


    public CoutriesAdapters(Context context, String[] countries, int[] flags) {
        this.context = context;
        this.countries = countries;
        this.flags = flags;
    }

    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
        return countries[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderCountries holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.countries_view,parent,false);
            holder = new ViewHolderCountries();
            holder.textView = convertView.findViewById(R.id.countries);
            holder.imageView = convertView.findViewById(R.id.flags);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolderCountries) convertView.getTag();
        }
        holder.textView.setText(countries[position]);
        holder.imageView.setImageResource(flags[position]);
        return convertView;
    }
    static class ViewHolderCountries{
        ImageView imageView;
        TextView textView;
    }

}
