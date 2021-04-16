package com.jgmayer.donalologin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Editar extends AppCompatActivity implements View.OnClickListener {

    EditText ediUser,ediPass,ediNombre,ediApellido



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar);
    }

    @Override
    public void onClick(View v) {

    }
}