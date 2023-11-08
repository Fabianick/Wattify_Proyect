package pe.edu.upc.aaw.wattify.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.wattify.entities.TipoDispositivo;
import pe.edu.upc.aaw.wattify.repositories.ITipoDispositivoRepository;
import pe.edu.upc.aaw.wattify.serviceinterfaces.ITipoDispositivoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class TipoDispositivoServiceImplements implements ITipoDispositivoService {

    @Autowired
    private ITipoDispositivoRepository mR;


    @Override
    public void insert(TipoDispositivo tipoDispositivo) {

        mR.save(tipoDispositivo);

    }

    @Override
    public List<TipoDispositivo> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int idTipoDispositivo) {
        mR.deleteById(idTipoDispositivo);
    }

    @Override
    public List<String[]> cantidadDispositivosXtipo() {
        return mR.cantidadDispositivosXtipo();
    }

    @Override
    public TipoDispositivo listarId(int id) {
        return mR.findById(id).orElse(new TipoDispositivo());
    }
}

