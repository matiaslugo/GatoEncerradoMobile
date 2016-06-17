package mati.gatoencerradoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        LaberintoAdapter labAdapter = new LaberintoAdapter(this, R.layout.listview_item_row, servicio.listaDeLaberintosMinimizados());

        listView = (ListView) findViewById(R.id.listView1);
        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView.addHeaderView(header);
        listView.setAdapter(labAdapter);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
                Intent i= new Intent(currentClass.this,secondActivity.class);
                i.putExtra("string",Yourlist.get(pos).sms);
                startActivity(i);
                finish();
            }
        });*/
    }
}
