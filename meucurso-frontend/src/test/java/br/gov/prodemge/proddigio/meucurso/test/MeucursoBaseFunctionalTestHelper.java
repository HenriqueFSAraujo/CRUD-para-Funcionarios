package br.gov.prodemge.proddigio.meucurso.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.prodigio.test.BaseFunctionalTestHelper;
import br.gov.prodigio.test.componentes.Botao;

public class MeucursoBaseFunctionalTestHelper extends BaseFunctionalTestHelper {

	@FindBy(id = "a_5")
	private WebElement menu;

	@FindBy(id = "nav_9-text")
	private WebElement menuFuncionalidade;

	@Override
	public void clicaMenuFuncionalidades() {
		Botao.clicar(menu);
		Botao.clicar(menuFuncionalidade);
	}
}
