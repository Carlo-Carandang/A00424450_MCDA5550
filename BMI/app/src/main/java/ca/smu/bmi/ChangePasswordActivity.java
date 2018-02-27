package ca.smu.bmi;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText n1,p1;
    Button c1,c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        db = new DatabaseHelper(this);
        n1 = findViewById(R.id.editText3);
        p1 = findViewById(R.id.editText4);
        c1 = findViewById(R.id.button4);
        c2 = findViewById(R.id.button5);
        c2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {Intent intent = new Intent(ChangePasswordActivity.this, Main2Activity.class);
            startActivity(intent);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s11 = n1.getText().toString();
                String s12 = p1.getText().toString();
                if (s11.equals("") || s12.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdatePassword(s11,s12);
                    Toast.makeText(getApplicationContext(), "Successfully inserted into database", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}