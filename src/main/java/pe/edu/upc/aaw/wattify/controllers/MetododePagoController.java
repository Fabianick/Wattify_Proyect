package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.MetodoPagoDTO;
import pe.edu.upc.aaw.wattify.entities.Dispositivo_X_Usuario;
import pe.edu.upc.aaw.wattify.entities.Metodo_de_Pago;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IMetododePagoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metododepago")

public class MetododePagoController {

    @Autowired
    private IMetododePagoService mS;

    @PostMapping
    public void registrar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Metodo_de_Pago mp = m.map(dto, Metodo_de_Pago.class);
        mS.insert(mp);
    }

    @GetMapping
    public List<MetodoPagoDTO> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        mS.delete(id);
    }


    @PutMapping
    public void modificar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Metodo_de_Pago mp = m.map(dto, Metodo_de_Pago.class);
        mS.insert(mp);
    }

    @GetMapping("/{id}")
    public Metodo_de_Pago listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        Metodo_de_Pago dto=m.map(mS.listarId(id),Metodo_de_Pago.class);
        return dto;
    }

}
