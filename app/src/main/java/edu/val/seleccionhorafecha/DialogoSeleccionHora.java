package edu.val.seleccionhorafecha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DialogoSeleccionHora extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    //se invoca cuando se representa el dialogo
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //PERSONALIZO EL RELOJ
        Dialog calendario = null;
        int hora, minutos;
        Calendar calendario_actual;

        calendario_actual = Calendar.getInstance();//cojo el calendario
        hora = calendario_actual.get(Calendar.HOUR_OF_DAY);
        minutos = calendario_actual.get(Calendar.MINUTE);


        //getActivity() - es la Activida "Padre" - MainActivity
        calendario = new TimePickerDialog(getActivity(), this, hora, minutos, true);

        return calendario;
    }

    //este método se va a invocar cuando se seleccione una fecha y le da aceptar
    @Override
    public void onTimeSet (TimePicker timePicker, int hora_sel, int minutos) {

        Log.d("ETIQUETA_LOG", "HORA = " + hora_sel + " Minutos = " + minutos);
        //TODO PENDIENTE MOSTARR LA HORA SELECCIONADA EN ESTE DIALOGO EN LA ACTIVIDAD

    }
}