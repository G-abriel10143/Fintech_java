package model.recorrenciaInvestimento;

import java.math.BigDecimal;
import java.util.Date;

import model.ColumnName;
import model.Entity;
import model.Id;
import model.TableName;

@TableName("RECORRENCIA_INVESTIMENTO")
public class RecorrenciaInvestimento implements Entity {
    @Id("seq_recorrencia_insvestimento")
    @ColumnName("id")
    private Long id;

    @ColumnName("conta_id")
    private Long contaId;

    @ColumnName("data_criacao")
    private Date dataCriacao;
    
    @ColumnName("nome_titulo")
    private String nomeTitulo;

    @ColumnName("tipo")
    private String tipo;

    @ColumnName("valor_aplicacao")
    private BigDecimal valorAplicacao;

    @ColumnName("rendimento_anual")
    private BigDecimal rendimentoAnual;

    @ColumnName("data_vencimento")
    private Date dataVencimento;

    @ColumnName("emissor_titulo")
    private String emissorTitulo;

    @ColumnName("corretora")
    private String corretora;
    
    @ColumnName("data_inativacao")
    private Date dataInativacao;

    @ColumnName("dias_recorrencia")
    private Integer diasRecorrencia;

    @ColumnName("status")
    private String status;

    @ColumnName("quantidade_repeticao")
    private Long quantidadeRepeticao;

    public RecorrenciaInvestimento() {}

	public RecorrenciaInvestimento(
		Long id,
		Long contaId,
		Date dataCriacao,
		String nomeTitulo,
		String tipo,
		BigDecimal valorAplicacao,
		BigDecimal rendimentoAnual,
		Date dataVencimento,
		String emissorTitulo,
		String corretora,
		Date dataInativacao,
		Integer diasRecorrencia,
		String status,
		Long quantidadeRepeticao
	) {
		this.id = id;
		this.contaId = contaId;
		this.dataCriacao = dataCriacao;
		this.nomeTitulo = nomeTitulo;
		this.tipo = tipo;
		this.valorAplicacao = valorAplicacao;
		this.rendimentoAnual = rendimentoAnual;
		this.dataVencimento = dataVencimento;
		this.emissorTitulo = emissorTitulo;
		this.corretora = corretora;
		this.dataInativacao = dataInativacao;
		this.diasRecorrencia = diasRecorrencia;
		this.status = status;
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

	public String getNomeTitulo() {
		return nomeTitulo;
	}

	public void setNomeTitulo(String nomeTitulo) {
		this.nomeTitulo = nomeTitulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValorAplicacao() {
		return valorAplicacao;
	}

	public void setValorAplicacao(BigDecimal valorAplicacao) {
		this.valorAplicacao = valorAplicacao;
	}

	public BigDecimal getRendimentoAnual() {
		return rendimentoAnual;
	}

	public void setRendimentoAnual(BigDecimal rendimentoAnual) {
		this.rendimentoAnual = rendimentoAnual;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getEmissorTitulo() {
		return emissorTitulo;
	}

	public void setEmissorTitulo(String emissorTitulo) {
		this.emissorTitulo = emissorTitulo;
	}

	public String getCorretora() {
		return corretora;
	}

	public void setCorretora(String corretora) {
		this.corretora = corretora;
	}

	public Date getDataInativacao() {
		return dataInativacao;
	}

	public void setDataInativacao(Date dataInativacao) {
		this.dataInativacao = dataInativacao;
	}

	public Integer getDiasRecorrencia() {
		return diasRecorrencia;
	}

	public void setDiasRecorrencia(Integer diasRecorrencia) {
		this.diasRecorrencia = diasRecorrencia;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getQuantidadeRepeticao() {
		return quantidadeRepeticao;
	}

	public void setQuantidadeRepeticao(Long quantidadeRepeticao) {
		this.quantidadeRepeticao = quantidadeRepeticao;
	}
}