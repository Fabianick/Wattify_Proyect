package pe.edu.upc.aaw.wattify.dtos;

import pe.edu.upc.aaw.wattify.entities.Dispositivo;
import pe.edu.upc.aaw.wattify.entities.Users;

public class Dispositivo_x_UauarioDTO {
    private int id_DxUsuario;
    private int cantidadDispositivos;
    private Dispositivo dispositivo;
    private UsersDTO users;

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

    public UsersDTO getUsers() {
        return users;
    }

    public void setUsers(UsersDTO users) {
        this.users = users;
    }
}
