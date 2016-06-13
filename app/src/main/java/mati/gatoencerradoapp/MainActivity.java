package mati.gatoencerradoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Servicios.LaberintoMinimizado;
import Servicios.Servicio;
import gatoEncerradoDom.GatoEncerradoModel;

public class MainActivity extends AppCompatActivity {

    GatoEncerradoModel sistema = new GatoEncerradoModel();
    ListView listView;
    Servicio servicio = new Servicio(sistema);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //alal

        listView = (ListView) findViewById(R.id.listView1);

        ArrayList<String> nombreLaberintos = new ArrayList<String>();
        for(LaberintoMinimizado lab:servicio.listaDeLaberintosMinimizados()){
            nombreLaberintos.add(lab.getNombreLaberinto());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,nombreLaberintos);

        listView.setAdapter(adapter);


    }
}
