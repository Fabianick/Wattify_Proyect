package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.DispositivoDTO;
import pe.edu.upc.aaw.wattify.entities.Dispositivo;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IDispositivoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {
    @Autowired
    private IDispositivoService dS;

    @PostMapping
    public void registrar(@RequestBody DispositivoDTO dto) {
        ModelMapper m = new ModelMapper();
        Dispositivo u = m.map(dto, Dispositivo.class);
        dS.insert(u);
    }

    @GetMapping
    public List<DispositivoDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DispositivoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        dS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody DispositivoDTO dto) {
        ModelMapper m = new ModelMapper();
        Dispositivo u = m.map(dto, Dispositivo.class);
        dS.insert(u);
    }

    @GetMapping("/{id}")
    public DispositivoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        DispositivoDTO dto=m.map(dS.listarId(id),DispositivoDTO.class);
        return dto;
    }


    @GetMapping("/buscarNombre")
    public DispositivoDTO listarName(String nombre) {
        ModelMapper m = new ModelMapper();
        DispositivoDTO dto = m.map(dS.findFirstByNombre(nombre), DispositivoDTO.class);
        return dto;
    }
}
