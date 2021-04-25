package com.jgmayer.donalologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
    EditText us,pas,nom,ap;
    Button reg,can;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        us=(EditText)findViewById(R.id.Donar);
        pas=(EditText)findViewById(R.id.Producto);
        nom=(EditText)findViewById(R.id.Descripcion);
        ap=(EditText)findViewById(R.id.Contacto);


        reg=(Button)findViewById(R.id.btnPublicar);
        can=(Button)findViewById(R.id.btnProdCancelar);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPublicar:
                Usuario u=new Usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ap.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this,"ERROR:Campos Vacios",Toast.LENGTH_LONG).show();
                } else if (dao.insertUsuario(u)){
                    Toast.makeText(this,"Registro Exitoso!!!",Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(Registrar.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this,"Usuario ya registrado!!!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnProdCancelar:
                Intent i= new Intent(Registrar.this,MainActivity.class);
                startActivity(i);
                finish();
                break;

        }

    }
}