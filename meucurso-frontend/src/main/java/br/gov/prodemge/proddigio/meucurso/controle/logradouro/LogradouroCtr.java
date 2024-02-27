package br.gov.prodemge.proddigio.meucurso.controle.logradouro;

import org.zkoss.zk.ui.Component;

import br.gov.prodemge.proddigio.meucurso.controle.MeucursoBaseCtr;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.LogradouroVO;

public class LogradouroCtr extends MeucursoBaseCtr<LogradouroVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1262569840013458723L;

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		super.doAfterCompose(tela);
		pesquisar();
	}
}
