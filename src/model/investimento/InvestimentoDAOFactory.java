package model.investimento;

public class InvestimentoDAOFactory {

    public static InvestimentoDAO createInvestimentoDAO() {
        return new InvestimentoDAO();
    }
}
