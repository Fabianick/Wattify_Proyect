package pe.edu.upc.aaw.wattify.entities;
import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Metodo_de_Pago")
public class Metodo_de_Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_MetodoPago;

    @Column(name = "tipo_de_pago", length = 50, nullable = false)
    private String tipo_de_pago;

    @Column(name = "titular", length = 50, nullable = false)
    private String titular;

    public Metodo_de_Pago() {
    }

    public Metodo_de_Pago(int id_MetodoPago, String tipo_de_pago, String titular) {
        this.id_MetodoPago = id_MetodoPago;
        this.tipo_de_pago = tipo_de_pago;
        this.titular = titular;
    }

    public int getId_MetodoPago() {
        return id_MetodoPago;
    }

    public void setId_MetodoPago(int id_MetodoPago) {
        this.id_MetodoPago = id_MetodoPago;
    }

    public String getTipo_de_pago() {
        return tipo_de_pago;
    }

    public void setTipo_de_pago(String tipo_de_pago) {
        this.tipo_de_pago = tipo_de_pago;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
