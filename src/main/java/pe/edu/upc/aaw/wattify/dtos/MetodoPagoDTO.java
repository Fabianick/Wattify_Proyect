package pe.edu.upc.aaw.wattify.dtos;

public class MetodoPagoDTO {
    private int id_MetodoPago;
    private String tipo_de_pago;
    private String titular;

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
