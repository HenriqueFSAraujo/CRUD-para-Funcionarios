package br.gov.prodemge.proddigio.meucurso.negocio.funcionario;

import br.gov.prodemge.proddigio.meucurso.entidades.funcionario.FuncionarioVO;
import br.gov.prodemge.proddigio.meucurso.negocio.MeucursoBaseRN;

import java.util.Map;
import java.util.LinkedHashMap;
import br.gov.prodigio.comuns.anotacoes.RegraDeNegocio;
import br.gov.prodigio.comuns.anotacoes.enumeracao.MomentoDeExecucao;
import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;
import br.gov.prodigio.comuns.utils.StringHelper;

public class FuncionarioRN extends MeucursoBaseRN {

	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void verificaNome(FuncionarioVO funcionarioVO) {

		Map<String, String> erros = new LinkedHashMap<String, String>();
		
		if (StringHelper.isEmpty(funcionarioVO.getNome())) {
			erros.put("nome", "Nome é obrigatório.");
		}

		if (StringHelper.isEmpty(funcionarioVO.getCpf())) {
			erros.put("cpf", "Cpf inválido.");
		}
		String regex = "P\\d{6}";

		if (StringHelper.isEmpty(funcionarioVO.getMatricula())) {
			erros.put("matricula", "Matricula inválido.");
		}

		if (!erros.isEmpty()) {
			throw new ViolacaoDeRegraEx(erros);
		}

		if (!StringHelper.validarPattern(funcionarioVO.getMatricula(), regex)) {
			erros.put("matricula", "Matricula inválida.");
		}

		if (funcionarioVO.getSalario().doubleValue() < 1000.00 || funcionarioVO.getSalario().doubleValue() > 20000.00) {
			erros.put("salario", "O Salario não pode ser menor que R$1000 ou R$20000.");
		}

		if (funcionarioVO.getBreveDescricao().length() > 200) {
			throw new ViolacaoDeRegraEx("A descrição não pode ter mais de 200 caractéres");
		}

		if (!erros.isEmpty())
			throw new ViolacaoDeRegraEx(erros);

	}

	@RegraDeNegocio(codigo = "RN003", autor = "Equipe Curso", fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES, ordem = 2)
	public void validaBreveDescricao(FuncionarioVO funcionarioVO) {
		if (funcionarioVO.getBreveDescricao() != null) {
			if (funcionarioVO.getBreveDescricao().length() > 200) {
				throw new ViolacaoDeRegraEx("A descrição não pode ter mais de 200 caractéres");
			}
		}
	}

	@RegraDeNegocio(autor = "Autor", codigo = "RN005", ordem = 1, fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void faixaDeSalario(FuncionarioVO funcionarioVO) {
		Map<String, String> erros = new LinkedHashMap<String, String>();
		if (funcionarioVO.getSalario().doubleValue() < 1000.00 || funcionarioVO.getSalario().doubleValue() > 20000.00) {
			erros.put("salario", "O salario não pode ser menor do que 1000.00 e maior que 20000.00");

			if (!erros.isEmpty()) {
				throw new ViolacaoDeRegraEx(erros);
			}
		}

	}

}
