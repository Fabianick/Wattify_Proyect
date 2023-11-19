package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.aaw.wattify.dtos.DetallePagoDTO;

import pe.edu.upc.aaw.wattify.entities.Detalle_pago;

import pe.edu.upc.aaw.wattify.serviceinterfaces.IDetallepagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detallepago")

public class DetallePagoController {

    @Autowired
    private IDetallepagoService mS;

    @PostMapping
    public void registrar(@RequestBody DetallePagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Detalle_pago dp = m.map(dto, Detalle_pago.class);
        mS.insert(dp);
    }

    @GetMapping
    public List<DetallePagoDTO> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetallePagoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        mS.delete(id);
    }

    @PutMapping
    public void actualizar(@RequestBody DetallePagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Detalle_pago d = m.map(dto, Detalle_pago.class);
        mS.insert(d);
    }

    @GetMapping("/{id}")
    public DetallePagoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        DetallePagoDTO dto=m.map(mS.listarId(id),DetallePagoDTO.class);
        return dto;
    }
}
