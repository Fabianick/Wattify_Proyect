package pe.edu.upc.aaw.wattify.entities;

import javax.persistence.*;

@Entity
@Table(name = "Dispositivo_X_Usuario")
public class Dispositivo_X_Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_DxUsuario;
    @Column(name = "cantidadDispositivos", nullable = false)
    private int cantidadDispositivos;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Dispositivo", referencedColumnName = "id_Dispositivo")
    private Dispositivo dispositivo;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Users users;

    // validar si no se debe eliminar el constructor  -_-

    public Dispositivo_X_Usuario() {
    }

    public Dispositivo_X_Usuario(int id_DxUsuario, int cantidadDispositivos, Dispositivo dispositivo, Users users) {
        this.id_DxUsuario = id_DxUsuario;
        this.cantidadDispositivos = cantidadDispositivos;
        this.dispositivo = dispositivo;
        this.users = users;
    }

    public int getId_DxUsuario() {
        return id_DxUsuario;
    }

    public void setId_DxUsuario(int id_DxUsuario) {
        this.id_DxUsuario = id_DxUsuario;
    }

    public int getCantidadDispositivos() {
        return cantidadDispositivos;
    }

    public void setCantidadDispositivos(int cantidadDispositivos) {
        this.cantidadDispositivos = cantidadDispositivos;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
