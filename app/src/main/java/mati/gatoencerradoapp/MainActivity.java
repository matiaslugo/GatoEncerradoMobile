package mati.gatoencerradoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

/*        listView = (ListView) findViewById(R.id.listView1);

        ArrayList<String> nombreLaberintos = new ArrayList<String>();
        ArrayList<LaberintoMinimizado> minis = servicio.listaDeLaberintosMinimizados();
        for(LaberintoMinimizado lab : minis){
            nombreLaberintos.add(lab.getNombreLaberinto());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,nombreLaberintos);

        listView.setAdapter(adapter);*/

        LaberintoAdapter labAdapter = new LaberintoAdapter(this, R.layout.listview_item_row, servicio.listaDeLaberintosMinimizados());

        listView = (ListView) findViewById(R.id.listView1);
        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView.addHeaderView(header);
        listView.setAdapter(labAdapter);
    }
}
