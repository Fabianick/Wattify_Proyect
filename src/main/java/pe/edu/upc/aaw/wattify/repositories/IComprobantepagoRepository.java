package pe.edu.upc.aaw.wattify.repositories;

import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.wattify.entities.Comprobante_pago;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IComprobantepagoRepository extends JpaRepository<Comprobante_pago, Integer> {
    @Query(value = "select mp.tipo_de_pago, sum(cp.costo_total) from metodo_de_pago mp join comprobante_pago cp \n" +
            " on mp.id_metodo_pago = cp.id_metodo_de_pago\n" +
            " group by mp.tipo_de_pago",nativeQuery = true)
    public List<String[]> SumaTotalXMetodoPago();
}
