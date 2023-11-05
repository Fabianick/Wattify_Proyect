package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.UsersDTO;
import pe.edu.upc.aaw.wattify.dtos.Usuario_CantidadDTO;
import pe.edu.upc.aaw.wattify.entities.Users;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IUsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService uS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto,Users.class);
        uS.insert(u);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsersDTO> listar(){
        return uS.listar().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        uS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('USER')")
    public void actualizar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u=m.map(dto,Users.class);
        uS.insert(u);
    }

    @GetMapping("/cantidadBygenero")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Usuario_CantidadDTO> Cantidad_usuaarios_by_genero(){
        List<String[]> lista = uS.cantidad_usuarios_bygenero();
        List<Usuario_CantidadDTO> listaDTO = new ArrayList<>();
        for (String[] data : lista) {
            Usuario_CantidadDTO dto = new Usuario_CantidadDTO();
            dto.setGeneroUsuario(data[0]);
            dto.setCantidadUsuario(Integer.parseInt(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @PostMapping("/rolinsert")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertarRol(@RequestParam("authority") String authority,@RequestParam("user_id") Long user_id){
        uS.insRol(authority,user_id);
    }
}
