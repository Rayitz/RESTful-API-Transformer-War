package com.raymundo.aequilibrium.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.raymundo.aequilibrium.api.TransformerRepository;
import com.raymundo.aequilibrium.model.Transformer;

@Primary
public class TransformerDao implements TransformerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	protected final Log logger = LogFactory.getLog(getClass());


//	@SuppressWarnings("unchecked")
//	@Override
//	public Transformer getTransformerByName(String name){
//	 try {
//			String query = "FROM Transformer t WHERE t.name =:name";
//
//		Query q = entityManager.createQuery(query);
//		q.setParameter("name", name);
//		
//		return (Transformer) q.getSingleResult();
//		
//	 }  catch (NoResultException ex) {
//			return null;
//	 }catch (RuntimeException ex) {
//			logger.error(ex.getMessage());			
//			return null;
//	 }
//	}


	@Override
	public List<Transformer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Transformer> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Transformer> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Transformer> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Transformer> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteInBatch(Iterable<Transformer> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Transformer getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Transformer> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Transformer> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Transformer> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Transformer> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Transformer> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Transformer entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends Transformer> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Transformer> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Transformer> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Transformer> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <S extends Transformer> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
