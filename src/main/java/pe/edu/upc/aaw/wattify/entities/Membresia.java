package pe.edu.upc.aaw.wattify.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "Membresia")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Membresia;
    @Column(name = "tipoMembresia", length = 50, nullable = false)
    private String tipoMembresia;
    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fechaFin", nullable = false)
    private LocalDate fechaFin;
    @Column(name = "precio", length = 10, nullable = false)
    private BigDecimal precio;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;

    public Membresia() {
    }

    public Membresia(int id_Membresia, String tipoMembresia, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal precio, Users user) {
        this.id_Membresia = id_Membresia;
        this.tipoMembresia = tipoMembresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.user = user;
    }

    public int getId_Membresia() {
        return id_Membresia;
    }

    public void setId_Membresia(int id_Membresia) {
        this.id_Membresia = id_Membresia;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
