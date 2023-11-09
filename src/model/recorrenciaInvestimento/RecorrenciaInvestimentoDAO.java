package model.recorrenciaInvestimento;

import model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RecorrenciaInvestimentoDAO extends DAO<RecorrenciaInvestimento> {

    public RecorrenciaInvestimentoDAO() {
        super(RecorrenciaInvestimento.class);
    }

    public List<RecorrenciaInvestimento> listar(){
        return super.getAll("SELECT * FROM RECORRENCIA_INVESTIMENTO");
    }

    public RecorrenciaInvestimento cadastrar(RecorrenciaInvestimento recorrenciaInvestimento) {
    	Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = super.createConnection();
			
			statement = connection.prepareStatement(
				"INSERT INTO recorrencia_investimento " +
				"(ID, CONTA_ID, DATA_CRIACAO, NOME_TITULO, TIPO, VALOR_APLICACAO, RENDIMENTO_ANUAL, DATA_VENCIMENTO, EMISSOR_TITULO, CORRETORA, DATA_INATIVACAO, DIAS_RECORRENCIA, STATUS, QUANTIDADE_REPETICAO) " +
				"VALUES " +
				"(SEQ_RECORRENCIA_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
			);
			
			// TODO inserir SETs
		
			statement.setLong(1, recorrenciaInvestimento.getContaId());
			statement.setDate(
				2,
				recorrenciaInvestimento.getDataCriacao() != null ?
					new Date(recorrenciaInvestimento.getDataCriacao().getTime()) :
					null
			);
			statement.setString(3, recorrenciaInvestimento.getNomeTitulo());
			statement.setString(4, recorrenciaInvestimento.getTipo());
			statement.setBigDecimal(5, recorrenciaInvestimento.getValorAplicacao());
			statement.setBigDecimal(6, recorrenciaInvestimento.getRendimentoAnual());
			statement.setDate(
				7,
				recorrenciaInvestimento.getDataVencimento() != null ?
					new Date(recorrenciaInvestimento.getDataVencimento().getTime()) :
					null
			);
			statement.setString(8, recorrenciaInvestimento.getEmissorTitulo());
			statement.setString(9, recorrenciaInvestimento.getCorretora());
			statement.setDate(
				10,
				recorrenciaInvestimento.getDataInativacao() != null ?
					new Date(recorrenciaInvestimento.getDataInativacao().getTime()) :
					null
			);
			statement.setInt(11, recorrenciaInvestimento.getDiasRecorrencia());
			statement.setString(12, recorrenciaInvestimento.getStatus());
			statement.setLong(13, recorrenciaInvestimento.getQuantidadeRepeticao());
		
			statement.executeQuery();
			
			return recorrenciaInvestimento;
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