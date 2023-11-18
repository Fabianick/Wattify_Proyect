package pe.edu.upc.aaw.wattify.serviceinterfaces;

import pe.edu.upc.aaw.wattify.entities.Metodo_de_Pago;
import pe.edu.upc.aaw.wattify.entities.TipoDispositivo;
import pe.edu.upc.aaw.wattify.entities.Users;

import java.time.LocalDate;
import java.util.List;

public interface ITipoDispositivoService {


    public void insert(TipoDispositivo tipoDispositivo);


    public List<TipoDispositivo> list();


    public void delete(int idTipoDispositivo);

    public List<String[]> cantidadDispositivosXtipo();

    public TipoDispositivo listarId(int id);

    public List<String[]> consumoTotaldeHoras();
}
