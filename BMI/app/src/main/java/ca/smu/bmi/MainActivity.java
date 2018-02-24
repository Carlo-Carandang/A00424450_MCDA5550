package ca.smu.bmi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button b1;
    EditText e1 ,e2 ,e3, e4, e5;
/*    Button btnView;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.nameTxt);
        e2 = findViewById(R.id.dobTxt);
        e3 = findViewById(R.id.healthcardTxt);
        e4 = findViewById(R.id.passwordTxt);
        e5 = findViewById(R.id.cpasswordTxt);
        b1 = findViewById(R.id.loginBtn);
        db = new DatabaseHelper(this);

/*        btnView = findViewById(R.id.btnView); */

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals((""))){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s4.equals(s5)) {
                        Boolean checkname = db.checkname(s1);
                        if (checkname == true) {
                            Boolean insert = db.insert(s1, s2, s3, s4);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Login Not Successful- Try Again", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Name already exists", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

/*       loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = nameTxt.getText().toString();
                if (nameTxt.length() != 0) {
                    AddData(newEntry);
                    nameTxt.setText(" ");
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);

                } */
/*                else {
                    Toast.makeText(MainActivity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        }); */



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
    }

/*    public void AddData(String newEntry) {
        boolean insertData = myDB.addData(newEntry);

        if (insertData==true){
            Toast.makeText(MainActivity.this, "Successfully Entered Data!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Something went wrong :(", Toast.LENGTH_LONG).show();
        }
    }
*/
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

/*    public void onClickEvent(View view){
        {
            EditText a = (EditText)findViewById()
        }
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra()
        startActivity(intent);


        Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
        startActivity(intent);


    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ListDataActivity.class);
        startActivity(intent);
    }
*/
}
