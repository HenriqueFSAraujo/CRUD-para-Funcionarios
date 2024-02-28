package br.gov.prodemge.proddigio.meucurso.entidades.cidade;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "TB_CIDADE")
public class CidadeVO extends MeucursoBaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870954401831508693L;
	private String nome;
	private String apelido;
	private EstadoSimplesVO estado;

	@Override
	@Id
	@SequenceGenerator(name = "sq_cidade", sequenceName = "sq_cidade", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cidade")
	public Long getId() {
		return super.getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public EstadoSimplesVO getEstado() {
		return estado;
	}

	public void setEstado(EstadoSimplesVO estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		if (getNome() == null)
			setNome("");
		return getNome();
	}

}
