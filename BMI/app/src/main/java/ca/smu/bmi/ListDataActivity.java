package ca.smu.bmi;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by carlocarandang on 2018-02-11.
 */
/*
public class ListDataActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        ListView listView = findViewById(R.id.listView);
        db = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = db.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(ListDataActivity.this, "The Database was empty.", Toast.LENGTH_LONG).show();
        } else {
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
*/