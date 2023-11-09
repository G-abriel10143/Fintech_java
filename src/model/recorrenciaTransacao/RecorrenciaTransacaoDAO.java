package model.recorrenciaTransacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.DAO;

public class RecorrenciaTransacaoDAO extends DAO<RecorrenciaTransacao> {
	public RecorrenciaTransacaoDAO() {
		super(RecorrenciaTransacao.class);
	}

    public List<RecorrenciaTransacao> listar() {
        return super.getAll("SELECT * FROM RECORRENCIA_TRANSACAO");
    }

    public RecorrenciaTransacao cadastrar(RecorrenciaTransacao recorrenciaTransacao) {
    	Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = super.createConnection();
			
			// TODO ajustar
			statement = connection.prepareStatement(
                "INSERT INTO RECORRENCIA_TRANSACAO " +
                "(ID, CONTA_ID, DATA_CRIACAO, TITULO, TIPO, VALOR, STATUS, DIAS_RECORRENCIA, DATA_INATIVACAO, QUANTIDADE_REPETICAO) " +
                "VALUES " +
                "(SEQ_RECORRENCIA_TRANSACAO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            statement.setLong(1, recorrenciaTransacao.getContaId());
            statement.setDate(
                2,
                recorrenciaTransacao.getDataCriacao() != null ?
                    new Date(recorrenciaTransacao.getDataCriacao().getTime()) :
                    null
            );
            statement.setString(3, recorrenciaTransacao.getTitulo());
            statement.setString(4, recorrenciaTransacao.getTipo());
            statement.setBigDecimal(5, recorrenciaTransacao.getValor());
            statement.setString(6, recorrenciaTransacao.getStatus());
            statement.setInt(7, recorrenciaTransacao.getDiasRecorrencia());
            statement.setDate(
                8,
                recorrenciaTransacao.getDataInativacao() != null ?
                    new Date(recorrenciaTransacao.getDataInativacao().getTime()) :
                    null
            );
            statement.setInt(9, recorrenciaTransacao.getQuantidadeRepeticao());
		
			statement.executeQuery();
			
			return recorrenciaTransacao;
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
