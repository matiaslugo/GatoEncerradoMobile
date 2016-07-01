package mati.gatoencerradoapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import Servicios.ItemDelInventarioMinimizado;
import Servicios.LaberintoMinimizado;

/**
 * Created by casa874 on 01/07/16.
 */
public class InventarioAdapter extends ArrayAdapter<ItemDelInventarioMinimizado> {

    Context context;
    int layoutResourceId;
    ArrayList<ItemDelInventarioMinimizado> data = null;

    public InventarioAdapter(Context context, int layoutResourceId, ArrayList<ItemDelInventarioMinimizado> data){
        super(context,layoutResourceId,data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View converView, ViewGroup parent){
        View row = converView;
        InventarioHolder holder = null;

        if(row == null){
            LayoutInflater inflader = ((Activity) context).getLayoutInflater();
            row = inflader.inflate(layoutResourceId,parent,false);

            holder = new InventarioHolder();
            holder.images = (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView) row.findViewById(R.id.tv);
            row.setTag(holder);
        } else {
            holder = (InventarioHolder) row.getTag();
        }

        ItemDelInventarioMinimizado item = data.get(position);
        holder.texto.setText(item.getNombreItem());
        //int ima = Integer.parseInt(lab.getPath());
        //holder.images.setImageResource(ima);


        return  row;

    }

    static class InventarioHolder {
        ImageView images;
        TextView texto;
    }
}
