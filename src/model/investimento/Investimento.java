package model.investimento;

import java.math.BigDecimal;
import java.util.Date;

import model.ColumnName;
import model.Entity;
import model.Id;
import model.TableName;

@TableName("investimento")
public class Investimento implements Entity {
    @Id("SEQ_INVESTIMENTO")
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

    @ColumnName("data_resgate")
    private Date dataResgate;

    @ColumnName("valor_resgate")
    private BigDecimal valorResgate;

    @ColumnName("data_inativacao")
    private Date dataInativacao;
    
    public Investimento() {}

	public Investimento(
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
		Date dataResgate,
		BigDecimal valorResgate,
		Date dataInativacao
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
		this.dataResgate = dataResgate;
		this.valorResgate = valorResgate;
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

	public Date getDataResgate() {
		return dataResgate;
	}

	public void setDataResgate(Date dataResgate) {
		this.dataResgate = dataResgate;
	}

	public BigDecimal getValorResgate() {
		return valorResgate;
	}

	public void setValorResgate(BigDecimal valorResgate) {
		this.valorResgate = valorResgate;
	}

	public Date getDataInativacao() {
		return dataInativacao;
	}

	public void setDataInativacao(Date dataInativacao) {
		this.dataInativacao = dataInativacao;
	}
}
