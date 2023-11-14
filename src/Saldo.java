import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    // Simulação de um banco de dados simples
    private Map<String, Account> accounts = new HashMap<>();

    // Endpoint para obter o saldo
    @GetMapping("/{accountId}/balance")
    public double getBalance(@PathVariable String accountId) {
        // Recupera a conta do banco de dados (simulado)
        Account account = accounts.get(accountId);

        if (account != null) {
            return account.getBalance();
        } else {
            // Pode lançar uma exceção ou retornar um código de erro, dependendo do caso
            throw new RuntimeException("Conta não encontrada");
        }
    }
}
public class Saldo {
    
}
