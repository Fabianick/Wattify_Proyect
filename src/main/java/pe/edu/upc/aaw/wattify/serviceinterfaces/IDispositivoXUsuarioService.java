package pe.edu.upc.aaw.wattify.serviceinterfaces;

import pe.edu.upc.aaw.wattify.entities.Dispositivo_X_Usuario;
import pe.edu.upc.aaw.wattify.entities.Membresia;

import java.util.List;

public interface IDispositivoXUsuarioService {
    public void insert(Dispositivo_X_Usuario dispositivo_X_Usuario);

    public List<Dispositivo_X_Usuario> list();
    public void eliminar(int id_DxUsuario);

    public Dispositivo_X_Usuario listarId(int iddisxusu);

}
