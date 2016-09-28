package br.com.agentemaps.model;
// Generated 26/09/2016 16:25:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * AbastecimentoAgua generated by hbm2java
 */
@Entity
@Table(name = "abastecimento_agua", catalog = "agentemaps")
public class AbastecimentoAgua implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5264682831133913668L;
	private int familiaId;
	private Familia familia;
	private int redeGeral;
	private int pocoNascente;
	private byte outros;

	public AbastecimentoAgua() {
	}

	public AbastecimentoAgua(Familia familia, int redeGeral, int pocoNascente, byte outros) {
		this.familia = familia;
		this.redeGeral = redeGeral;
		this.pocoNascente = pocoNascente;
		this.outros = outros;
	}

	@GenericGenerator(name = "fk_abastecimento_agua_familia", strategy = "foreign", parameters = @Parameter(name = "property", value = "familia"))
	@Id
	@GeneratedValue(generator = "fk_abastecimento_agua_familia")

	@Column(name = "familia_id", unique = true, nullable = false)
	public int getFamiliaId() {
		return this.familiaId;
	}

	public void setFamiliaId(int familiaId) {
		this.familiaId = familiaId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Familia getFamilia() {
		return this.familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Column(name = "rede_geral", nullable = false)
	public int getRedeGeral() {
		return this.redeGeral;
	}

	public void setRedeGeral(int redeGeral) {
		this.redeGeral = redeGeral;
	}

	@Column(name = "poco_nascente", nullable = false)
	public int getPocoNascente() {
		return this.pocoNascente;
	}

	public void setPocoNascente(int pocoNascente) {
		this.pocoNascente = pocoNascente;
	}

	@Column(name = "outros", nullable = false)
	public byte getOutros() {
		return this.outros;
	}

	public void setOutros(byte outros) {
		this.outros = outros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result + familiaId;
		result = prime * result + outros;
		result = prime * result + pocoNascente;
		result = prime * result + redeGeral;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbastecimentoAgua other = (AbastecimentoAgua) obj;
		if (familia == null) {
			if (other.familia != null)
				return false;
		} else if (!familia.equals(other.familia))
			return false;
		if (familiaId != other.familiaId)
			return false;
		if (outros != other.outros)
			return false;
		if (pocoNascente != other.pocoNascente)
			return false;
		if (redeGeral != other.redeGeral)
			return false;
		return true;
	}

	
}