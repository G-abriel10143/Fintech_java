package model.conta;

import java.math.BigDecimal;
import java.util.Date;

import model.Entity;
import model.TableName;
import model.Id;
import model.ColumnName;

@TableName("conta")
public class Conta implements Entity {
    @Id("SEQ_CONTA")
    @ColumnName("id")
    private Long id;

    @ColumnName("usuario_id")
    private Long usuarioId;

    @ColumnName("numero")
    private Integer numero;

    @ColumnName("agencia")
    private Integer agencia;

    @ColumnName("saldo")
    private BigDecimal saldo;

    @ColumnName("senha_conta")
    private String senhaConta;

    @ColumnName("senha_cartao")
    private String senhaCartao;
    
    @ColumnName("data_criacao")
    private Date dataCriacao;

    @ColumnName("data_inativacao")
    private Date dataInativacao;

    public Conta() {}

    public Conta(
		Long id,
		Long usuarioId,
		Integer numero,
		Integer agencia,
		BigDecimal saldo,
		String senhaConta,
		String senhaCartao,
		Date dataCriacao,
		Date dataInativacao
	) {
		this.id = id;
		this.usuarioId = usuarioId;
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.senhaConta = senhaConta;
		this.senhaCartao = senhaCartao;
		this.dataCriacao = dataCriacao;
		this.dataInativacao = dataInativacao;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getSenhaConta() {
        return senhaConta;
    }

    public void setSenhaConta(String senhaConta) {
        this.senhaConta = senhaConta;
    }

    public String getSenhaCartao() {
        return senhaCartao;
    }

    public void setSenhaCartao(String senhaCartao) {
        this.senhaCartao = senhaCartao;
    }

    public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }
}
