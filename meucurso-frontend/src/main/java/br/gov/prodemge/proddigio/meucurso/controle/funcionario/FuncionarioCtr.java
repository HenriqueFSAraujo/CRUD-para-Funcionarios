package br.gov.prodemge.proddigio.meucurso.controle.funcionario;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;

import br.gov.prodemge.proddigio.meucurso.controle.MeucursoBaseCtr;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.LogradouroVO;
import br.gov.prodemge.proddigio.meucurso.entidades.funcionario.FuncionarioVO;
import br.gov.prodigio.entidades.ProBaseVO;

public class FuncionarioCtr extends MeucursoBaseCtr<FuncionarioVO> {

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		super.doAfterCompose(tela);
		pesquisar();
	}
	
	private String cepDeApoio;

	public String getCepDeApoio() {
		return cepDeApoio;
	}

	public void setCepDeApoio(String cepDeApoio) {
		this.cepDeApoio = cepDeApoio;
	}

	
	public void recuperaLogradouroPorCep(String cepFormatado) throws Exception {
		String cepSemFormatacao = cepFormatado.replace(".", "").replace("-", "");

		LogradouroVO exemplo = new LogradouroVO();
		exemplo.setCep(cepSemFormatacao);

		LogradouroVO logradouro = repositorio().recuperaPorChaveNatural(exemplo, "cep");
		setCepDeApoio(null);

		getObjetoAtual().getFuncionarioEndereco().setLogradouro(logradouro);
		Component parteDaTelaQueContemOsCamposDeEndereco = getComponentById("endereco");
		getBinder().loadComponent(parteDaTelaQueContemOsCamposDeEndereco);
	}
	
	public void limparFoto(String idCampoImagem) {
		getObjetoAtual().setImagem(null);
		recarregarComponente(idCampoImagem);
	}


	

}
