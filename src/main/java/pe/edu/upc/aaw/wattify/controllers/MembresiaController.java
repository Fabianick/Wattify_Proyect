package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.MembresiaDTO;
import pe.edu.upc.aaw.wattify.dtos.Membresia_X_UsuarioDTO;
import pe.edu.upc.aaw.wattify.entities.Membresia;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IMembresiaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/membresias")

public class MembresiaController {

    @Autowired
    private IMembresiaService mS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody MembresiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Membresia mb = m.map(dto, Membresia.class);
        mS.insert(mb);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<MembresiaDTO> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MembresiaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public void eliminar(@PathVariable("id") Integer id) {
        mS.delete(id);
    }


    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public void modificar(@RequestBody MembresiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Membresia mb = m.map(dto, Membresia.class);
        mS.insert(mb);
    }

    @GetMapping("/nroUsersPrecioTotalxMembresia")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Membresia_X_UsuarioDTO> UsuarioPreccioXTipoMembresia() {
        List<String[]> lista = mS.CantUsuariosPrecioTotalXTipoMembresia();
        List<Membresia_X_UsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] data : lista) {
            Membresia_X_UsuarioDTO dto = new Membresia_X_UsuarioDTO();
            dto.setTipoMembresia(data[0]);
            dto.setCantidadUsuarios(Integer.parseInt(data[1]));
            dto.setPrecioTotal(new BigDecimal(data[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
