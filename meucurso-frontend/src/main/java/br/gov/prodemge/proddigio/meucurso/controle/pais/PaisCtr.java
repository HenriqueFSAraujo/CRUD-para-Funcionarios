package br.gov.prodemge.proddigio.meucurso.controle.pais;

import org.zkoss.zk.ui.Component;

import br.gov.prodemge.proddigio.meucurso.controle.MeucursoBaseCtr;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.CidadeVO;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.EstadoSimplesVO;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.PaisVO;
import br.gov.prodigio.entidades.ProBaseVO;

public class PaisCtr extends MeucursoBaseCtr<PaisVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1262569840013458723L;

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		super.doAfterCompose(tela);
		pesquisar();
	}
	
	@Override
	protected void aposSalvar(ProBaseVO objetoAtual) {
		super.aposSalvar(objetoAtual);
		try {
			for (EstadoSimplesVO estado : getObjetoAtual().getEstados()) {
				getHelperView().atualizaLookUp(estado, getWindowAtual());
				for (CidadeVO cidade : estado.getCidades()) {
					getHelperView().atualizaLookUp(cidade, getWindowAtual());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}