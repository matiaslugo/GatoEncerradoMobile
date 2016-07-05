package mati.gatoencerradoapp;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import dominio.LaberintoAndroid;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleLaberintoFragment extends Fragment implements View.OnClickListener {

    public static final String ARG_ITEM_ID = "item_id";

    private LaberintoAndroid laberinto;

    public DetalleLaberintoFragment() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            laberinto = (LaberintoAndroid) getArguments().get(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            activity.setTitle(laberinto.getNombreLaberinto());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String BASE_URL = "http://10.12.1.110:9000/";

        View rootView = inflater.inflate(R.layout.detallelaberintofragment, container, false);

        ((TextView) rootView.findViewById(R.id.labDescripcion)).setText(laberinto.getDescripcion());
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imagenLabDetalle);

        Picasso.with(this.getContext()).load(BASE_URL + "/images/" + laberinto.getPathImagen() + ".jpg").into(imageView);
//
//        Resources res = getResources();
//        String mDrawableName = laberinto.getPathImagen();
//        int resID = res.getIdentifier(mDrawableName , "drawable", getActivity().getPackageName());
//        imageView.setImageResource(resID);

        return rootView;
    }

    @Override
    public void onClick(View v){

    }
}

