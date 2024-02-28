package br.gov.prodemge.proddigio.meucurso.entidades.compromisso;

	
	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.SequenceGenerator;
	import javax.persistence.Table;
	import javax.persistence.Transient;

	import br.gov.prodemge.proddigio.meucurso.entidades.MeucursoBaseVO;
	import br.gov.prodigio.comuns.utils.DataHelper;

	@Entity
	@Table(name = "TB_COMPROMISSO")
	public class CompromissoVO extends MeucursoBaseVO {
		private static final long serialVersionUID = -8170894291737312727L;

		@Override
		@Id
		@SequenceGenerator(name = "sq_compromisso", sequenceName = "sq_compromisso", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_compromisso")
		public Long getId() {
			return super.getId();
		}

		private String descricao;
		private Date dataInicio;
		private Date dataFim;

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Date getDataInicio() {
			return dataInicio;
		}

		public void setDataInicio(Date dataInicio) {
			this.dataInicio = dataInicio;
		}

		public Date getDataFim() {
			return dataFim;
		}

		public void setDataFim(Date dataFim) {
			this.dataFim = dataFim;
		}

		@Transient
		public String getDataInicioFormatada() {
			return dataInicio != null ? DataHelper.converteData(dataInicio, "dd/MM/yyyy") : "";
		}

		@Transient
		public String getDataFimFormatada() {
			return dataFim != null ? DataHelper.converteData(dataFim, "dd/MM/yyyy") : "";
		}
	}


