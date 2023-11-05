package pe.edu.upc.aaw.wattify.dtos;

public class MetodoPagoDTO {
    private int id;
    private String Tipo_de_pago;
    private String Titular;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_de_pago() {
        return Tipo_de_pago;
    }

    public void setTipo_de_pago(String tipo_de_pago) {
        Tipo_de_pago = tipo_de_pago;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String titular) {
        Titular = titular;
    }
}
