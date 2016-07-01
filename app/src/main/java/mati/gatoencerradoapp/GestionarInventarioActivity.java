package mati.gatoencerradoapp;

import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import Servicios.Servicio;
import gatoEncerradoDom.GatoEncerradoModel;

/**
 * Created by casa874 on 01/07/16.
 */
public class GestionarInventarioActivity extends AppCompatActivity {

    GatoEncerradoModel sistema = new GatoEncerradoModel();
    Servicio servicio = new Servicio(sistema);
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestionar_inventario_activity);

        InventarioAdapter invAdapter = new InventarioAdapter(this, R.layout.listview_item_row, servicio.listaDeItems());

        listView = (ListView) findViewById(R.id.listItems);
        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView.addHeaderView(header);
        listView.setAdapter(invAdapter);

    }
}