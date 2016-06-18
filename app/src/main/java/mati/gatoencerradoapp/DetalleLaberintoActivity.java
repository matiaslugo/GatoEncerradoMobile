package mati.gatoencerradoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by vhzanardi on 17/06/2016.
 */
public class DetalleLaberintoActivity extends AppCompatActivity {

    TextView tv;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_laberinto_activity);
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


    }

}
