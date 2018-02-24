package ca.smu.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClickEvent(View v) {
                String nameTxt = e1.getText().toString();
                String passwordTxt = e2.getText().toString();
                Boolean checknamepass = db.namepassword(nameTxt,passwordTxt);
                if(checknamepass==true)
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Wrong name or password",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
