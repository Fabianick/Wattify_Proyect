package pe.edu.upc.aaw.wattify.dtos;

import pe.edu.upc.aaw.wattify.entities.Membresia;
import pe.edu.upc.aaw.wattify.entities.Metodo_de_Pago;
import pe.edu.upc.aaw.wattify.entities.Users;

import java.time.LocalDate;
public class ComprobantePagoDTO {
    private int id;
    private LocalDate fechaEmision;
    private int costo_total;
    private UsersDTO user;
    private Metodo_de_Pago metodo_de_pago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(int costo_total) {
        this.costo_total = costo_total;
    }

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }

    public Metodo_de_Pago getMetodo_de_pago() {
        return metodo_de_pago;
    }

    public void setMetodo_de_pago(Metodo_de_Pago metodo_de_pago) {
        this.metodo_de_pago = metodo_de_pago;
    }
}
