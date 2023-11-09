package model.conta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DAO;
import java.util.List;

public class ContaDAO extends DAO<Conta> {

    public ContaDAO() {
        super(Conta.class);
    }

    public List<Conta> listar() {
        return super.getAll("SELECT * FROM CONTA");
    }

    public Conta cadastrarConta(Conta conta) {
    	Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = super.createConnection();
			
			statement = connection.prepareStatement(
				"INSERT INTO CONTA " +
				"(ID, USUARIO_ID, NUMERO, AGENCIA, SALDO, SENHA_CARTAO, SENHA_CONTA, DATA_CRIACAO, DATA_INATIVACAO) " +
				"VALUES " +
				"(SEQ_CONTA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)"
			);
			
			statement.setLong(1, conta.getUsuarioId());
			statement.setInt(2, conta.getNumero());
			statement.setInt(3, conta.getAgencia());
			statement.setBigDecimal(4, conta.getSaldo());
			statement.setString(5, conta.getSenhaCartao());
			statement.setString(6, conta.getSenhaConta());
			statement.setDate(
				7,
				conta.getDataCriacao() != null ?
					new Date(conta.getDataCriacao().getTime()) :
					null
			);
			statement.setDate(
				8,
				conta.getDataInativacao() != null ?
					new Date(conta.getDataInativacao().getTime()) :
					null
			);
		
			statement.executeQuery();
			
			return conta;
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



