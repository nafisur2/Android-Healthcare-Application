package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HealthArticles extends AppCompatActivity {

    private String article_details[][]=
            {
                    {"Walking Daily", "", "", "Click For Details"},
                    {"Home care of COVID-19", "", "", "Click ForDetails"},
                    {"Stop Smoking", "", "", "Click For Details"},
                    {"Healthy Gut", "", "", "Click For Details"}
            };
    private int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);

        lst = findViewById(R.id.listViewHA);
        btnBack = findViewById(R.id.buttonHABack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticles.this,Home.class));
            }
        });
        list = new ArrayList();
        for(int i=0; i<article_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", article_details[i][0]);
            item.put("line2", article_details[i][1]);
            item.put("line3", article_details[i][2]);
            item.put("line4", article_details[i][2]);
            item.put("line5", article_details[i][3]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "line4","line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(HealthArticles.this,HealthArticleDetails.class);
                it.putExtra("text1",article_details[position][0]);
                it.putExtra("text2",images[position]);
                startActivity(it);
            }
        });

    }
}