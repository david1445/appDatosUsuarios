package com.davidramirez.appdatosusuarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nombre, telefono, fecha, email, descripcionCont;
    int dia, mes, year;
    public EditText edNombre;
    public EditText edTelefono;
    public EditText edMail;
    public EditText edDescr;
    public DatePicker tomaFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            edNombre = (EditText) findViewById(R.id.editNombre);
            edTelefono = (EditText) findViewById(R.id.edTelefono);
            edMail = (EditText) findViewById(R.id.edMail);
            edDescr = (EditText) findViewById(R.id.edDescContacto);
            tomaFecha = (DatePicker) findViewById(R.id.tomaFecha);
            if (getIntent().getExtras() != null) {
                Log.i("ENTRO", "esta entrado al if de comparacion");
                Bundle regresarAView = getIntent().getExtras();
                edNombre.setText(regresarAView.getString("Nombre"));
                edTelefono.setText(regresarAView.getString("Telefono"));
                edMail.setText(regresarAView.getString("Mail"));
                edDescr.setText(regresarAView.getString("Descripcion"));
            }

        } catch (Exception e) {

        }

    }

    public void onClickbtnSegPantalla(View v) {
        try {
            nombre = edNombre.getText().toString();
            telefono = edTelefono.getText().toString();
            dia = tomaFecha.getDayOfMonth();
            mes = tomaFecha.getMonth();
            year = tomaFecha.getYear();
            fecha = dia + "/" + mes + "/" + year;
            email = edMail.getText().toString();
            descripcionCont = edDescr.getText().toString();
            Intent intent = new Intent(MainActivity.this, pantallaConfirma.class);
            //aqui van los extra
            intent.putExtra("Nombre", nombre);
            intent.putExtra("Fecha", fecha);
            intent.putExtra("Telefono", telefono);
            intent.putExtra("Mail", email);
            intent.putExtra("Descr", descripcionCont);
            startActivity(intent);
            // finish();
        } catch (Exception e) {
        }


    }


}
