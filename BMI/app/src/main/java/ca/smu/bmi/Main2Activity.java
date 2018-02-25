package ca.smu.bmi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    DatabaseHelper db;
    TextView totalTextView;
    EditText heightTxt, weightTxt, dateTxt;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db = new DatabaseHelper(this);

/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        dateTxt = findViewById(R.id.dateTxt);
        heightTxt = findViewById(R.id.heightTxt);
        weightTxt = findViewById(R.id.weightTxt);
        totalTextView = findViewById(R.id.totalTextView);

        calcBtn = findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = heightTxt.getText().toString();
                Float heightAsInt = Float.parseFloat(value);
                String value1 = weightTxt.getText().toString();
                Float weightAsInt = Float.parseFloat(value1);
                Float calc = (weightAsInt/(heightAsInt*heightAsInt));
                totalTextView.setText(Float.toString((float) calc));

                String r1;
                r1 = dateTxt.getText().toString();
                Float r2, r3, r4;
                r2 = Float.parseFloat(heightTxt.getText().toString());
                r3 = Float.parseFloat(weightTxt.getText().toString());
                r4 = Float.parseFloat(totalTextView.getText().toString());

                if(r1.equals("")||r2.equals("")||r3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean ins = db.insertinrecord(r1,r2,r3,r4);
                    if(ins==true){
                        Toast.makeText(getApplicationContext(),"Successfully inserted into database",Toast.LENGTH_SHORT).show();
                        if(r4<18.5){
                            Toast.makeText(getApplicationContext(),"You are underweight: you need to gain weight",Toast.LENGTH_SHORT).show();
                        }
                        else if (r4>=18.5 && r4<25){
                            Toast.makeText(getApplicationContext(),"You have normal weight: continue as you are",Toast.LENGTH_SHORT).show();
                        }
                        else if (r4>=25 && r4<30){
                            Toast.makeText(getApplicationContext(),"You are overweight: lose some weight",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"You are obese: please see your doctor",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Not Inserted Into Database- Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
