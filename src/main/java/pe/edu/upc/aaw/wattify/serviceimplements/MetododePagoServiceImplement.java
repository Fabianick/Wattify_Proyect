package pe.edu.upc.aaw.wattify.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.wattify.entities.Metodo_de_Pago;
import pe.edu.upc.aaw.wattify.repositories.IMetododePagoRepository;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IMetododePagoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class MetododePagoServiceImplement implements IMetododePagoService {
    @Autowired
    private IMetododePagoRepository mR;

    @Override
    public void insert(Metodo_de_Pago metodo_de_pago) {
        mR.save(metodo_de_pago);
    }

    @Override
    public List<Metodo_de_Pago> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int id_MetodoPago) {
        mR.deleteById(id_MetodoPago);
    }

    @Override
    public Metodo_de_Pago listarId(int Metodo_de_Pago) {
        return mR.findById(Metodo_de_Pago).orElse(new Metodo_de_Pago());
    }


}
