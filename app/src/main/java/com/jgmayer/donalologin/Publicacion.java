package com.jgmayer.donalologin;

public class Publicacion {
    int id;
    String Tipo,Producto,Descripcion,Contacto;

    public Publicacion() {

    }

    public Publicacion(String tipo, String producto, String descripcion, String contacto) {
        Tipo = tipo;
        Producto = producto;
        Descripcion = descripcion;
        Contacto = contacto;
    }

    /*public boolean isNull(){

        if (Nombre.equals("")&&Apellidos.equals("")&&Usuario.equals("")&&Password.equals("")){
            return false;
        }
        else {
            return true;
        }
    }*/

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", Tipo='" + Tipo + '\'' +
                ", Producto='" + Producto + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Contacto='" + Contacto + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }

    public boolean isNull() {
    }
}
