package model.recorrenciaTransacao;

import java.math.BigDecimal;
import java.util.Date;

import model.ColumnName;
import model.Entity;
import model.Id;
import model.TableName;

@TableName("recorrencia_transacao")
public class RecorrenciaTransacao implements Entity {
	@Id("SEQ_RECORRENCIA_TRANSACAO")
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
    
    @ColumnName("status")
    private String status;

    @ColumnName("dias_recorrencia")
    private Integer diasRecorrencia;

    @ColumnName("data_inativacao")
    private Date dataInativacao;

    @ColumnName("quantidade_repeticao")
    private Integer quantidadeRepeticao;
    
    public RecorrenciaTransacao() {}

	public RecorrenciaTransacao(
		Long id,
		Long contaId,
		Date dataCriacao,
		String titulo,
		String tipo,
		BigDecimal valor,
		String status,
		Integer diasRecorrencia,
		Date dataInativacao,
		Integer quantidadeRepeticao
	) {
		this.id = id;
		this.contaId = contaId;
		this.dataCriacao = dataCriacao;
		this.titulo = titulo;
		this.tipo = tipo;
		this.valor = valor;
		this.status = status;
		this.diasRecorrencia = diasRecorrencia;
		this.dataInativacao = dataInativacao;
		this.quantidadeRepeticao = quantidadeRepeticao;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDiasRecorrencia() {
		return diasRecorrencia;
	}

	public void setDiasRecorrencia(Integer diasRecorrencia) {
		this.diasRecorrencia = diasRecorrencia;
	}

	public Date getDataInativacao() {
		return dataInativacao;
	}

	public void setDataInativacao(Date dataInativacao) {
		this.dataInativacao = dataInativacao;
	}

	public Integer getQuantidadeRepeticao() {
		return quantidadeRepeticao;
	}

	public void setQuantidadeRepeticao(Integer quantidadeRepeticao) {
		this.quantidadeRepeticao = quantidadeRepeticao;
	}
}
