package br.gov.prodemge.proddigio.meucurso.entidades.cidade;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.prodemge.proddigio.meucurso.entidades.MeucursoBaseVO;
import br.gov.prodigio.comuns.anotacoes.Lookup;
@Lookup
@Entity
@Table(name = "TB_PAIS")
public class PaisVO  extends MeucursoBaseVO{
	
	private static final long serialVersionUID = -1867520330557419868L;
	private Set<EstadoSimplesVO> estados = new LinkedHashSet<EstadoSimplesVO>();
	private String nome;

	@Override
	@Id
	@SequenceGenerator(name = "sq_pais", sequenceName = "sq_pais", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pais")
	public Long getId() {
		return super.getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pais", orphanRemoval = true)
	@OrderBy("id")
	public Set<EstadoSimplesVO> getEstados() {
		return estados;
	}

	public void setEstados(Set<EstadoSimplesVO> estados) {
		this.estados = estados;
	}

	@Override
	public String toString() {
		if (getNome() == null)
			setNome("");
		return getNome();
	}

	
	

}
