package ca.smu.bmi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
/* import android.widget.ListAdapter;*/
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by carlocarandang on 2018-02-11.
 */

public class ListDataActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    ListView listView;
    DatabaseHelper db;
    Cursor cursor;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        listView = findViewById(R.id.list_view);
        db = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase=db.getReadableDatabase();
        cursor=db.getAllData();
        listAdapter = new ListAdapter(getApplicationContext(), R.layout.list_adapter_view);
        listView.setAdapter(listAdapter);

        if(cursor.moveToFirst())
        {
            do {
                String dateTxt,heightTxt,weightTxt,BMI;
                dateTxt=cursor.getString(0);
                heightTxt=cursor.getString(1);
                weightTxt=cursor.getString(2);
                BMI=cursor.getString(3);
                DataProvider dataProvider = new DataProvider(dateTxt,heightTxt,weightTxt,BMI);
                listAdapter.add(dataProvider);

            }
            while (cursor.moveToNext()) ;
        }
    }
}
