package pe.edu.upc.aaw.wattify.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.wattify.entities.Comprobante_pago;
import pe.edu.upc.aaw.wattify.entities.Dispositivo;
import pe.edu.upc.aaw.wattify.repositories.IComprobantepagoRepository;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IComprobantePagoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComprobantePagoServiceImplement implements IComprobantePagoService {
    @Autowired
    private IComprobantepagoRepository mR;

    @Override
    public void insert(Comprobante_pago comprobante_pago) {
        mR.save(comprobante_pago);
    }

    @Override
    public List<Comprobante_pago> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public List<String[]> SumaTotalXMetodoPago() {
        return mR.SumaTotalXMetodoPago();
    }
    @Override
    public Comprobante_pago listarId(int id) {
        return mR.findById(id).orElse(new Comprobante_pago());
    }



}
