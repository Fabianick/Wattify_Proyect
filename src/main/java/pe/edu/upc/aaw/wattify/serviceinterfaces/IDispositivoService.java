package pe.edu.upc.aaw.wattify.serviceinterfaces;

import pe.edu.upc.aaw.wattify.entities.Dispositivo;

import java.util.List;

public interface IDispositivoService {
    public void insert(Dispositivo dispositivo);

    public List<Dispositivo> list();

    public void delete(int idDispositivo);

    Dispositivo findFirstByNombre(String nombre);

    public Dispositivo listarId(int idDispo);

}
