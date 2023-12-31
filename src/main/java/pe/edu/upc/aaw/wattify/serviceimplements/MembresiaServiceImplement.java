package pe.edu.upc.aaw.wattify.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.wattify.entities.Dispositivo;
import pe.edu.upc.aaw.wattify.entities.Membresia;
import pe.edu.upc.aaw.wattify.repositories.IMembresiaRepository;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IMembresiaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class MembresiaServiceImplement implements IMembresiaService {
    @Autowired
    private IMembresiaRepository mR;

    @Override
    public void insert(Membresia membresia) {
        mR.save(membresia);
    }

    @Override
    public List<Membresia> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int idMembresia) {
        mR.deleteById(idMembresia);
    }

    @Override
    public List<String[]> CantUsuariosXTipoMembresiaXMontoRecaudado() {
        return mR.CantUsuariosXTipoMembresiaXMontoRecaudado();
    }

    @Override
    public Membresia listarId(int idMembre) {
        return mR.findById(idMembre).orElse(new Membresia());
    }
}
