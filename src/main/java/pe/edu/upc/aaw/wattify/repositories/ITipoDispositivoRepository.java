package pe.edu.upc.aaw.wattify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.wattify.entities.TipoDispositivo;

import java.util.List;

@Repository
public interface ITipoDispositivoRepository extends JpaRepository<TipoDispositivo, Integer> {

    @Query(value = "select td.nombre_tipo_dispositivo, count(*) from tipo_dispositivo td join dispositivo d \n" +
            " on td.id_tipo_dispositivo = d.id_tipo_dispo\n" +
            " group by td.nombre_tipo_dispositivo",nativeQuery = true)
    public List<String[]> cantidadDispositivosXtipo();



    @Query(value = "select  td.nombre_tipo_dispositivo, sum(d.consumo_hora) from tipo_dispositivo td join dispositivo d \n" +
            "on td.id_tipo_dispositivo = d.id_tipo_dispo\n" +
            "group by td.nombre_tipo_dispositivo",nativeQuery = true)
    public List<String[]> consumoTotaldeHoras();


}
