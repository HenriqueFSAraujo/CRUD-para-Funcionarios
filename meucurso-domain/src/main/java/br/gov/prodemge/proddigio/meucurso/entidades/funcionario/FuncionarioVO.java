package br.gov.prodemge.proddigio.meucurso.entidades.funcionario;



import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.gov.prodemge.proddigio.entidades.enums.funcionario.EstadoCivilEnum;
import br.gov.prodemge.proddigio.entidades.enums.funcionario.FuncionarioAnexoEnum;
import br.gov.prodemge.proddigio.meucurso.entidades.MeucursoBaseVO;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.CidadeVO;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.EstadoSimplesVO;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.PaisVO;
import br.gov.prodemge.proddigio.meucurso.entidades.curso.CursoAreaEnum;
import br.gov.prodemge.proddigio.meucurso.entidades.curso.CursoVO;
import br.gov.prodigio.comuns.anotacoes.ExclusaoLogica;
import br.gov.prodigio.comuns.utils.StringHelper;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class FuncionarioVO extends MeucursoBaseVO {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String matricula;
	private PaisVO paisVO;
	private EstadoSimplesVO estadoVO;
	private CidadeVO cidade;
	private BigDecimal salario;
	private FuncionarioEnderecoVO funcionarioEndereco = new FuncionarioEnderecoVO();
	private Set<FuncionarioCursoVO> cursos = new LinkedHashSet<FuncionarioCursoVO>();
	private Set<FuncionarioAnexoVO> anexos = new LinkedHashSet<FuncionarioAnexoVO>();
	private Boolean temFilho;
	private EstadoCivilEnum estadoCivil;
	private String breveDescricao;

	@Override
	@Id
	@SequenceGenerator(name = "sq_funcionario", sequenceName = "sq_funcionario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_funcionario")
	public Long getId() {
		return super.getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@ManyToOne
	public CidadeVO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeVO cidade) {
		this.cidade = cidade;
	}

	@Transient
	public PaisVO getPaisVO() {
		if (this.paisVO == null && cidade != null && cidade.getEstado() != null) {
			this.paisVO = cidade.getEstado().getPais();
		}
		return this.paisVO;
	}

	public void setPaisVO(PaisVO paisVO) {
		this.estadoVO = new EstadoSimplesVO();
		this.estadoVO.setPais(paisVO);
		this.paisVO = paisVO;
	}

	@Transient
	public EstadoSimplesVO getEstadoVO() {
		if (estadoVO == null && cidade != null) {
			this.estadoVO = cidade.getEstado();
		}
		return this.estadoVO;
	}

	public void setEstadoVO(EstadoSimplesVO estadoVO) {
		/*
		 * this.cidade = new CidadeVO(); this.cidade.setEstado(estadoVO);
		 */this.estadoVO = estadoVO;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval = true)
	@OrderBy("id")
	public Set<FuncionarioCursoVO> getCursos() {
		return cursos;
	}

	public void setCursos(Set<FuncionarioCursoVO> cursos) {
		this.cursos = cursos;
	}

	 @Transient
	 public Set<FuncionarioCursoVO> getCursosExatas() {
	 Set<FuncionarioCursoVO> cursosExatas = new HashSet<FuncionarioCursoVO>();
	 for (FuncionarioCursoVO funcionarioCursoVO : cursos) {
	 CursoVO cursoVO = funcionarioCursoVO.getCursoVO();
	 CursoAreaEnum areaCurso = cursoVO.getAreaCurso();
	 if (cursoVO != null && areaCurso != null && areaCurso.equals(CursoAreaEnum.EXATAS))
	 cursosExatas.add(funcionarioCursoVO);
	 }
	 return cursosExatas;
	 }

	public void setCursosExatas(Set<FuncionarioCursoVO> cursos) {
		if (this.cursos != null)
			this.cursos.addAll(cursos);
	}

	 @Transient
	 public Set<FuncionarioCursoVO> getCursosHumanas() {
	 Set<FuncionarioCursoVO> cursosAux = new HashSet<FuncionarioCursoVO>();
	 for (FuncionarioCursoVO funcionarioCursoVO : cursos) {
	 CursoVO cursoVO = funcionarioCursoVO.getCursoVO();
	 CursoAreaEnum areaCurso = cursoVO.getAreaCurso();
	 if (cursoVO != null && areaCurso != null && areaCurso.equals(CursoAreaEnum.HUMANAS))
	 cursosAux.add(funcionarioCursoVO);
	 }
	 return cursosAux;
	 }

	public void setCursosHumanas(Set<FuncionarioCursoVO> cursos) {
		if (this.cursos != null)
			this.cursos.addAll(cursos);
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval = true)
	public FuncionarioEnderecoVO getFuncionarioEndereco() {
		return funcionarioEndereco;
	}

	public void setFuncionarioEndereco(FuncionarioEnderecoVO funcionarioEndereco) {
		this.funcionarioEndereco = funcionarioEndereco;
		if (funcionarioEndereco != null)
			funcionarioEndereco.setFuncionario(this);
	}

	@Override
	@Lob
	public byte[] getImagem() {
		return super.getImagem();
	}

	@Transient
	public String getCursosStr() {
		String cursosStr = "";
		Set<FuncionarioCursoVO> cursos2 = getCursos();
		for (FuncionarioCursoVO funcionarioCursoVO : cursos2) {
			cursosStr = ((CursoVO) funcionarioCursoVO.getCursoVO()).getNome() + ", " + cursosStr;
		}
		return cursosStr;
	}

	public Boolean getTemFilho() {
		return temFilho;
	}

	public void setTemFilho(Boolean temFilho) {
		this.temFilho = temFilho;
	}

	@Enumerated(EnumType.STRING)
	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getBreveDescricao() {
		return breveDescricao;
	}

	public void setBreveDescricao(String breveDescricao) {
		this.breveDescricao = breveDescricao;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval = true)
	@OrderBy("id")
	public Set<FuncionarioAnexoVO> getAnexos() {
		return anexos;
	}

	public void setAnexos(Set<FuncionarioAnexoVO> anexos) {
		this.anexos = anexos;
	}

	@Transient
	public Set<FuncionarioAnexoVO> getAnexosMemorando() {
		Set<FuncionarioAnexoVO> anexosAux = new HashSet<FuncionarioAnexoVO>();
		for (FuncionarioAnexoVO funcionarioAnexoVO : this.anexos) {
			if (funcionarioAnexoVO.getAnexoTipo() != null && funcionarioAnexoVO.getAnexoTipo().equals(FuncionarioAnexoEnum.MEMORANDO))
				anexosAux.add(funcionarioAnexoVO);
		}
		return anexosAux;
	}

	public void setAnexosMemorando(Set<FuncionarioAnexoVO> anexos) {
		if (this.anexos != null)
			this.anexos.addAll(anexos);
	}

	@Transient
	public Set<FuncionarioAnexoVO> getAnexosOficio() {
		Set<FuncionarioAnexoVO> anexosAux = new HashSet<FuncionarioAnexoVO>();
		for (FuncionarioAnexoVO funcionarioAnexoVO : this.anexos) {
			if (funcionarioAnexoVO.getAnexoTipo() != null && funcionarioAnexoVO.getAnexoTipo().equals(FuncionarioAnexoEnum.OFICIO))
				anexosAux.add(funcionarioAnexoVO);
		}
		return anexosAux;
	}

	public void setAnexosOficio(Set<FuncionarioAnexoVO> anexos) {
		if (this.anexos != null)
			this.anexos.addAll(anexos);
	}

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "funcionario")
//	@OrderBy("id")
//	public Set<FuncionarioDependenteVO> getDependentes() {
//		return dependentes;
//	}
//
//	public void setDependentes(Set<FuncionarioDependenteVO> dependentes) {
//		this.dependentes = dependentes;
//	}

	@Transient
	public String getCpfFormatado() {
		return cpf != null ? StringHelper.aplicarMascara("###.###.###-##", cpf) : "";
	}

	@Transient
	public String getTemFilhoFormatado() {
		return Boolean.TRUE.equals(temFilho) ? "Sim" : "Não";
	}


	
	

	

		





	
	

}
