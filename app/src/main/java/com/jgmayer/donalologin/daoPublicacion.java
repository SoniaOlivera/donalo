package com.jgmayer.donalologin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoPublicacion {
    Context r;
    Publicacion p;
    ArrayList<Publicacion> lista;
    SQLiteDatabase sql;
    String bd="BDPublicacion";
    String tabla="create table if not exists publicacion (id integer primary key autoincrement, tipo text,producto text,descripcion text, contacto text)";

    public daoPublicacion(Context r){
        this.p= p;
        sql= this.r.openOrCreateDatabase(bd, r.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        p= new Publicacion();
    }
    public boolean insertPublicacion(Publicacion p){
        //if(buscar (p.get())==0) {
            ContentValues cv = new ContentValues();
            cv.put("tipo", p.getTipo());
            cv.put("producto", p.getProducto());
            cv.put("descripcion", p.getDescripcion());
            cv.put("contacto", p.getContacto());
            return (sql.insert("publicacion", null, cv) > 0);
        }//else {
            //return false;
        }
    }
    public int buscar(String p){
        int x=0;
        lista= selectPublicaciones();
        for (Publicacion ps:lista){
            if(us.getPublicacion().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista=new ArrayList<Usuario>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuario",null);
        if (cr!= null&&cr.moveToFirst()){
            do {
                Usuario u= new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellidos(cr.getString(4));
                lista.add(u);



            }while (cr.moveToNext());
        }
        return lista;

    }
    public int login (String u, String p) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(1).equals(u) && cr.getString(2).equals(p)) {
                    a++;
                }
            } while (cr.moveToNext());
        } return a;
    }
    public Usuario getUsuario(String u, String p){
        lista=selectUsuarios();
        for (Usuario us:lista){
            if (us.getUsuario().equals(u)&&us.getPassword().equals(p)){
                return us;
            }
        }
        return null;
    }
    public Usuario getUsuarioById(int id){

        lista=selectUsuarios();
        for (Usuario us:lista){
            if (us.getId()==id){
                return us;
            }

        }
        return null;
    }
    public boolean updateUsuario(Usuario u){
        ContentValues cv = new ContentValues();
        cv.put("usuario", u.getUsuario());
        cv.put("pass", u.getPassword());
        cv.put("nombre", u.getNombre());
        cv.put("ap", u.getApellidos());
        return (sql.update("usuario",cv,"id="+ u.getId(),null) > 0);

    }
    public boolean deleteUsuario(int id){
        return (sql.delete("usuario","id= "+ id,null)>0);
    }



}