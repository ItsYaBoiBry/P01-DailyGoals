package android.myapplicationdev.com.p01_dailygoals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText etReflect;
    RadioGroup rgOne;
    RadioGroup rgTwo;
    RadioGroup rgThree;
    RadioButton rbOne;
    RadioButton rbTwo ;
    RadioButton rbThree;
    int selectedButtonOne;
    int selectedButtonTwo;
    int selectedButtonThree;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPreferences = getSharedPreferences("myPref",Context.MODE_PRIVATE);
        rgOne = (RadioGroup)findViewById(R.id.radioGroupOne);
        rgTwo = (RadioGroup)findViewById(R.id.radioGroupTwo);
        rgThree = (RadioGroup)findViewById(R.id.radioGroupThree);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedButtonOne = rgOne.getCheckedRadioButtonId();
                selectedButtonTwo = rgTwo.getCheckedRadioButtonId();
                selectedButtonThree = rgThree.getCheckedRadioButtonId();
                rbOne = (RadioButton)findViewById(selectedButtonOne);
                rbTwo = (RadioButton)findViewById(selectedButtonTwo);
                rbThree = (RadioButton)findViewById(selectedButtonThree);
                etReflect = (EditText)findViewById(R.id.etReflect);
                String[] selected = {rbOne.getText().toString(),rbTwo.getText().toString(),rbThree.getText().toString(),etReflect.getText().toString()};
                Intent intent = new Intent(MainActivity.this, newpage.class);
                intent.putExtra("select",selected);
                SharedPreferences sp = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("radOne",selectedButtonOne);
                editor.putInt("radTwo",selectedButtonTwo);
                editor.putInt("radThree",selectedButtonThree);
                editor.putString("etRef",etReflect.getText().toString());
                editor.apply();
                editor.commit();

                startActivity(intent);



            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("myPref",MODE_PRIVATE);
        etReflect = (EditText)findViewById(R.id.etReflect);
        etReflect.setText(prefs.getString("etRef",""));
        rgOne.check(prefs.getInt("radOne",0));
        rgTwo.check(prefs.getInt("radTwo",0));
        rgThree.check(prefs.getInt("radThree",0));





    }

}
