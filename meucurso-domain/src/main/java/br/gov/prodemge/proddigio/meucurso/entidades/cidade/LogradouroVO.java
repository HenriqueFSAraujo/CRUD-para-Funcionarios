package br.gov.prodemge.proddigio.meucurso.entidades.cidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.prodemge.proddigio.meucurso.entidades.MeucursoBaseVO;
import br.gov.prodigio.comuns.anotacoes.Lookup;

@Lookup
@Entity
@Table(name = "TB_LOGRADOURO")
public class LogradouroVO extends MeucursoBaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870954401831508693L;
	private String nome;
	private String cep;
	private BairroVO bairro;

	@Override
	@Id
	@SequenceGenerator(name = "sq_logradouro", sequenceName = "sq_logradouro", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_logradouro")
	public Long getId() {
		return super.getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		if (getNome() == null)
			setNome("");
		return getNome();
	}

	@ManyToOne
	public BairroVO getBairro() {
		return bairro;
	}

	public void setBairro(BairroVO bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}