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

    @ManyToOne
    @JoinColumn(name = "idComprobante_pago")
    private Comprobante_pago comprobante_pago;

    @Column(name = "Consumo_dispositivo", length = 50, nullable = false)
    private int Consumo_dispositivo;

    @Column(name = "Cantidad_dispositivo", length = 50, nullable = false)
    private int Cantidad_dispositivo;

    @Column(name = "Costo_dispositivo", length = 50, nullable = false)
    private int Costo_dispositivo;

    @Column(name = "Sub_total_pago", length = 50, nullable = false)
    private int Sub_total_pago;

    @ManyToOne
    @JoinColumn(name = "idMembresia")
    private Membresia membresia;

    public Detalle_pago() {
    }

    public Detalle_pago(int id, Comprobante_pago comprobante_pago, int consumo_dispositivo, int cantidad_dispositivo, int costo_dispositivo, int sub_total_pago, Membresia membresia) {
        this.id = id;
        this.comprobante_pago = comprobante_pago;
        Consumo_dispositivo = consumo_dispositivo;
        Cantidad_dispositivo = cantidad_dispositivo;
        Costo_dispositivo = costo_dispositivo;
        Sub_total_pago = sub_total_pago;
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
        return Consumo_dispositivo;
    }

    public void setConsumo_dispositivo(int consumo_dispositivo) {
        Consumo_dispositivo = consumo_dispositivo;
    }

    public int getCantidad_dispositivo() {
        return Cantidad_dispositivo;
    }

    public void setCantidad_dispositivo(int cantidad_dispositivo) {
        Cantidad_dispositivo = cantidad_dispositivo;
    }

    public int getCosto_dispositivo() {
        return Costo_dispositivo;
    }

    public void setCosto_dispositivo(int costo_dispositivo) {
        Costo_dispositivo = costo_dispositivo;
    }

    public int getSub_total_pago() {
        return Sub_total_pago;
    }

    public void setSub_total_pago(int sub_total_pago) {
        Sub_total_pago = sub_total_pago;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
}
