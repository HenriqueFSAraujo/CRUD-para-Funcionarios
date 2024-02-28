package br.gov.prodemge.proddigio.meucurso.negocio.cidade;		
import java.util.LinkedHashMap;
import java.util.Map;

import br.gov.prodemge.proddigio.meucurso.entidades.cidade.BairroVO;
import br.gov.prodemge.proddigio.meucurso.entidades.funcionario.FuncionarioVO;
import br.gov.prodemge.proddigio.meucurso.negocio.MeucursoBaseRN;
import br.gov.prodigio.comuns.anotacoes.RegraDeNegocio;
import br.gov.prodigio.comuns.anotacoes.enumeracao.MomentoDeExecucao;
import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;
import br.gov.prodigio.comuns.utils.StringHelper;

public class BairroRN extends MeucursoBaseRN {

	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void verificaNome(BairroVO bairroVO) {
		Map<String, String> erros = new LinkedHashMap<String, String>();
		if (StringHelper.isEmpty(bairroVO.getNome())) {
			erros.put("nome", "Nome é obrigatório.");
		}
	}
	@RegraDeNegocio(codigo = "RN003", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 2)
	public void verificaCidade(BairroVO bairroVO) {
		if (bairroVO.getCidade() != null) {
				throw new ViolacaoDeRegraEx("Cidade é obrigatório.");
			}
		}
	}

