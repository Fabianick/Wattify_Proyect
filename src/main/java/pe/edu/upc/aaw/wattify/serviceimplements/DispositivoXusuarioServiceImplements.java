package pe.edu.upc.aaw.wattify.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.wattify.entities.Dispositivo;
import pe.edu.upc.aaw.wattify.entities.Dispositivo_X_Usuario;
import pe.edu.upc.aaw.wattify.repositories.Dispositivo_x_UsuarioRepository;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IDispositivoXUsuarioService;

import java.util.List;

@Service
public class DispositivoXusuarioServiceImplements implements IDispositivoXUsuarioService {
    @Autowired
    private Dispositivo_x_UsuarioRepository dsR;

    @Override
    public void insert(Dispositivo_X_Usuario dispositivo_X_Usuario) {
        dsR.save(dispositivo_X_Usuario);
    }

    @Override
    public List<Dispositivo_X_Usuario> list() {
        return dsR.findAll();
    }

    @Override
    public void eliminar(int id_DxUsuario) {
        dsR.deleteById(id_DxUsuario);
    }

    @Override
    public Dispositivo_X_Usuario listarId(int iddisxusu) {
        return dsR.findById(iddisxusu).orElse(new Dispositivo_X_Usuario());
    }

}
