package br.prodemge.gov.br.proddigio.meucurso.controle.curso;

import org.zkoss.zk.ui.Component;

import br.gov.prodemge.proddigio.meucurso.controle.MeucursoBaseCtr;
import br.gov.prodemge.proddigio.meucurso.entidades.curso.CursoVO;

public class CursoCtr extends MeucursoBaseCtr<CursoVO> {

	private static final long serialVersionUID = -6212997118498742374L;

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		super.doAfterCompose(tela);
		pesquisar();
	}

}
