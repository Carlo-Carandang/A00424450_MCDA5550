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

                String r1 = dateTxt.getText().toString();
                Integer r2 = Integer.parseInt(heightTxt.getText().toString());
                Integer r3 = Integer.parseInt(weightTxt.getText().toString());
                Integer r4 = Integer.parseInt(totalTextView.getText().toString());

                if(r1.equals("")||r2.equals("")||r3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean ins = db.insertinrecord(r1,r2,r3,r4);
                    if(ins==true){
                        Toast.makeText(getApplicationContext(),"Successfully inserted into database",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Not Inserted Into Database- Try Again", Toast.LENGTH_SHORT).show();
                    }
                }



 /*               Float heightTxt = Float.parseFloat(heightTxt.getText().toString());
                Float weightTxt = Float.parseFloat(weightTxt.getText().toString());
*/

            }
        });
    }


/*    public void calculateBMI(View view){
        // gets the height
        EditText height = findViewById(R.id.editText10);
        String value = height.getText().toString();
        Double heightAsInt = Double.parseDouble(value);
        System.out.println("Here is the height"+heightAsInt);

        // Repeat for weight
        EditText weight = findViewById(R.id.editText11);
        String value1 = weight.getText().toString();
        Double weightAsInt = Double.parseDouble(value1);
        System.out.println("Here is the weight"+weightAsInt);

        double calc = (weightAsInt/(heightAsInt*heightAsInt));
        EditText result = findViewById(R.id.editText12);

        // use DecimalFormat("0.##") to limit to 2 decimal places
        result.setText((int) calc);
    } */

}
