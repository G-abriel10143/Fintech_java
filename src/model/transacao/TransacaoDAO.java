package model.transacao;

import model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransacaoDAO extends DAO<Transacao> {

    public TransacaoDAO() {
        super(Transacao.class);
    }

    public List<Transacao> listar() {
        return super.getAll("SELECT * FROM TRANSACAO");
    }

    public Transacao cadastrar(Transacao transacao) {
    	Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = super.createConnection();
			
			statement = connection.prepareStatement(
                "INSERT INTO TRANSACAO " +
                "(ID, CONTA_ID, DATA_CRIACAO, TITULO, TIPO, VALOR, TRANSACAO_ESTORNADA_ID, DATA_INATIVACAO) " +
                "VALUES " +
                "(SEQ_TRANSACAO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)"
            );

            statement.setLong(1, transacao.getContaId());
            statement.setDate(
                2,
                transacao.getDataCriacao() != null ?
                    new Date(transacao.getDataCriacao().getTime()) :
                    null
            );
            statement.setString(3, transacao.getTitulo());
            statement.setString(4, transacao.getTipo());
            statement.setBigDecimal(5, transacao.getValor());
            statement.setLong(6, transacao.getTransacaoEstornadaId());
            statement.setDate(
                7,
                transacao.getDataInativacao() != null ?
                    new Date(transacao.getDataInativacao().getTime()) :
                    null
            );
		
			statement.executeQuery();
			
			return transacao;
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