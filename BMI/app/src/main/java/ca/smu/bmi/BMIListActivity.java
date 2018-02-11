package ca.smu.bmi;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class BMIListActivity extends ListActivity {

    // Create dummy data until database is ready...add to activity
    BMIResult[] results={new BMIResult(5.5,100),new BMIResult(4.3,156)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_bmilist);
        // Add to "onCreate" to initialize the list
        ListView listBMIResults=getListView();
        ArrayAdapter<BMIResult>listAdapter=new ArrayAdapter<BMIResult>(
                this,
                android.R.layout.simple_list_item_1, // layout param for ListActivity
                results);
        listBMIResults.setAdapter(listAdapter);
    }

    //Add to activity to do something on click
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        System.out.println("Clicked on "+results[position].toString());
    }
}
