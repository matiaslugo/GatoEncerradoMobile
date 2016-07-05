
package mati.gatoencerradoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import dominio.ItemAndroid;
import dominio.LaberintoAndroid;

public class GestionarInventarioActivity extends AppCompatActivity implements InventarioFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestionar_inventario_activity);
    }

    @Override
    public void onItemSelected(ItemAndroid item) {
//        Intent detailIntent = new Intent(this, GestionarInventarioActivity.class);
//        Log.w("Item", item.getNombreItem());
//        detailIntent.putExtra(DetalleLaberintoFragment.ARG_ITEM_ID, item);
//        startActivity(detailIntent);
    }

}
