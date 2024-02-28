package br.gov.prodemge.proddigio.meucurso.soap;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.gov.prodigio.comuns.IProFacadeLocal;
import br.gov.prodigio.comuns.IProFacadeRemote;
import br.gov.prodigio.negocio.ProFacadeImp;

//Descomente as linhas abaixo para criar serviço soap generico
/*@Stateless(name = "meucursows-ejb")
@TransactionManagement(TransactionManagementType.BEAN)
@Local(IProFacadeLocal.class)
@Remote(IProFacadeRemote.class)*/
public class MeucursoBaseWSFacadeImp extends ProFacadeImp implements IProFacadeLocal, IProFacadeRemote {

	
}
