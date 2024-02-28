package br.gov.prodemge.proddigio.meucurso.entidades.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.gov.prodemge.proddigio.entidades.enums.funcionario.FuncionarioAnexoEnum;
import br.gov.prodemge.proddigio.meucurso.entidades.MeucursoBaseVO;
import br.gov.prodigio.entidades.Arquivo;

	@Entity
	@Table(name = "TB_FUNCIONARIO_ANEXO")
	public class FuncionarioAnexoVO extends MeucursoBaseVO implements Arquivo {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1066209359631621408L;
		private FuncionarioVO funcionarioVO;
		private byte[] bytes;
		private String nome;
		private String applicationType;
		private String formato;
		private FuncionarioAnexoEnum anexoTipo;

		@Override
		@Id
		@SequenceGenerator(name = "SQ_PRO_ANEXO_DE_PROCESSO", sequenceName = "SQ_PRO_ANEXO_DE_PROCESSO", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRO_ANEXO_DE_PROCESSO")
		public Long getId() {
			return super.getId();
		}

		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "ID_FUNCIONARIO")
		public FuncionarioVO getFuncionario() {
			return funcionarioVO;
		}

		public void setFuncionario(FuncionarioVO funcionarioVO) {
			this.funcionarioVO = funcionarioVO;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see br.gov.prodemge.grp.contabil.entidades.Arquivo#getAnexo()
		 */
		@Override
		@Lob
		@Column(name = "bytes")
		public byte[] getBytes() {
			return bytes;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see br.gov.prodemge.grp.contabil.entidades.Arquivo#setAnexo(byte[])
		 */
		@Override
		public void setBytes(byte[] anexo) {
			this.bytes = anexo;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see br.gov.prodemge.grp.contabil.entidades.Arquivo#getNome()
		 */
		@Override
		public String getNome() {
			return nome;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see br.gov.prodemge.grp.contabil.entidades.Arquivo#setNome(java.lang.String)
		 */
		@Override
		public void setNome(String nome) {
			this.nome = nome;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see br.gov.prodemge.grp.contabil.entidades.Arquivo#getApplicationType()
		 */
		@Override
		@Column(name = "APPLICATION_TYPE")
		public String getApplicationType() {
			return applicationType;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see br.gov.prodemge.grp.contabil.entidades.Arquivo#setApplicationType(java.lang.String)
		 */
		@Override
		public void setApplicationType(String applicationType) {
			this.applicationType = applicationType;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see br.gov.prodemge.grp.contabil.entidades.Arquivo#getFormato()
		 */
		@Override
		public String getFormato() {
			return formato;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see br.gov.prodemge.grp.contabil.entidades.Arquivo#setFormato(java.lang.String)
		 */
		@Override
		public void setFormato(String formato) {
			this.formato = formato;
		}

		@Enumerated(EnumType.STRING)
		public FuncionarioAnexoEnum getAnexoTipo() {
			return anexoTipo;
		}

		public void setAnexoTipo(FuncionarioAnexoEnum anexoTipo) {
			this.anexoTipo = anexoTipo;
		}

		@Transient
		public Boolean getIsImagem() {
			if (getFormato() == null)
				return false;
			return getFormato().equals("jpeg") || getFormato().equals("png");
		}
}
