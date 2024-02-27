package br.gov.prodemge.proddigio.meucurso.controle;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Window;

import br.gov.prodigio.controle.WindowIndex;
import br.gov.prodigio.visao.helper.ProHelperView;

@SuppressWarnings({ "unchecked", })
public class MeucursoWindowIndex extends WindowIndex {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8200952384997878357L;

	@SuppressWarnings("rawtypes")
	@Override
	public void abrir(AbstractComponent itemDeMenuClicado) {
		String urlcasodeuso = (String) itemDeMenuClicado.getAttribute("urlcasodeuso");
		Map attributes = getTela().getAttributes(Component.SESSION_SCOPE);
		ProHelperView.insereNovoConteudoNoCentroDaJanela(urlcasodeuso, getTela(), attributes);
	}
	
	@Override
	public void configuraUsuarioUnidadeLogada() {

	}

	@SuppressWarnings("rawtypes")
	public void abrirCasoDeUso(String url, Boolean historico, String modo, String width) {
		ProHelperView instance = ProHelperView.getInstance();
		HashMap attributes = new HashMap();
		attributes.put("telaOrigem", getTela());
		instance.abreCasoDeUsoSecundario(url, (Window) getTela(), attributes, historico, modo, width);
		getTela().setVisible(true);
	}
	
}
