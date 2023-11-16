package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.ComprobantePagoDTO;
import pe.edu.upc.aaw.wattify.dtos.DispositivoDTO;
import pe.edu.upc.aaw.wattify.dtos.SumaTotal_X_MetodoPagoDTO;
import pe.edu.upc.aaw.wattify.dtos.Usuario_CantidadDTO;
import pe.edu.upc.aaw.wattify.entities.Comprobante_pago;
import pe.edu.upc.aaw.wattify.entities.Dispositivo;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IComprobantePagoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comprobantepago")

public class ComprobantePagoController {

    @Autowired
    private IComprobantePagoService mS;

    @PostMapping
    public void registrar(@RequestBody ComprobantePagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Comprobante_pago cp = m.map(dto, Comprobante_pago.class);
        mS.insert(cp);
    }

    @GetMapping
    public List<ComprobantePagoDTO> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ComprobantePagoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        mS.delete(id);
    }

    @PutMapping
    public void actualizar(@RequestBody ComprobantePagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Comprobante_pago c = m.map(dto, Comprobante_pago.class);
        mS.insert(c);
    }

    @GetMapping("/{id}")
    public ComprobantePagoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        ComprobantePagoDTO dto=m.map(mS.listarId(id),ComprobantePagoDTO.class);
        return dto;
    }

    @GetMapping("/SumaTotalXMetodoPago")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<SumaTotal_X_MetodoPagoDTO> SumaTotalXMetodoPago(){
        List<String[]> lista = mS.SumaTotalXMetodoPago();
        List<SumaTotal_X_MetodoPagoDTO> listaDTO = new ArrayList<>();
        for (String[] data : lista) {
            SumaTotal_X_MetodoPagoDTO dto = new SumaTotal_X_MetodoPagoDTO();
            dto.setName(data[0]);
            dto.setCantidad(Double.parseDouble(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}

