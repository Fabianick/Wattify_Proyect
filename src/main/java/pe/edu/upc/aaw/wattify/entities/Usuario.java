package pe.edu.upc.aaw.wattify.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name = "nombres", length = 45, nullable = false)
    private String Nombres;
    @Column(name = "apellidos", length = 45, nullable = false)
    private String Apellidos;
    @Column(name = "genero", length = 30, nullable = false)
    private String Genero;
    @Column(name = "direccion", length = 60, nullable = false)
    private String Direccion;
    @Column(name = "dni", length = 9, nullable = false)
    private String DNI;
    @Column(name = "celular", length = 10, nullable = false)
    private String Celular;


    public Usuario() {
    }

    public Usuario(int id, String nombres, String apellidos, String genero, String direccion, String DNI, String celular) {
        id_usuario = id;
        Nombres = nombres;
        Apellidos = apellidos;
        Genero = genero;
        Direccion = direccion;
        this.DNI = DNI;
        Celular = celular;
    }

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

    /*
    public List<Dispositivo_X_Usuario> getDispositivo_X_Usuario() {
        return dispositivo_X_Usuario;
    }

    public void setDispositivo_X_Usuario(List<Dispositivo_X_Usuario> dispositivo_X_Usuario) {
        this.dispositivo_X_Usuario = dispositivo_X_Usuario;
    }*/
}
