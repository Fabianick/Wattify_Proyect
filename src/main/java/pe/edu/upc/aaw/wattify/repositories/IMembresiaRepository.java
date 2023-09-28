package pe.edu.upc.aaw.wattify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.wattify.entities.Membresia;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMembresiaRepository extends JpaRepository<Membresia, Integer> {

@Query(value = "select m.tipo_membresia, count(u.id_usuario) as cantidad_de_usuarios, sum(m.precio) as dinero_generado\n" +
        " from membresia m\n" +
        " inner join usuarios u \n" +
        " on m.id_usuario = u.id_usuario\n" +
        " group by m.tipo_membresia",nativeQuery = true)
    public List<String[]>CantUsuariosPrecioTotalXTipoMembresia();
}

