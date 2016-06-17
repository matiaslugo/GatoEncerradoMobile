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

import Servicios.LaberintoMinimizado;

/**
 * Created by vhzanardi on 17/06/2016.
 */
public class LaberintoAdapter extends ArrayAdapter<LaberintoMinimizado> {

    //algooooo

    Context context;
    int layoutResourceId;
    ArrayList<LaberintoMinimizado> data = null;

    public LaberintoAdapter(Context context, int layoutResourceId, ArrayList<LaberintoMinimizado> data){
        super(context,layoutResourceId,data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View converView, ViewGroup parent){
        View row = converView;
        LaberintoHolder holder = null;

        if(row == null){
            LayoutInflater inflader = ((Activity) context).getLayoutInflater();
            row = inflader.inflate(layoutResourceId,parent,false);

            holder = new LaberintoHolder();
            holder.images = (ImageView) row.findViewById(R.id.imagenlab);
            holder.texto = (TextView) row.findViewById(R.id.tv);
            row.setTag(holder);
        } else {
            holder = (LaberintoHolder)row.getTag();
        }

        LaberintoMinimizado lab = data.get(position);
        holder.texto.setText(lab.getNombreLaberinto());
        //int ima = Integer.parseInt(lab.getPath());
        //holder.images.setImageResource(ima);


        return  row;

    }

    static class LaberintoHolder {
        ImageView images;
        TextView texto;
    }


}
