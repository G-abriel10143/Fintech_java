package model.endereco;

import model.ColumnName;
import model.Entity;
import model.Id;
import model.TableName;

@TableName("endereco")
public class Endereco implements Entity {
    @Id("SEQ_ENDERECO")
    @ColumnName("id")
    private Long id;

    @ColumnName("logradouro")
    private String logradouro;

    @ColumnName("numero")
    private Integer numero;

    @ColumnName("bairro")
    private String bairro;

    @ColumnName("cidade")
    private String cidade;

    @ColumnName("estado")
    private String estado;

    @ColumnName("cep")
    private Integer cep;

    @ColumnName("complemento")
    private String complemento;

    @ColumnName("ponto_referencia")
    private String pontoReferencia;

    public Endereco() {}

	public Endereco(
		Long id,
		String logradouro,
		Integer numero,
		String bairro,
		String cidade,
		String estado,
		Integer cep,
		String complemento,
		String pontoReferencia
	) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complemento = complemento;
		this.pontoReferencia = pontoReferencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
}
