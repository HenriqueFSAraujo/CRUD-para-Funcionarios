package br.gov.prodemge.proddigio.meucurso.test.funcionario;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.prodemge.proddigio.meucurso.test.MeucursoBaseFunctionalTestHelper;
import br.gov.prodigio.test.componentes.Botao;
import br.gov.prodigio.test.componentes.CampoTexto;
import io.qameta.allure.Step;

public class FuncionarioFunctionalTestHelper extends MeucursoBaseFunctionalTestHelper {

	@FindBy(id = "navitem_11-text")
	private WebElement menuFuncionario;

	@FindBy(id = "textboxbind_93")
	private WebElement campoNome;

	@FindBy(id = "cpfboxbind_97")
	private WebElement campoCPF;

	@Step("Acessando o menu funcionário")
	public void clicaMenuFuncionario() {
		Botao.clicar(menuFuncionario);
	}

	@Step("Informando o nome \"{0}\"")
	public void preencheCampoNome(String nomeFuncionario) {
		CampoTexto.preencher(campoNome, nomeFuncionario);
	}

	@Step("Informando o CPF \"{0}\"")
	public void preencheCampoCPF(String cpfFuncionario) {
		CampoTexto.preencher(campoCPF, cpfFuncionario);
	}
}
