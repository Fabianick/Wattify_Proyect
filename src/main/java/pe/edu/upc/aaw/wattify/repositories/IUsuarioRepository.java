package pe.edu.upc.aaw.wattify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.wattify.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT u.genero, COUNT(u.id_usuario) AS Cantidad\n" +
            " FROM usuarios u\n" +
            " GROUP BY genero",nativeQuery = true)
    List<String[]> cantidad_usuarios_bygenero();
}
