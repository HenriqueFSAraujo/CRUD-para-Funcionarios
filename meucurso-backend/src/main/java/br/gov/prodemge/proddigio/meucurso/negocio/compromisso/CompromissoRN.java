package br.gov.prodemge.proddigio.meucurso.negocio.compromisso;


import br.gov.prodemge.proddigio.meucurso.entidades.compromisso.CompromissoVO;
import br.gov.prodemge.proddigio.meucurso.negocio.MeucursoBaseRN;
import br.gov.prodigio.comuns.anotacoes.RegraDeNegocio;
import br.gov.prodigio.comuns.anotacoes.enumeracao.MomentoDeExecucao;
import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;
import br.gov.prodigio.comuns.utils.StringHelper;

public class CompromissoRN extends MeucursoBaseRN {
	
	@RegraDeNegocio(codigo = "RN004", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 4)
	public void validarDataInicioMenorQueDataFim(CompromissoVO compromissoVO) {
		if (compromissoVO.getDataFim().before(compromissoVO.getDataInicio())) {
			throw new ViolacaoDeRegraEx("A data de inicio não pode ser maior que a data de fim.");
		}
	}
	@RegraDeNegocio(codigo = "RN001", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 1)
	public void validarDescricao(CompromissoVO compromissoVO) {
		if (StringHelper.isEmpty(compromissoVO.getDescricao())) {
			throw new ViolacaoDeRegraEx("A descrição deve ser preenchida");
		}
	}

	@RegraDeNegocio(codigo = "RN003", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 3)
	public void validarDataFim(CompromissoVO compromissoVO) {
		if (StringHelper.isEmpty(compromissoVO.getDataFimFormatada())) {
			throw new ViolacaoDeRegraEx("A data de fim deve ser preenchida");
		}
	}

	@RegraDeNegocio(codigo = "RN002", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 2)
	public void validarDataInicio(CompromissoVO compromissoVO) {
		if (StringHelper.isEmpty(compromissoVO.getDataInicioFormatada())) {
			throw new ViolacaoDeRegraEx("A data de início deve ser preenchida");
		}
	}

}
