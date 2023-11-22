package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name: AKM Fazlul Hoque", "Location: Dhaka", "Exp: 5 years","Phone No: 1212121212"," 600"},
                    {"Doctor Name: Mahbub H Khan", "Location: Khulna", "Exp: 15 years","Phone No: 8989898989"," 900"},
                    {"Doctor Name: Jahangir Talukder", "Location: Jessore", "Exp: 7 years","Phone No: 0101010101"," 300"},
                    {"Doctor Name: Nesaruddin Ahmed", "Location: Barishal", "Exp: 10 years","Phone No: 7373737373"," 500"},
                    {"Doctor Name: Mohiuddin Ahmed", "Location: Dhaka", "Exp: 8 years","Phone No: 5656565656"," 800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Tasneem Hasan", "Location: Dhaka", "Exp: 5 years","Phone No: 1212121212"," 600"},
                    {"Doctor Name: Sumon Chowdhury", "Location: Khulna", "Exp: 15 years","Phone No: 8989898989"," 900"},
                    {"Doctor Name: Tanvir Islam", "Location: Jessore", "Exp: 7 years","Phone No: 0101010101"," 300"},
                    {"Doctor Name: Farzana Ahmed", "Location: Barishal", "Exp: 10 years","Phone No: 7373737373"," 500"},
                    {"Doctor Name: Momtaj Jahan", "Location: Dhaka", "Exp: 8 years","Phone No: 5656565656"," 800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Imran Hossain", "Location: Dhaka", "Exp: 5 years","Phone No: 1212121212"," 600"},
                    {"Doctor Name: Ruhul Amin", "Location: Khulna", "Exp: 15 years","Phone No: 8989898989"," 900"},
                    {"Doctor Name: Haider Ali Khan", "Location: Jessore", "Exp: 7 years","Phone No: 0101010101"," 300"},
                    {"Doctor Name: Kamrun Nahar", "Location: Barishal", "Exp: 10 years","Phone No: 7373737373"," 500"},
                    {"Doctor Name: Sanzida Khan", "Location: Dhaka", "Exp: 8 years","Phone No: 5656565656"," 800"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Karina Rahman", "Location: Dhaka", "Exp: 5 years","Phone No: 1212121212"," 600"},
                    {"Doctor Name: Humayun Kabir", "Location: Khulna", "Exp: 15 years","Phone No: 8989898989"," 900"},
                    {"Doctor Name: Farhana Yesmin", "Location: Jessore", "Exp: 7 years","Phone No: 0101010101"," 300"},
                    {"Doctor Name: Debasish Das", "Location: Barishal", "Exp: 10 years","Phone No: 7373737373"," 500"},
                    {"Doctor Name: AZM Shakhawat Hossain", "Location: Dhaka", "Exp: 8 years","Phone No: 5656565656"," 800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Ashok Kumar Dutta", "Location: Dhaka", "Exp: 5 years","Phone No: 12121212"," 600"},
                    {"Doctor Name: Dhiman Banik", "Location: Khulna", "Exp: 15 years","Phone No: 89898989"," 900"},
                    {"Doctor Name: Baren Chakraborty", "Location: Jessore", "Exp: 7 years","Phone No: 01010101"," 300"},
                    {"Doctor Name:  Toufiqur Rahman", "Location: Barishal", "Exp: 10 years","Phone No: 73737373"," 500"},
                    {"Doctor Name: Sajal Banerjee", "Location: Dhaka", "Exp: 8 years","Phone No: 56565656"," 800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0){
            doctor_details = doctor_details1;
        }
        else if(title.compareTo("Dietician")==0){
            doctor_details = doctor_details2;
        }
        else if(title.compareTo("Dentist")==0){
            doctor_details = doctor_details3;
        }
        else if(title.compareTo("Surgeon")==0){
            doctor_details = doctor_details4;
        }
        else if(title.compareTo("Cardiologist")==0){
            doctor_details = doctor_details5;
        }

            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetails.this, FindDoctor.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees: "+doctor_details[i][4]+"/~");
            list.add( item );
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l){
                Intent it = new Intent(DoctorDetails.this,BookAppointment.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}