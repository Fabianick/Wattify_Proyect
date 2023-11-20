package pe.edu.upc.aaw.wattify.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.wattify.dtos.DispositivoDTO;
import pe.edu.upc.aaw.wattify.dtos.MembresiaDTO;
import pe.edu.upc.aaw.wattify.dtos.Membresia_X_UsersDTO;
import pe.edu.upc.aaw.wattify.entities.Membresia;
import pe.edu.upc.aaw.wattify.serviceinterfaces.IMembresiaService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/membresia")

public class MembresiaController {

    @Autowired
    private IMembresiaService mS;

    @PostMapping
    public void registrar(@RequestBody MembresiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Membresia mb = m.map(dto, Membresia.class);
        mS.insert(mb);
    }

    @GetMapping
    public List<MembresiaDTO> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MembresiaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        mS.delete(id);
    }


    @PutMapping
    public void modificar(@RequestBody MembresiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Membresia mb = m.map(dto, Membresia.class);
        mS.insert(mb);
    }

    @GetMapping("/{id}")
    public MembresiaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        MembresiaDTO dto=m.map(mS.listarId(id),MembresiaDTO.class);
        return dto;
    }


    @GetMapping("/usersXMembresiaXMontoRecaudado")
    public List<Membresia_X_UsersDTO> UsuarioPorMembresiaYMonto() {
        List<String[]> lista = mS.CantUsuariosXTipoMembresiaXMontoRecaudado();
        List<Membresia_X_UsersDTO> listaDTO = new ArrayList<>();
        for (String[] data : lista) {
            Membresia_X_UsersDTO dto = new Membresia_X_UsersDTO();
            dto.setTipoMembresia(data[0]);
            dto.setCantidadUsuarios(Integer.parseInt(data[1]));
            dto.setMontoRecaudado(new BigDecimal(data[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
