package pe.edu.upc.aaw.wattify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.aaw.wattify.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    //Insertar los Roles
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE roles set rol=:rol where user_id= :user_id", nativeQuery = true)
    public void updRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM roles WHERE user_id = :user_id", nativeQuery = true)
    public void delRol(@Param("user_id") Long user_id);

}
