package br.gov.prodemge.proddigio.meucurso.controle.logradouro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;

import br.gov.prodemge.proddigio.meucurso.controle.MeucursoBaseCtr;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.BairroVO;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.CidadeVO;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.EstadoSimplesVO;
import br.gov.prodemge.proddigio.meucurso.entidades.cidade.PaisVO;
import br.gov.prodigio.controle.componente.Bandboxbind;

public class BairroCtr extends MeucursoBaseCtr<BairroVO> {

	private static final long serialVersionUID = -1262569840013458723L;

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		super.doAfterCompose(tela);
		pesquisar();
		}
	public List<CidadeVO> filtrarCidadesDeMinas(Bandboxbind bandbox) throws Exception {

		CidadeVO cidade = new CidadeVO();
		//EstadoSimplesVO estado = new EstadoSimplesVO();
		//PaisVO pais = new PaisVO();

		//cidade.setNome("C%");
		//estado.setNome("MINAS GERAIS");
		//pais.setNome("B%");

		//cidade.setEstado(estado);
		//estado.setPais(pais);

		Set<CidadeVO> listarBaseadoNoExemplo = repositorio().listarBaseadoNoExemplo(cidade, null, 0, 1000, "nome", "id", "estado.nome", "estado.pais.nome");
		List<CidadeVO> listaDeCidadesDeMinas = new ArrayList<>(listarBaseadoNoExemplo);
		return listaDeCidadesDeMinas;
	}
	
} 

