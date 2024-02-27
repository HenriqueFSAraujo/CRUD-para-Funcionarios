package br.gov.prodemge.proddigio.meucurso.controle;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;
import org.zkoss.zul.Window;

import br.gov.prodemge.ssc.comuns.constantes.Constantes;
import br.gov.prodemge.ssc.interfaces.IUnidade;
import br.gov.prodigio.controle.WindowIntroducao;
import br.gov.prodigio.visao.helper.ProHelperView;


@SuppressWarnings({ "unchecked", })
public class MeucursoWindowIntroducao extends WindowIntroducao {

	private static final long serialVersionUID = 8200952384997878357L;

	@SuppressWarnings("rawtypes")
	@Override
	public void abrir(AbstractComponent itemDeMenuClicado) {
		String urlcasodeuso = (String) itemDeMenuClicado.getAttribute("urlcasodeuso");
		Map attributes = getTela().getAttributes(Component.SESSION_SCOPE);
		ProHelperView.insereNovoConteudoNoCentroDaJanela(urlcasodeuso, getTela(), attributes);
	}

	@SuppressWarnings("rawtypes")
	public void abrirCasoDeUso(String url, Boolean historico, String modo, String width) {
		ProHelperView instance = ProHelperView.getInstance();
		HashMap attributes = new HashMap();
		attributes.put("telaOrigem", getTela());
		instance.abreCasoDeUsoSecundario(url, (Window) getTela(), attributes, historico, modo, width);
		getTela().setVisible(true);
	}

	public void inserePainel() {
		String urlcasodeuso = "painel.zul";
		Map attributes = getTela().getAttributes(Component.SESSION_SCOPE);
		ProHelperView.insereNovoConteudoNoCentroDaJanela(urlcasodeuso, getTela(), attributes);
	}
	
	//Sobreescrita necessaria para adaptar o fechamento do menu ao novo layout
	@Override
	protected EventListener evento() {
		return e -> {
			Component divMenuBar = getTela().getFellowIfAny("menubar");
			if (divMenuBar != null) {
				abreFechaMenu((Div) divMenuBar);
			}
			super.abrir((AbstractComponent) e.getTarget());
		};
	}

	public void abreFechaMenu(Div menuBar) {
		String string = "abreFechaMenu('." + menuBar.getSclass().toString() + "')";
		Clients.evalJavaScript(string);
	}
}
