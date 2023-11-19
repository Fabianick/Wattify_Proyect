package pe.edu.upc.aaw.wattify.dtos;

import pe.edu.upc.aaw.wattify.entities.Comprobante_pago;
import pe.edu.upc.aaw.wattify.entities.Membresia;

public class DetallePagoDTO {
    private int id;
    private int consumo_dispositivo;
    private int cantidad_dispositivo;
    private int costo_dispositivo;
    private int sub_total_pago;
    private ComprobantePagoDTO comprobante_pago;
    private MembresiaDTO membresia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ComprobantePagoDTO getComprobante_pago() {
        return comprobante_pago;
    }

    public void setComprobante_pago(ComprobantePagoDTO comprobante_pago) {
        this.comprobante_pago = comprobante_pago;
    }

    public MembresiaDTO getMembresia() {
        return membresia;
    }

    public void setMembresia(MembresiaDTO membresia) {
        this.membresia = membresia;
    }
}
