package pe.edu.cibertec.EF_APP_Osorio_Joan_P1_2.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.EF_APP_Osorio_Joan_P1_2.service.PedidoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @GetMapping
    @CircuitBreaker(name = "pedidoService", fallbackMethod = "handleFallback")
    public String crearPedido() {
        return pedidoService.procesarPedido();
    }

    public String handleFallback(Throwable throwable) {
        return "El servicio no está disponible. Intenta de nuevo más tarde.";
    }
}