package com.davidramirez.appdatosusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class pantallaConfirma extends AppCompatActivity {
    public TextView txtNombre;
    public TextView txtFecha;
    public TextView txtTel;
    public TextView txtMail;
    public TextView txtDescr;
    String nombreP, fechaP, telefonoP, mailP, descripcionP;
    String nombre, fecha, telefono, mail, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_confirma);
        txtNombre = (TextView) findViewById(R.id.txtvNombre);
        txtFecha = (TextView) findViewById(R.id.txtvFecha);
        txtTel = (TextView) findViewById(R.id.txtvTelefono);
        txtMail = (TextView) findViewById(R.id.txtvmail);
        txtDescr = (TextView) findViewById(R.id.txtvDescripcion);
        Bundle extras = getIntent().getExtras();
        nombreP = extras.getString("Nombre");
        fechaP = extras.getString("Fecha");
        telefonoP = extras.getString("Telefono");
        mailP = extras.getString("Mail");
        descripcionP = extras.getString("Descr");
        nombre = "Nombre: " + nombreP;
        fecha = "Fecha: " + fechaP;
        telefono = "Telefono: " + telefonoP;
        mail = "Mail: " + mailP;
        descripcion = "Descripcion: " + descripcionP;
        txtNombre.setText(nombre);
        txtFecha.setText(fecha);
        txtTel.setText(telefono);
        txtMail.setText(mail);
        txtDescr.setText(descripcion);
    }

    //para regresar actividad si se finaliza
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent regresaMain = new Intent(pantallaConfirma.this, MainActivity.class);
            regresaMain.putExtra("Nombre", nombre);
            regresaMain.putExtra("Fecha", fecha);
            regresaMain.putExtra("Telefono", telefono);
            regresaMain.putExtra("Mail", mail);
            regresaMain.putExtra("Descripcion", descripcion);
            startActivity(regresaMain);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickBtnEditar(View v) {
        Intent regresar = new Intent(pantallaConfirma.this, MainActivity.class);
        regresar.putExtra("Nombre", nombreP);
        regresar.putExtra("Fecha", fechaP);
        regresar.putExtra("Telefono", telefonoP);
        regresar.putExtra("Mail", mail);
        regresar.putExtra("Descripcion", descripcionP);
        startActivity(regresar);
    }
}
