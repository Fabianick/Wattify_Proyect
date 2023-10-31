package pe.edu.upc.aaw.wattify.serviceinterfaces;

import pe.edu.upc.aaw.wattify.entities.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> listar();
    public  void eliminar(long id);
}
