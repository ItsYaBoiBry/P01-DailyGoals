package android.myapplicationdev.com.p01_dailygoals;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class newpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage);
        TextView textView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        String[] selected = intent.getStringArrayExtra("select");
        textView.setText("Read up on materials before class: "+selected[0]
                +"\nArrive on time so as not to miss important part of the lesson: "+selected[1]
                +"\nAttempt the problem myself:"+selected[2]
                +"\nReflection: "+selected[3]);

        Button btnBack = (Button) findViewById(R.id.btnBck);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
