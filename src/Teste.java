

import java.math.BigDecimal;
import java.util.Date;

import model.conta.Conta;
import model.conta.ContaDAO;
import model.endereco.Endereco;
import model.endereco.EnderecoDAO;
import model.investimento.Investimento;
import model.investimento.InvestimentoDAO;
import model.recorrenciaInvestimento.RecorrenciaInvestimento;
import model.recorrenciaInvestimento.RecorrenciaInvestimentoDAO;
import model.recorrenciaTransacao.RecorrenciaTransacao;
import model.recorrenciaTransacao.RecorrenciaTransacaoDAO;
import model.transacao.Transacao;
import model.transacao.TransacaoDAO;

public class Teste {

	public static void main(String[] args) {
		cadastrarEListarConta();
		cadastrarEListarEndereco();
		cadastrarEListarInvestimento();
		cadastrarEListarTransacao();
		cadastrarEListarRecorrenciaTransacao();
		cadastrarEListarRecorrenciaInvestimento();
	}
	
	private static void cadastrarEListarConta() {
		final ContaDAO contaDAO = new ContaDAO();
		
		contaDAO.cadastrarConta(
			new Conta(
				null,
				1L,
				15,
				55,
				new BigDecimal(5),
				"Senha",
				"Senha cartão",
				new Date(),
				new Date()
			)
		);
		
		contaDAO.listar();
	}
	
	public static void cadastrarEListarEndereco() {
		final EnderecoDAO enderecoDAO = new EnderecoDAO();

		enderecoDAO.cadastrar(
			new Endereco(
				null,
				"Logradouro",
				4,
				"Bairro",
				"Cidade",
				"Estado",
				55,
				"Complemento",
				"Ponto de referência"
			)
		);
		
		enderecoDAO.listar();
	}
	
	public static void cadastrarEListarInvestimento() {
		final InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		
		investimentoDAO.cadastrar(
			new Investimento(
				null,
				1L,
				new Date(),
				"Nome do título",
				"Tipo",
				new BigDecimal(49),
				new BigDecimal(49),
				new Date(),
				"Emissor do título",
				"Corretora",
				new Date(),
				new BigDecimal(49),
				new Date()
			)
		);
		
		investimentoDAO.listar();
	}
	
	public static void cadastrarEListarTransacao() {
		final TransacaoDAO transacaoDAO = new TransacaoDAO();
		
		transacaoDAO.cadastrar(
			new Transacao(
				null,
				1L,
				new Date(),
				"Título",
				"Tipo",
				new BigDecimal(46),
				1L,
				new Date()
			)
		);
		
		transacaoDAO.listar();
	}
	
	public static void cadastrarEListarRecorrenciaTransacao() {
		final RecorrenciaTransacaoDAO recorrenciaTransacaoDAO = new RecorrenciaTransacaoDAO();
		
		recorrenciaTransacaoDAO.cadastrar(
			new RecorrenciaTransacao(
				null,
				1L,
				new Date(),
				"Título",
				"Tipo",
				new BigDecimal(36),
				"Status",
				13,
				new Date(),
				99
			)
		);
		
		recorrenciaTransacaoDAO.listar();
	}
	
	public static void cadastrarEListarRecorrenciaInvestimento() {
		final RecorrenciaInvestimentoDAO recorrenciaInvestimentoDAO = new RecorrenciaInvestimentoDAO();
		
		recorrenciaInvestimentoDAO.cadastrar(
			new RecorrenciaInvestimento(
				null,
				1L,
				new Date(),
				"Nome do título",
				"Tipo",
				new BigDecimal(414.15),
				new BigDecimal(414.15),
				new Date(),
				"Emissor do título",
				"Corretora",
				new Date(),
				15,
				"Status",
				12L
			)
		);
		
		recorrenciaInvestimentoDAO.listar();
	}

}
