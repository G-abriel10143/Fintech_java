package model.endereco;

import model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EnderecoDAO extends DAO<Endereco> {

    public EnderecoDAO() {
        super(Endereco.class);
    }

    public List<Endereco> listar() {
        return super.getAll("SELECT * FROM ENDERECO");
    }

    public Endereco cadastrar(Endereco endereco) {
    	Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = super.createConnection();
			
			statement = connection.prepareStatement(
				"INSERT INTO ENDERECO " +
				"(ID, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, CEP, COMPLEMENTO, PONTO_REFERENCIA) " +
				"VALUES " +
				"(SEQ_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)"
			);
			
			statement.setString(1, endereco.getLogradouro());
			statement.setInt(2, endereco.getNumero());
			statement.setString(3, endereco.getBairro());
			statement.setString(4, endereco.getCidade());
			statement.setString(5, endereco.getEstado());
			statement.setInt(6, (int) endereco.getCep());
			statement.setString(7, endereco.getComplemento());
			statement.setString(8, endereco.getPontoReferencia());
		
			statement.executeQuery();
			
			return null;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
    }
}
