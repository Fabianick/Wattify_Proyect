package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.ConsumoHorasDispositivoDTO;
import pe.edu.upc.aaw.wattify.dtos.DispositivosXTiposDTO;
import pe.edu.upc.aaw.wattify.dtos.TipoDispositivoDTO;
import pe.edu.upc.aaw.wattify.entities.TipoDispositivo;
import pe.edu.upc.aaw.wattify.serviceinterfaces.ITipoDispositivoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos-dispositivos")
public class TipoDispositivoController {

    @Autowired
    private ITipoDispositivoService tipoDispositivoService;

    @PostMapping
    public void registrar(@RequestBody TipoDispositivoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        TipoDispositivo tipoDispositivo = modelMapper.map(dto, TipoDispositivo.class);
        tipoDispositivoService.insert(tipoDispositivo);
    }

    @GetMapping
    public List<TipoDispositivoDTO> listar() {
        return tipoDispositivoService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, TipoDispositivoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        tipoDispositivoService.delete(id);
    }

    @PutMapping
    public void actualizar(@RequestBody TipoDispositivoDTO dto){
        ModelMapper m = new ModelMapper();
        TipoDispositivo t=m.map(dto,TipoDispositivo.class);
        tipoDispositivoService.insert(t);
    }

    @GetMapping("/{id}")
    public TipoDispositivoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        TipoDispositivoDTO dto=m.map(tipoDispositivoService.listarId(id),TipoDispositivoDTO.class);
        return dto;
    }


    @GetMapping("/CantidadDeDispositivosXTipo")
    public List<DispositivosXTiposDTO> cantidadTotalDeDispositivosPortioDeDispositivo() {
        List<String[]> lista = tipoDispositivoService.cantidadDispositivosXtipo();
        List<DispositivosXTiposDTO> listaDTO = new ArrayList<>();
        for (String[] data : lista) {
            DispositivosXTiposDTO dto = new DispositivosXTiposDTO();
            dto.setNombre_tipo_dispositivo(data[0]);
            dto.setCantidad_de_dispositivos(Integer.parseInt(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/ConsumoHorasByTipoDispositivo")
    public List<ConsumoHorasDispositivoDTO> consumoTipoDispositivo() {
        List<String[]> lista = tipoDispositivoService.consumoTotaldeHoras();
        List<ConsumoHorasDispositivoDTO> listaDTO = new ArrayList<>();
        for (String[] data : lista) {
            ConsumoHorasDispositivoDTO dto = new ConsumoHorasDispositivoDTO();
            dto.setNombre_tipo_dispositivo(data[0]);
            dto.setSum(Integer.parseInt(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
