package pe.edu.upc.aaw.wattify.serviceinterfaces;
import pe.edu.upc.aaw.wattify.entities.Comprobante_pago;
import pe.edu.upc.aaw.wattify.entities.Detalle_pago;
import pe.edu.upc.aaw.wattify.entities.Dispositivo;

import java.time.LocalDate;
import java.util.List;

public interface IComprobantePagoService {
    public void insert(Comprobante_pago comprobante_pago);
    public List<Comprobante_pago> list();
    public void delete(int id);

    public List<String[]> SumaTotalXMetodoPago();

    public Comprobante_pago listarId(int id);
}