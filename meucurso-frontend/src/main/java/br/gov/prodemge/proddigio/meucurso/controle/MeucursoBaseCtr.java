package br.gov.prodemge.proddigio.meucurso.controle;

import br.gov.prodemge.proddigio.meucurso.entidades.MeucursoBaseVO;
import br.gov.prodigio.controle.ProCtr;
import br.gov.prodigio.visao.helper.ProMessageHelper;

public class MeucursoBaseCtr<ENTITY extends MeucursoBaseVO> extends ProCtr<ENTITY> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7461391100856773714L;
	@SuppressWarnings("unchecked")
	private ProMessageHelper messageHelper = new MeucursoBaseMessageHelper((MeucursoBaseCtr<MeucursoBaseVO>) this);

	@Override
	public ProMessageHelper getMessagesHelper() {
		return messageHelper;
	}

	
}
