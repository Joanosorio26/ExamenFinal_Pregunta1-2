package pe.edu.cibertec.EF_APP_Osorio_Joan_P1_2.service;

import org.springframework.stereotype.Service;


@Service
public class PedidoService {
    public String procesarPedido() {
        boolean hayStock = Math.random() > 0.5; // Simula la disponibilidad de stock

        if (!hayStock) {
            throw new RuntimeException("No hay suficiente stock para procesar el pedido.");
        }
        return "Pedido procesado correctamente.";
    }
}
