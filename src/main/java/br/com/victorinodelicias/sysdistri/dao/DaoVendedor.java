package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnVendedor;

@Transactional
public class DaoVendedor extends GenericDAO<EnVendedor> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<DtoVendedor> buscarTodosPorDto() {

		Query query = em
				.createQuery("SELECT new br.com.victorinodelicias.dto.DtoVendedor(v.id, v.nome) FROM EnVendedor v");

		try {
			return query.getResultList();
		} catch (NoResultException n) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public DtoVendedor buscarPorIdDto(Integer id) {

		Query query = em.createQuery(
				"SELECT new br.com.victorinodelicias.dto.DtoVendedor(v.id, v.nome) FROM EnVendedor v WHERE v.id = :id");
		query.setParameter("id", id);
		try {
			return (DtoVendedor) query.getSingleResult();
		} catch (NoResultException n) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
