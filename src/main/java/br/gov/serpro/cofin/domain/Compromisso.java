package br.gov.serpro.cofin.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compromisso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*
	 *  If you are using Glassfish then remove the strategy attribute
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;
	
	@Column
	private String nomeCompromisso;
	
	@Column
	@Temporal(value=TemporalType.DATE)
	private Date dataVencimento;
	
	@Column
	@Temporal(value=TemporalType.DATE)
	private Date dataPagamento;
	
	@Column
	private BigDecimal valorCompromisso;
	
	@Column
	private BigDecimal valorPago;

	public Compromisso() {
		super();
	}

	public Compromisso(String nomeCompromisso, Date dataVencimento,
			Date dataPagamento, BigDecimal valorCompromisso,
			BigDecimal valorPago) {
		super();
		this.nomeCompromisso = nomeCompromisso;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valorCompromisso = valorCompromisso;
		this.valorPago = valorPago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompromisso() {
		return nomeCompromisso;
	}

	public void setNomeCompromisso(String nomeCompromisso) {
		this.nomeCompromisso = nomeCompromisso;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorCompromisso() {
		return valorCompromisso;
	}

	public void setValorCompromisso(BigDecimal valorCompromisso) {
		this.valorCompromisso = valorCompromisso;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	
	public boolean isAtrasado() {
		boolean retorno = true;
		
		Date venc = getDataVencimento();
		Date atual = new Date();
		if (venc.after(atual)) {
			retorno = false;
		}
		
		return retorno;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compromisso other = (Compromisso) obj;
		if (nomeCompromisso == null) {
			if (other.nomeCompromisso != null)
				return false;
		} else if (!nomeCompromisso.equals(other.nomeCompromisso))
			return false;
		return true;
	}



}
