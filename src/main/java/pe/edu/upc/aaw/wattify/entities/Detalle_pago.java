package pe.edu.upc.aaw.wattify.entities;
import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Detalle_pago")
public class Detalle_pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "consumo_dispositivo", length = 50, nullable = false)
    private int consumo_dispositivo;

    @Column(name = "cantidad_dispositivo", length = 50, nullable = false)
    private int cantidad_dispositivo;

    @Column(name = "costo_dispositivo", length = 50, nullable = false)
    private int costo_dispositivo;

    @Column(name = "sub_total_pago", length = 50, nullable = false)
    private int sub_total_pago;

    @ManyToOne
    @JoinColumn(name = "comprobante_pago")
    private Comprobante_pago comprobante_pago;

    @ManyToOne
    @JoinColumn(name = "membresia")
    private Membresia membresia;

    public Detalle_pago() {
    }

    public Detalle_pago(int id, Comprobante_pago comprobante_pago, int consumo_dispositivo, int cantidad_dispositivo, int costo_dispositivo, int sub_total_pago, Membresia membresia) {
        this.id = id;
        this.comprobante_pago = comprobante_pago;
        this.consumo_dispositivo = consumo_dispositivo;
        this.cantidad_dispositivo = cantidad_dispositivo;
        this.costo_dispositivo = costo_dispositivo;
        this.sub_total_pago = sub_total_pago;
        this.membresia = membresia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comprobante_pago getComprobante_pago() {
        return comprobante_pago;
    }

    public void setComprobante_pago(Comprobante_pago comprobante_pago) {
        this.comprobante_pago = comprobante_pago;
    }

    public int getConsumo_dispositivo() {
        return consumo_dispositivo;
    }

    public void setConsumo_dispositivo(int consumo_dispositivo) {
        this.consumo_dispositivo = consumo_dispositivo;
    }

    public int getCantidad_dispositivo() {
        return cantidad_dispositivo;
    }

    public void setCantidad_dispositivo(int cantidad_dispositivo) {
        this.cantidad_dispositivo = cantidad_dispositivo;
    }

    public int getCosto_dispositivo() {
        return costo_dispositivo;
    }

    public void setCosto_dispositivo(int costo_dispositivo) {
        this.costo_dispositivo = costo_dispositivo;
    }

    public int getSub_total_pago() {
        return sub_total_pago;
    }

    public void setSub_total_pago(int sub_total_pago) {
        this.sub_total_pago = sub_total_pago;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
}
