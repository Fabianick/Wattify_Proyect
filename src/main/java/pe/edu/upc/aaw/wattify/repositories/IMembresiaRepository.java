package pe.edu.upc.aaw.wattify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.wattify.entities.Membresia;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMembresiaRepository extends JpaRepository<Membresia, Integer> {

@Query(value = "select m.tipo_membresia, count(u.id) as Cantidad_De_Usuarios, sum(m.precio) as Monto_Recaudado\n" +
        " from membresia m\n" +
        " inner join users u \n" +
        " on m.id_user = u.id\n" +
        " group by m.tipo_membresia",nativeQuery = true)
    public List<String[]>CantUsuariosXTipoMembresiaXMontoRecaudado();
}

