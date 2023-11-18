package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.MembresiaDTO;
import pe.edu.upc.aaw.wattify.dtos.RoleDTO;
import pe.edu.upc.aaw.wattify.entities.Membresia;
import pe.edu.upc.aaw.wattify.entities.Role;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    public IRoleService rS;

    @GetMapping
    public List<RoleDTO>listar(){
        return rS.listar().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,RoleDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        RoleDTO dto=m.map(rS.listarId(id),RoleDTO.class);
        return dto;
    }

    @PostMapping
    public void insertarRol(@RequestParam("authority") String authority,@RequestParam("user_id") Long user_id){
        rS.insRol(authority,user_id);
    }

    @PutMapping
    public void modificarRol(@RequestParam("authority") String authority,@RequestParam("user_id") Long user_id){
        rS.updRol(authority,user_id);
    }

    @DeleteMapping("/{user_id}")
    public void eliminar(@PathVariable("user_id") Long user_id){
        rS.delRol(user_id);
    }


}
