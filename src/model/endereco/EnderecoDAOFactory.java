package model.endereco;

public class EnderecoDAOFactory {

    public static EnderecoDAO createEnderecoDAO() {
        return new EnderecoDAO();
    }
}
