package pe.edu.upc.aaw.wattify.entities;
import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Comprobante_pago")
public class Comprobante_pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fechaEmision", length = 50, nullable = false)
    private LocalDate fechaEmision;

    @ManyToOne
    @JoinColumn(name = "idMetodo_de_Pago")
    private Metodo_de_Pago metodo_de_pago;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;

    @Column(name = "Costo_total", length = 50, nullable = false)
    private int Costo_total;

    public Comprobante_pago() {
    }

    public Comprobante_pago(int id, LocalDate fechaEmision, Metodo_de_Pago metodo_de_pago, Users user, int costo_total) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.metodo_de_pago = metodo_de_pago;
        this.user = user;
        Costo_total = costo_total;
    }

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

    public Metodo_de_Pago getMetodo_de_pago() {
        return metodo_de_pago;
    }

    public void setMetodo_de_pago(Metodo_de_Pago metodo_de_pago) {
        this.metodo_de_pago = metodo_de_pago;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getCosto_total() {
        return Costo_total;
    }

    public void setCosto_total(int costo_total) {
        Costo_total = costo_total;
    }
}
