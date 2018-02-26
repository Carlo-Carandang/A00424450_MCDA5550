package ca.smu.bmi;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlocarandang on 2018-02-26.
 */

public class ListAdapter extends ArrayAdapter{
    List list=new ArrayList();
    public ListAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView dateTxt,heightTxt,weightTxt,BMI;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row=convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.list_adapter_view,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.dateTxt= row.findViewById(R.id.listDate);
            layoutHandler.heightTxt= row.findViewById(R.id.listHeight);
            layoutHandler.weightTxt= row.findViewById(R.id.listWeight);
            layoutHandler.BMI= row.findViewById(R.id.listBMI);
            row.setTag(layoutHandler);

        }else {

            layoutHandler=(LayoutHandler)row.getTag();

        }

        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.dateTxt.setText(dataProvider.getDateTxt());
        layoutHandler.heightTxt.setText(dataProvider.getHeightTxt());
        layoutHandler.weightTxt.setText(dataProvider.getWeightTxt());
        layoutHandler.BMI.setText(dataProvider.getBMI());

        return row;

    }
}
