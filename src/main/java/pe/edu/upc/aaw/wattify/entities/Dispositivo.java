package pe.edu.upc.aaw.wattify.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Dispositivo")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDispositivo;
    @Column(name = "nombre", nullable = false, length = 35)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 350)
    private String descripcion;
    @Column(name = "consumoHora", nullable = false)
    private int consumoHora;
    @Column(name = "horasEncendidas", nullable = false)
    private int horasEncendidas;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "idTipoDispo")
    private TipoDispositivo tipoDispositivo;

    //@OneToMany(mappedBy = "dispositivo", cascade = CascadeType.ALL)
   // private List<Dispositivo_X_Usuario> dispositivo_X_Usuario;

    public Dispositivo() {
    }

    public Dispositivo(int idDispositivo, String nombre, String descripcion, int consumoHora, int horasEncendidas, LocalDate fecha, TipoDispositivo tipoDispositivo) {
        this.idDispositivo = idDispositivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.consumoHora = consumoHora;
        this.horasEncendidas = horasEncendidas;
        this.fecha = fecha;
        this.tipoDispositivo = tipoDispositivo;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getConsumoHora() {
        return consumoHora;
    }

    public void setConsumoHora(int consumoHora) {
        this.consumoHora = consumoHora;
    }

    public int getHorasEncendidas() {
        return horasEncendidas;
    }

    public void setHorasEncendidas(int horasEncendidas) {
        this.horasEncendidas = horasEncendidas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }
}
