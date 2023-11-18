package pe.edu.upc.aaw.wattify.dtos;

public class ConsumoHorasDispositivoDTO {
    private String nombre_tipo_dispositivo;
    private int sum ;

    public String getNombre_tipo_dispositivo() {
        return nombre_tipo_dispositivo;
    }

    public void setNombre_tipo_dispositivo(String nombre_tipo_dispositivo) {
        this.nombre_tipo_dispositivo = nombre_tipo_dispositivo;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
