package pe.edu.upc.aaw.wattify.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.wattify.entities.Role;
import pe.edu.upc.aaw.wattify.repositories.RoleRepository;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    public RoleRepository rR;
    @Override
    public List<Role> listar() {
        return rR.findAll();
    }

    @Override
    public void eliminar(long id) {
        rR.deleteById(id);
    }
}
