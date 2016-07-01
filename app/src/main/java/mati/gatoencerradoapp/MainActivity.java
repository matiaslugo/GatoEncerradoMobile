package mati.gatoencerradoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import Servicios.Servicio;
import gatoEncerradoDom.GatoEncerradoModel;
import gatoEncerradoDom.Item;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    GatoEncerradoModel sistema = new GatoEncerradoModel();
    ListView listView;
    Button boton;
    Servicio servicio = new Servicio(sistema);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Aca se crea el adapter para que los laberintos se muestren en forma de lista
        LaberintoAdapter labAdapter = new LaberintoAdapter(this, R.layout.listview_item_row, servicio.listaDeLaberintosMinimizados());

        listView = (ListView) findViewById(R.id.listView1);
        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView.addHeaderView(header);
        listView.setAdapter(labAdapter);

        //Accion de cuando se hace click en un laberinto se pueda pasar a la siguiente
        // activity para ver el detalle del mismo.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                    Intent myIntent = new Intent(view.getContext(), DetalleLaberintoActivity.class);
                // En esta linea pasamos el numero del laberinto que deseamos ver el detalle
                    myIntent.putExtra("NOMBRE LABERINTO",servicio.listaDeLaberintosMinimizados().get(position-1).getNombreLaberinto());
                    myIntent.putExtra("DESCRIPCION"," ALTO LABERINTO PADRE");
                    startActivityForResult(myIntent, position);
                // algo
            }
        });

        boton = (Button) findViewById(R.id.botonGestionarInventario);
        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonGestionarInventario:
                Intent intent = new Intent(MainActivity.this,GestionarInventarioActivity.class);
                startActivity(intent);
                break;
        }
    }
}
