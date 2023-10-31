package pe.edu.upc.aaw.wattify.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.wattify.entities.Users;
import pe.edu.upc.aaw.wattify.repositories.UserRepository;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private UserRepository uR;
    @Override
    public void insert(Users users) {
        uR.save(users);
    }

    @Override
    public List<Users> listar() {
        return uR.findAll();
    }

    @Override
    public void delete(Long id) {
        uR.deleteById(id);
    }

    @Override
    public void insRol(String authority, Long user_id) {
        uR.insRol(authority,user_id);
    }
}
