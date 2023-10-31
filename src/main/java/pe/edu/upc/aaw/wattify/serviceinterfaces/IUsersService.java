package pe.edu.upc.aaw.wattify.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.wattify.entities.Users;

import java.util.List;

public interface IUsersService {
    public void insert(Users users);
    public List<Users>listar();
    public void delete(Long id);
    public void insRol(String authority,Long user_id);
    List<String[]> cantidad_usuarios_bygenero();

}
