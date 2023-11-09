package model.transacao;

public class TransacaoDAOFactory {

    public static TransacaoDAO createTransacaoDAO() {
        return new TransacaoDAO();
    }
}
