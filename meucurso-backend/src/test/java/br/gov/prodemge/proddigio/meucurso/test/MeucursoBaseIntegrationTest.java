package br.gov.prodemge.proddigio.meucurso.test;

import javax.ejb.EJB;
import java.util.Date;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import br.gov.prodigio.comuns.IProFacadeRemote;
import br.gov.prodigio.entidades.ProBaseVO;
import br.gov.prodigio.test.ProBaseIntegrationTest;
import br.gov.prodigio.entidades.StatusDoRegistro;
public class MeucursoBaseIntegrationTest {

	protected static final String WAR = ".war";
	protected static final String PROJETO_WEB = "meucurso";
	protected static final String SETTINGS_PATH = "C:/Prodemge/maven/apache-maven-3.0.5/conf/settings.xml";
	protected static final String[] PACOTES = new String[] { "br.gov.prodemge.proddigio.meucurso.entidades", "br.gov.prodemge.proddigio.meucurso.negocio", "br.gov.prodemge.proddigio.meucurso.test", "org.postgresql.util" };

	@EJB
	protected IProFacadeRemote repositorio;

	public static WebArchive createDeploy() {
		return ProBaseIntegrationTest.instanciarAplicacao(setSettingsPath(), setNomeProjeto(), setExtensaoArquivo(), setNomesPacotes());
	}

	protected static String[] setNomesPacotes() {
		return MeucursoBaseIntegrationTest.PACOTES;
	}

	protected static String setExtensaoArquivo() {
		return MeucursoBaseIntegrationTest.WAR;
	}

	protected static String setNomeProjeto() {
		return MeucursoBaseIntegrationTest.PROJETO_WEB;
	}

	protected static String setSettingsPath() {
		return MeucursoBaseIntegrationTest.SETTINGS_PATH;
	}

	/* METODO EXEMPLO QUE USAREMOS EM TODAS AS CLASSES DE TESTES DE INTEGRAÇÃO */
	protected Exception capturaExcecaoAoGravar(ProBaseVO proVO) {
		Exception e1 = new Exception("Excecao nao esperada!");
		try {
			repositorio.gravar(proVO);
		} catch (Exception e) {
			e1 = e;
		}
		return e1;
	}

	protected ProBaseVO preencheInformacoesDeAuditoria(ProBaseVO proBaseVO) {

		proBaseVO.setCdLoginMovimentacao("p000000");
		proBaseVO.setIpMovimentacao("0.0.0.0");
		proBaseVO.setTpOperacao("I");
		proBaseVO.setTsMovimentacao(new Date());
		proBaseVO.setStatusDoRegistro(StatusDoRegistro.ATIVO);
		proBaseVO.setNrVersao(1);

		return proBaseVO;
	}

}
