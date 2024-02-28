package br.gov.prodemge.proddigio.meucurso.entidades.cidade;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.prodigio.comuns.anotacoes.Lookup;
import br.gov.prodigio.entidades.ProBaseVO;

@Lookup
@Entity
@Table(name = "TB_ESTADO")
public class EstadoSimplesVO extends ProBaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3273737154624328352L;
	private String nome;
	private PaisVO pais;
	private Set<CidadeVO> cidades = new LinkedHashSet<CidadeVO>();

	@Override
	@Id
	@SequenceGenerator(name = "sq_estado", sequenceName = "sq_estado", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_estado")
	public Long getId() {
		return super.getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public PaisVO getPais() {
		return pais;
	}

	public void setPais(PaisVO pais) {
		this.pais = pais;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "estado", orphanRemoval = true)
	@OrderBy("id")
	public Set<CidadeVO> getCidades() {
		return cidades;
	}

	public void setCidades(Set<CidadeVO> cidades) {
		this.cidades = cidades;
	}

	@Override
	public String toString() {
		if (getNome() == null)
			setNome("");
		return getNome();
	}
}