package com.jgmayer.donalologin;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoPublicacion {
    Context c;
    Publicacion u;
    ArrayList<Publicacion> lista;
    SQLiteDatabase sql;
    String bd="BDPublicaciones";
    String tabla="create table if not exists publicacion (id integer primary key autoincrement, tipo text,producto text,descripcion text,contacto text)";

    public daoPublicacion(Context c){

        this.c= c;
        sql= this.c.openOrCreateDatabase(bd, c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u= new Publicacion();
    }
    public boolean insertPublicacion(Publicacion u){
       // if(buscar (u.getPublicacion())==0) {
            ContentValues cv = new ContentValues();
            cv.put("tipo", u.getTipo());
            cv.put("producto", u.getProducto());
            cv.put("descripcion", u.getDescripcion());
            cv.put("contacto", u.getContacto());
            return (sql.insert("publicacion", null, cv) > 0);
       // }else {
          //  return false;
       // }
    }
    public int buscar(String u){
        int x=0;
        lista= selectPublicacion();
        for (Publicacion us:lista){
            if(us.getProducto().equals(u)){
                x++;
            }
        }
        return x;
    }



    public ArrayList<Publicacion> selectPublicacion(){
        ArrayList<Publicacion> lista=new ArrayList<Publicacion>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from publicacion",null);
        if (cr!= null&&cr.moveToFirst()){
            do {
                Publicacion u= new Publicacion();
                u.setId(cr.getInt(0));
                u.setTipo(cr.getString(1));
                u.setProducto(cr.getString(2));
                u.setDescripcion(cr.getString(3));
                u.setContacto(cr.getString(4));
                lista.add(u);



            }while (cr.moveToNext());
        }
        return lista;

    }
    public int login (String u, String p) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from publicacion", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(1).equals(u) && cr.getString(2).equals(p)) {
                    a++;
                }
            } while (cr.moveToNext());
        } return a;
    }
    public Publicacion getPublicacion(String u, String p){
        lista=selectPublicacion();
        for (Publicacion us:lista){
            if (us.getTipo().equals(u)&&us.getProducto().equals(p)){
                return us;
            }
        }
        return null;
    }
   /* public Usuario getUsuarioById(int id){

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
comente este codigo porque no estamos implementando aun que se pueda actualizar la publicacion.*/


}