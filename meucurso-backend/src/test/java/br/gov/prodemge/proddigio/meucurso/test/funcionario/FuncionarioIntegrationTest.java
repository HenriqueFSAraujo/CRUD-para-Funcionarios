package br.gov.prodemge.proddigio.meucurso.test.funcionario;

import br.gov.prodemge.proddigio.meucurso.entidades.funcionario.FuncionarioVO;
import br.gov.prodemge.proddigio.meucurso.test.MeucursoBaseIntegrationTest;

import org.fest.assertions.Assertions;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;

@RunWith(Arquillian.class)
public class FuncionarioIntegrationTest extends MeucursoBaseIntegrationTest {

	private final String CPF = "79340092082";
	private final String NOME = "Fulano da Silva";
	
	@Deployment
	@OverProtocol("Servlet 3.0")
	public static WebArchive createDeploy() {
		return MeucursoBaseIntegrationTest.createDeploy();
	}

	@Test(expected = ViolacaoDeRegraEx.class)
	public void verificaNomeObrigatorio() throws Throwable {

		FuncionarioVO funcionarioVO = new FuncionarioVO();

		funcionarioVO = (FuncionarioVO) preencheInformacoesDeAuditoria(funcionarioVO);

		funcionarioVO.setCpf(CPF);

		repositorio.gravar(funcionarioVO);
	}

	@Test(expected = ViolacaoDeRegraEx.class)
	public void verificaCPFObrigatorio() throws Throwable {

		FuncionarioVO funcionarioVO = new FuncionarioVO();

		funcionarioVO = (FuncionarioVO) preencheInformacoesDeAuditoria(funcionarioVO);

		funcionarioVO.setNome(NOME);

		repositorio.gravar(funcionarioVO);
	}
	
	@Test
	public void cadastraFuncionarioComSucesso() throws Throwable {

		FuncionarioVO funcionarioVO = new FuncionarioVO();

		funcionarioVO = (FuncionarioVO) preencheInformacoesDeAuditoria(funcionarioVO);

		funcionarioVO.setNome(NOME);
		funcionarioVO.setCpf(CPF);

		Object id = (Long) repositorio.gravar(funcionarioVO);

		Assertions.assertThat(id).isNotNull();
	}
}
