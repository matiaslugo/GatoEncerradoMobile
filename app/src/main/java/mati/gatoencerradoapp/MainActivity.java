package mati.gatoencerradoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Servicios.LaberintosService;
import dominio.LaberintoAndroid;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements LaberintoListFragment.Callbacks {

    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       }

    @Override
    public void onItemSelected(LaberintoAndroid laberinto) {
    Intent detailIntent = new Intent(this, DetalleLaberintoActivity.class);
        Log.w("Lab", laberinto.getNombreLaberinto());
        detailIntent.putExtra(DetalleLaberintoFragment.ARG_ITEM_ID, laberinto);
        startActivity(detailIntent);
    }

    public void abrirInventario(View view) {
        Intent intent = new Intent(MainActivity.this, GestionarInventarioActivity.class);
        startActivity(intent);
    }

}