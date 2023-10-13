package pe.edu.upc.aaw.wattify.dtos;

import javax.persistence.Column;

public class UsuarioDTO {
    private int id_usuario;
    private String Nombres;
    private String Apellidos;
    private String Genero;
    private String Direccion;
    private String DNI;
    private String Celular;

    public int getId() {
        return id_usuario;
    }

    public void setId(int id) {
        id_usuario = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }
}
