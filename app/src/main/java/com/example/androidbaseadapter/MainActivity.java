package com.example.androidbaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.androidbaseadapter.Adapters.CountriesAdapters;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view_id);
        //List of countries
        String[] counties = {
          "IRAQ","IRELAND","USA","JORDON",
        };
        //List of Flags
        int[] flags = {
                R.drawable.iraq,
                R.drawable.irland,
                R.drawable.usa,
                R.drawable.jordon
        };

        //Link this Lists with aadpter.
        CountriesAdapters countriesAdapters = new CountriesAdapters(this,counties,flags);
        listView.setAdapter(countriesAdapters);

    }
}
