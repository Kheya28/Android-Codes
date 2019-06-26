package com.example.hw_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Spinner spinner;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spin);
        button=findViewById(R.id.btn);
        textView=findViewById(R.id.text);

        String[] foodnames=getResources().getStringArray(R.array.Foods);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.text_view,foodnames);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=spinner.getSelectedItem().toString();
                textView.setText(s);
            }
        });
    }
}
