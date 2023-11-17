package pe.edu.upc.aaw.wattify.serviceinterfaces;
import pe.edu.upc.aaw.wattify.entities.Comprobante_pago;
import pe.edu.upc.aaw.wattify.entities.Detalle_pago;
import java.util.List;

public interface IDetallepagoService {
    public void insert(Detalle_pago detalle_pago);
    public List<Detalle_pago> list();
    public void delete(int id);

    public Detalle_pago listarId(int id);
}