package edu.val.seleccionhorafecha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener
{

    private EditText caja_fecha;
    private EditText caja_hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.caja_fecha = findViewById(R.id.cajaFecha);
        this.caja_hora = findViewById(R.id.cajaHora);

        //PROGRAMOS EL EVEVENTO DE CAMBIO DE FOCO
        this.caja_fecha.setOnFocusChangeListener(this);
        this.caja_hora.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean tieneElFoco) {
        //lo que quiero hacer, es que salte un menú
        //cuando gana el foco
        if (tieneElFoco)//==true
        {
            switch (view.getId())
            {
                case R.id.cajaFecha:
                    Log.d("ETIQUETA_LOG", "Foco en CAJA FECHA");
                    //creo un díalogo y con show, lo muestro
                    new DialogoSeleccionFecha().show(getSupportFragmentManager(), "CALENDARIO");
                    break;
                case R.id.cajaHora:
                    Log.d("ETIQUETA_LOG", "Foco en CAJA HORA");
                    //TODO SACAR UNA VENTANA EMERGENTE PARA LA HORA
                    new DialogoSeleccionHora().show(getSupportFragmentManager(), "RELOJ");
                    break;
            }

        }


    }

    public void mostrarFechaSeleccionada (String fecha)
    {
        Log.d("ETIQUETA_LOG", "mostrarFechaSeleccionada " +fecha);
        this.caja_fecha.setText(fecha);
    }

    public void mostrarHoraSeleccionada (String hora)
    {
        Log.d("ETIQUETA_LOG", "mostrarHoraSeleccionada " +hora);
        this.caja_hora.setText(hora);
    }
}