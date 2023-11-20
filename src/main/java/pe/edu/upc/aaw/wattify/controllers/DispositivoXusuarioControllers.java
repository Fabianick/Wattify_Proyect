package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.DispositivoDTO;
import pe.edu.upc.aaw.wattify.dtos.Dispositivo_x_UauarioDTO;
import pe.edu.upc.aaw.wattify.entities.Dispositivo;
import pe.edu.upc.aaw.wattify.entities.Dispositivo_X_Usuario;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IDispositivoXUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DispositivoXusuario")
public class DispositivoXusuarioControllers {
    @Autowired
    private IDispositivoXUsuarioService duS;

    @PostMapping()
    public void registrar(@RequestBody Dispositivo_x_UauarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Dispositivo_X_Usuario du = m.map(dto, Dispositivo_X_Usuario.class);
        duS.insert(du);
    }

    @GetMapping()
    public List<Dispositivo_x_UauarioDTO> listar() {
        return duS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Dispositivo_x_UauarioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        duS.eliminar(id);
    }

    @PutMapping
    public void modificar(@RequestBody Dispositivo_x_UauarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Dispositivo_X_Usuario u = m.map(dto, Dispositivo_X_Usuario.class);
        duS.insert(u);
    }

    @GetMapping("/{id}")
    public Dispositivo_X_Usuario listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        Dispositivo_X_Usuario dto=m.map(duS.listarId(id),Dispositivo_X_Usuario.class);
        return dto;
    }
}
