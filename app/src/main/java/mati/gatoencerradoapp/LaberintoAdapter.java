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
import java.util.List;
import dominio.LaberintoAndroid;

public class LaberintoAdapter extends ArrayAdapter<LaberintoAndroid> {

    public LaberintoAdapter(Context context, List<LaberintoAndroid> data) {
        super(context, R.layout.listlaberinto_laberintoandroid, data);
    }

    public View getView(int position, View converView, ViewGroup parent) {

        LayoutInflater inflader = (LayoutInflater) (getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View laberintoView = converView;
        laberintoView = inflader.inflate(R.layout.listlaberinto_laberintoandroid,parent,false);
        final LaberintoAndroid laberintoAndroid = getItem(position);

        TextView textView = (TextView) laberintoView.findViewById(R.id.tvNombreLaberinto);
        textView.setText(laberintoAndroid.getNombreLaberinto());

        return  laberintoView;
    }
}
