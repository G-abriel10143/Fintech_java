package model.investimento;

import model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InvestimentoDAO extends DAO<Investimento> {

    public InvestimentoDAO() {
        super(Investimento.class);
    }

    public List<Investimento> listar(){
        return super.getAll("SELECT * FROM INVESTIMENTO");
    }

    public Investimento cadastrar(Investimento investimento) {
    	Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = super.createConnection();
			
			// TODO ajustar
			statement = connection.prepareStatement(
				"INSERT INTO INVESTIMENTO " +
				"(ID, CONTA_ID, DATA_CRIACAO, NOME_TITULO, TIPO, VALOR_APLICACAO, RENDIMENTO_ANUAL, DATA_VENCIMENTO, EMISSOR_TITULO, CORRETORA, DATA_RESGATE, VALOR_RESGATE, DATA_INATIVACAO) " +
				"VALUES " +
				"(SEQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
			);
			
			// TODO inserir SETs
			statement.setLong(1, investimento.getContaId());
			statement.setDate(
                2,
                investimento.getDataCriacao() != null ?
                    new Date(investimento.getDataCriacao().getTime()) :
                    null
            );
			statement.setString(3, investimento.getNomeTitulo());
			statement.setString(4, investimento.getTipo());
			statement.setBigDecimal(5, investimento.getValorAplicacao());
			statement.setBigDecimal(6, investimento.getRendimentoAnual());
			statement.setDate(
                7,
                investimento.getDataVencimento() != null ?
                    new Date(investimento.getDataVencimento().getTime()) :
                    null
            );
			statement.setString(8, investimento.getEmissorTitulo());
			statement.setString(9, investimento.getCorretora());
			statement.setDate(
                10,
                investimento.getDataResgate() != null ?
                    new Date(investimento.getDataResgate().getTime()) :
                    null
            );
			statement.setBigDecimal(11, investimento.getValorResgate());
			statement.setDate(
                12,
                investimento.getDataInativacao() != null ?
                    new Date(investimento.getDataInativacao().getTime()) :
                    null
            );
		
			statement.executeQuery();
			
			return investimento;
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