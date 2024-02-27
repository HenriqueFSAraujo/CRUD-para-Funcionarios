package br.gov.prodemge.proddigio.meucurso.compromisso;

import org.zkoss.zk.ui.Component;

import br.gov.prodemge.proddigio.meucurso.controle.MeucursoBaseCtr;
import br.gov.prodemge.proddigio.meucurso.entidades.compromisso.CompromissoVO;

public class CompromissoCtr extends MeucursoBaseCtr<CompromissoVO> {
	@Override
	public void doAfterCompose(Component arg0) throws Exception {
		super.doAfterCompose(arg0);
		pesquisar();
	}


}
