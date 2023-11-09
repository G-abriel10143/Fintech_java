package model.transacao;

import java.math.BigDecimal;
import java.util.Date;

import model.ColumnName;
import model.Entity;
import model.Id;
import model.TableName;

@TableName("transacao")
public class Transacao implements Entity {
	@Id("SEQ_TRANSACAO")
	@ColumnName("id")
	private Long id;

	@ColumnName("conta_id")
	private Long contaId;

	@ColumnName("data_criacao")
	private Date dataCriacao;

	@ColumnName("titulo")
	private String titulo;

	@ColumnName("tipo")
	private String tipo;

	@ColumnName("valor")
	private BigDecimal valor;
	
	@ColumnName("transacao_estornada_id")
	private Long transacaoEstornadaId;

	@ColumnName("data_inativacao")
	private Date dataInativacao;
	
	public Transacao() {}

	public Transacao(
		Long id,
		Long contaId,
		Date dataCriacao,
		String titulo,
		String tipo,
		BigDecimal valor,
		Long transacaoEstornadaId,
		Date dataInativacao
	) {
		this.id = id;
		this.contaId = contaId;
		this.dataCriacao = dataCriacao;
		this.titulo = titulo;
		this.tipo = tipo;
		this.valor = valor;
		this.transacaoEstornadaId = transacaoEstornadaId;
		this.dataInativacao = dataInativacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getTransacaoEstornadaId() {
		return transacaoEstornadaId;
	}

	public void setTransacaoEstornadaId(Long transacaoEstornadaId) {
		this.transacaoEstornadaId = transacaoEstornadaId;
	}

	public Date getDataInativacao() {
		return dataInativacao;
	}

	public void setDataInativacao(Date dataInativacao) {
		this.dataInativacao = dataInativacao;
	}
}
