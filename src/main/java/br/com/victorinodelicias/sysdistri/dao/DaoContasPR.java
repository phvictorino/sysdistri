package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.victorinodelicias.sysdistri.entity.EnContasPr;
import br.com.victorinodelicias.sysdistri.enums.EnumTipoConta;

public class DaoContasPR extends GenericDAO<EnContasPr> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<EnContasPr> listarContasReceber() {

		Query query = em
				.createQuery("SELECT c FROM EnContasPr c WHERE c.tipo = " + EnumTipoConta.CONTA_RECEBER.getCodigo());

		try {
			return query.getResultList();
		} catch (NoResultException n) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
