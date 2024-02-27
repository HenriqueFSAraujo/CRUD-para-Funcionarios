package br.gov.prodemge.proddigio.meucurso.controle;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Clients;

import br.gov.prodemge.proddigio.meucurso.entidades.MeucursoBaseVO;
import br.gov.prodigio.visao.helper.ProMessageHelper;

public class MeucursoBaseMessageHelper extends ProMessageHelper {
	@Override
	public void emiteMensagemSucesso(String msg, Component component) {
		Clients.showNotification(msg, "info", component, "middle_center", 1000, true);
	}

	public MeucursoBaseMessageHelper(MeucursoBaseCtr<MeucursoBaseVO> ctr) {
		super(ctr);
	}
}
