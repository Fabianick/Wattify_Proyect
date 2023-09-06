package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.UsuarioDTO;
import pe.edu.upc.aaw.wattify.entities.Usuario;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m= new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.insert(u);
    }

    @GetMapping
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        UsuarioDTO dto= m.map(uS.listId(id),UsuarioDTO.class);
        return dto;
    }

}
