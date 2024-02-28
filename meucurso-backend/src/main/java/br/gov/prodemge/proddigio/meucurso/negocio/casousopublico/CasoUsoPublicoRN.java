package br.gov.prodemge.proddigio.meucurso.negocio.casousopublico;

import br.gov.prodemge.proddigio.meucurso.entidades.casousopublico.CasoUsoPublicoVO;
import br.gov.prodemge.proddigio.meucurso.negocio.MeucursoBaseRN;
import br.gov.prodigio.comuns.anotacoes.RegraDeNegocio;
import br.gov.prodigio.comuns.anotacoes.enumeracao.MomentoDeExecucao;
import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;
import br.gov.prodigio.comuns.utils.StringHelper;

public class CasoUsoPublicoRN extends MeucursoBaseRN {

	@RegraDeNegocio(codigo = "RN004", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 4)
	public void validarDataInicioMenorQueDataFim(CasoUsoPublicoVO casoUsoPublicoVO) {

		if (casoUsoPublicoVO.getDataFim().before(casoUsoPublicoVO.getDataInicio())) {
			// Map<String, String> erros = new LinkedHashMap<String, String>();
			// erros.put("dataInicio", "A data de inicio não pode ser maior que a data de fim.");
			// erros.put("dataFim", "A data de inicio não pode ser maior que a data de fim.");
			// throw new ViolacaoDeRegraEx(erros);
			throw new ViolacaoDeRegraEx("A data de inicio não pode ser maior que a data de fim.");
		}
	}

	@RegraDeNegocio(codigo = "RN001", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 1)
	public void validarDescricao(CasoUsoPublicoVO casoUsoPublicoVO) {
		if (StringHelper.isEmpty(casoUsoPublicoVO.getDescricao())) {
			throw new ViolacaoDeRegraEx("A descrição deve ser preenchida");
		}
	}

	@RegraDeNegocio(codigo = "RN003", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 3)
	public void validarDataFim(CasoUsoPublicoVO casoUsoPublicoVO) {
		if (StringHelper.isEmpty(casoUsoPublicoVO.getDataFimFormatada())) {
			throw new ViolacaoDeRegraEx("A data de fim deve ser preenchida");
		}
	}

	@RegraDeNegocio(codigo = "RN002", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 2)
	public void validarDataInicio(CasoUsoPublicoVO casoUsoPublicoVO) {
		if (StringHelper.isEmpty(casoUsoPublicoVO.getDataInicioFormatada())) {
			throw new ViolacaoDeRegraEx("A data de início deve ser preenchida");
		}
	}

}
