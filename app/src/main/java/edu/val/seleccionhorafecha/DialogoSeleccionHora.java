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
    public void onTimeSet(TimePicker timePicker, int hora_sel, int minuto_sel) {
        String hora_final = null;
        String hora = null;
        String minuto = null;
        Log.d("ETIQUETA_LOG", "HORA = " + hora_sel + " Minutos = " + minuto_sel);
        //TODO PENDIENTE MOSTARR LA HORA SELECCIONADA EN ESTE DIALOGO EN LA ACTIVIDAD

        /*if (hora_sel < 10) {
            hora = "0" + hora_sel;
        }
        if (minutos < 10) {
            minuto = "0" + minutos;
        }*/
            //https://lineadecodigo.com/java/el-operador-ternario-en-java/
            hora = (hora_sel<10) ? "0"+hora_sel : ""+hora_sel;//IF TERNARIO
            minuto = (minuto_sel<10) ? "0"+minuto_sel : ""+minuto_sel;
            hora_final = hora +":"+ minuto;

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.mostrarHoraSeleccionada(hora_final);

    }
}