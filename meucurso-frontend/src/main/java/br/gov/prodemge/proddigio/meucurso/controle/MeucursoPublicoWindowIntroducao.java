package br.gov.prodemge.proddigio.meucurso.controle;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;

import br.gov.prodemge.ssc.comuns.constantes.Constantes;
import br.gov.prodigio.controle.WindowPrincipalUnsecured;

public class MeucursoPublicoWindowIntroducao extends WindowPrincipalUnsecured {
	
	//Metodo necessario para adaptar o fechamento do menu ao novo layout
	public void abreFechaMenu(Div menuBar) {
		String metodoJavascriptAbreFechaMenu = "abreFechaMenu('." + menuBar.getSclass().toString() + "')";
		Clients.evalJavaScript(metodoJavascriptAbreFechaMenu);
	}
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		configuraUsuarioUnidadeLogada();
	}
	
}
