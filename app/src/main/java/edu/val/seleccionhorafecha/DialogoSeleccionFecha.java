package edu.val.seleccionhorafecha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;


public class DialogoSeleccionFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    //se invoca cuando se representa el dialogo
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //PERSONALIZO EL CALENDARIO
        Dialog calendario = null;
        int anio, mes, dia;
        Calendar calendario_actual;

                calendario_actual = Calendar.getInstance();//cojo el calendario
                anio = calendario_actual.get(Calendar.YEAR);
                mes = calendario_actual.get(Calendar.MONTH);
                dia = calendario_actual.get(Calendar.DATE);//DÍA del mes

            //getActivity() - es la Activida "Padre" - MainActivity
            calendario = new DatePickerDialog(getActivity(), this, anio, mes, dia);

        return calendario;
    }

    //este método se va a invocar cuando se seleccione una fecha y le da aceptar
    @Override
    public void onDateSet(DatePicker datePicker, int anio, int mes, int diaMes) {
        mes++;
        String fecha = diaMes +"/" + mes +"/"+anio;
        Log.d("ETIQUETA_LOG", fecha);
        //TODO PENDIENTE MOSTARR LA FECHA SELECCIONADA EN ESTE DIALOGO EN LA ACTIVIDAD
        //opción 1 guardar un fichero de preferencias
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.mostrarFechaSeleccionada(fecha);//ACTUALIZO LA ACTIVIDAD PRINCIPAL

    }
}
