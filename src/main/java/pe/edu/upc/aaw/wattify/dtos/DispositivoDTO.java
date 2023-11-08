package pe.edu.upc.aaw.wattify.dtos;

import pe.edu.upc.aaw.wattify.entities.TipoDispositivo;

import java.time.LocalDate;

public class DispositivoDTO {
    private int idDispositivo;
    private String nombre;
    private String descripcion;
    private int consumoHora;
    private int horasEncendidas;
    private LocalDate fecha;
    private TipoDispositivo tipoDispositivo;

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
