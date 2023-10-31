package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.Membresia_X_UsuarioDTO;
import pe.edu.upc.aaw.wattify.dtos.UsuarioDTO;
import pe.edu.upc.aaw.wattify.dtos.Usuario_CantidadDTO;
import pe.edu.upc.aaw.wattify.entities.Usuario;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IUsuarioService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m= new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.insert(u);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')or hasAuthority('ADMIN')")
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('USER')")
    public void actualizar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
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

}
