package pe.edu.upc.aaw.wattify.serviceinterfaces;

import pe.edu.upc.aaw.wattify.entities.Dispositivo;
import pe.edu.upc.aaw.wattify.entities.Membresia;

import java.time.LocalDate;
import java.util.List;

public interface IMembresiaService {
    public void insert(Membresia membresia);
    public List<Membresia> list();
    public void delete(int idMembresia);
    public List<String[]>CantUsuariosXTipoMembresiaXMontoRecaudado();
    public Membresia listarId(int idMembre);

}
