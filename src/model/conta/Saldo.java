package model.conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    // Endpoint para obter o saldo com base no USUARIO_ID
    @GetMapping("/{usuarioId}/saldo")
    public double getSaldo(@PathVariable Long usuarioId) {
        // Recupera a conta do banco de dados
        Conta conta = contaRepository.findByUsuarioId(usuarioId);

        if (conta != null) {
            return conta.getSaldo();
        } else {
            // Pode lançar uma exceção ou retornar um código de erro, dependendo do caso
            throw new RuntimeException("Conta não encontrada para o usuário ID: " + usuarioId);
        }
    }
}
