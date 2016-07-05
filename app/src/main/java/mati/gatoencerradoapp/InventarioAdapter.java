
package mati.gatoencerradoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import dominio.ItemAndroid;


public class InventarioAdapter extends ArrayAdapter<ItemAndroid>{

    public InventarioAdapter(Context context, List<ItemAndroid> data){
        super(context,R.layout.listview_item_row,data);

    }

    public View getView(int position, View converView, ViewGroup parent){

        LayoutInflater inflader = (LayoutInflater)(getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));

        View inventarioView = inflader.inflate(R.layout.listview_item_row,parent,false);
        final ItemAndroid itemAndroid = getItem(position);

        TextView textView = (TextView) inventarioView.findViewById(R.id.nombreItem);
        textView.setText(itemAndroid.getNombreItem());

        return  inventarioView;
    }

}

