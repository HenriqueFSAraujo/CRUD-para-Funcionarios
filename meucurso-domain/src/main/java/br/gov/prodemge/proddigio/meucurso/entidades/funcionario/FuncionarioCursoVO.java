package br.gov.prodemge.proddigio.meucurso.entidades.funcionario;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.prodemge.proddigio.meucurso.entidades.MeucursoBaseVO;
import br.gov.prodemge.proddigio.meucurso.entidades.curso.CursoVO;

	@Entity
	@Table(name = "TB_FUNCIONARIO_CURSO")
	public class FuncionarioCursoVO extends MeucursoBaseVO {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5847809139073294584L;
		private FuncionarioVO funcionario;
		private CursoVO cursoVO;

		@Override
		@Id
		@SequenceGenerator(name = "sq_funcionariocursos", sequenceName = "sq_funcionarocursos", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_funcionariocursos")
		public Long getId() {
			return super.getId();
		}

		@ManyToOne(fetch = FetchType.EAGER)
		public CursoVO getCursoVO() {
			return cursoVO;
		}

		public void setCursoVO(CursoVO cursoVO) {
			this.cursoVO =  cursoVO;
		}

		@ManyToOne(fetch = FetchType.EAGER)
		public FuncionarioVO getFuncionario() {
			return funcionario;
		}

		public void setFuncionario(FuncionarioVO funcionario) {
			this.funcionario = funcionario;
		}

	}

