package com.jgmayer.donalologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevasPublicaciones extends AppCompatActivity implements View.OnClickListener {
    EditText tip,pro,des,con;
    Button reg,can;
    daoPublicacion dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevas_publicaciones);

        tip =(EditText)findViewById(R.id.TipoPublicacion);
        pro=(EditText)findViewById(R.id.Producto);
        des=(EditText)findViewById(R.id.Descripcion);
        con=(EditText)findViewById(R.id.Contacto);


        reg=(Button)findViewById(R.id.btnPublicar);
        can=(Button)findViewById(R.id.btnProdCancelar);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao=new daoPublicacion(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPublicar:
                Publicacion p= new Publicacion();
                p.setTipo(tip.getText().toString());
                p.setProducto(pro.getText().toString());
                p.setDescripcion(des.getText().toString());
                p.setContacto(con.getText().toString());
                if(!p.isNull()){
                    Toast.makeText(this,"ERROR:Campos Vacios",Toast.LENGTH_LONG).show();
                } else if (dao.insertPublicacion(p)){
                    Toast.makeText(this,"Publicacion Exitosa!!!",Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(NuevasPublicaciones.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                /*} else {
                    Toast.makeText(this,"Usuario ya registrado!!!",Toast.LENGTH_LONG).show();
                }*/
                break;
            case R.id.btnProdCancelar:
                Intent i= new Intent(NuevasPublicaciones.this,MainActivity.class);
                startActivity(i);
                finish();
                break;

        }

    }
}