package mati.gatoencerradoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetalleLaberintoActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detalle_laberinto_activity);

            if (savedInstanceState == null) {

                Bundle arguments = new Bundle();
                arguments.putSerializable(DetalleLaberintoFragment.ARG_ITEM_ID,
                        getIntent().getSerializableExtra(DetalleLaberintoFragment.ARG_ITEM_ID));
                DetalleLaberintoFragment fragment = new DetalleLaberintoFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.descripcionLaberinto, fragment)
                        .commit();
            }
        }

        /*setContentView(R.layout.detalle_laberinto_activity);
        tv = (TextView) findViewById(R.id.nombreLab);
        tv1 = (TextView) findViewById(R.id.descripcionLab);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if(extras != null ){
            String dato1 = extras.getString("NOMBRE LABERINTO");
            String dato2 = extras.getString("DESCRIPCION");
            tv.setText(dato1);
            tv1.setText(dato2);
        }
*/

    }


