package br.gov.prodemge.proddigio.meucurso.test.funcionario;

import org.junit.Assert;
import org.junit.Test;

import br.gov.prodemge.ssc.enumerations.Operacao;
import br.gov.prodemge.proddigio.meucurso.test.MeucursoBaseFunctionalTest;
import io.qameta.allure.Description;

public class FuncionarioFunctionalTest extends MeucursoBaseFunctionalTest {

	public FuncionarioFunctionalTestHelper getFuncionarioTestHelper() {
		return (FuncionarioFunctionalTestHelper) getFunctionalTestHelper();
	}

	@Test
	@Description("Este caso de teste tem por objetivo testar o cadastro de um funcionario com sucesso.")
	public void cadastrarFuncionarioComSucesso() {

		getFuncionarioTestHelper().clicaMenuFuncionalidades();
		getFuncionarioTestHelper().clicaMenuFuncionario();

		getFuncionarioTestHelper().clicaNoBotao(Operacao.NOVO);

		getFuncionarioTestHelper().preencheCampoNome("APERTA PROCÊ");
		getFuncionarioTestHelper().preencheCampoCPF("115.377.960-97");

		getFuncionarioTestHelper().clicaNoBotao(Operacao.SALVAR);

		Assert.assertEquals("Registro gravado com sucesso", getFuncionarioTestHelper().recuperaMensagemSucesso());
	}
}
