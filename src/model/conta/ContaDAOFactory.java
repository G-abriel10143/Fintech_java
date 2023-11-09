package model.conta;

public class ContaDAOFactory {

    public static ContaDAO createContaDAO() {
        return new ContaDAO();
    }
}
