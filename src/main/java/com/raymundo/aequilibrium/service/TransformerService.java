package com.raymundo.aequilibrium.service;

import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fasterxml.jackson.databind.JsonNode;
import com.raymundo.aequilibrium.api.TransformerRepository;
import com.raymundo.aequilibrium.bean.MessageBean;
import com.raymundo.aequilibrium.model.Transformer;
import com.raymundo.aequilibrium.utilities.Constant;
import com.raymundo.aequilibrium.utilities.Utilities;

@Service
public class TransformerService {

	
	@Autowired
	private TransformerRepository rTransformer;
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.ENGLISH);
	    return slr;
	}
	
	protected final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings("unused")
	@Transactional
	public String saveUpdateTransformer(Transformer transformer) {
		MessageBean messageBean = new MessageBean();
		String message = null;
//		Transformer serchTransformer = null;
        int skill = 0;
		try {
//			serchTransformer = rTransformer.getTransformerByName(transformer.getName());
//			logger.info("Lo que se pretende almacenar name" + transformer.getName()+" tipo : "+transformer.getType()+" firepower : "+transformer.getFirepower()+
//					" courage : "+transformer.getCourage()+" endurance : "+transformer.getEndurance()+" inteligence : "+transformer.getIntelligence()
//					+" rank : "+transformer.getRank()+" skill : "+transformer.getSkill()+" speed : "+transformer.getSpeed()+" strength : "+transformer.getStrength());
			if (transformer.getId()!=null && transformer.getId()>0) {
				messageBean.setMessage(Constant.UPDATE_TRANSFORMER_OK);
//				transformer.setId(serchTransformer.getId());
			} else {
				messageBean.setMessage(Constant.INSERT_TRANSFORMER_OK);
			}
			
			rTransformer.save(transformer);

			message = Utilities.mensajeToJson(messageBean);
			return message;

		} catch (RuntimeException ex) {

			logger.error(ex.getMessage());
			if (transformer.getId()!=null && transformer.getId()>0) {
				messageBean.setMessage(Constant.UPDATE_TRANSFORMER_FAIL);
			} else {
				messageBean.setMessage(Constant.INSERT_TRANSFORMER_FAIL);
			}
			message = Utilities.mensajeToJson(messageBean);
			return message;
		}
			
		
	}
	
	
	@SuppressWarnings("unused")
	@Transactional
	public String getTransformers() {


		List<Transformer> listTransformers = (List<Transformer>) rTransformer.findAll();

		JsonNode dataOmdb = null;
		String finalJson = null;
		MessageBean messageBean = new MessageBean();
		String message = null;


		if(listTransformers.size()>0) {
			finalJson = Utilities.transformerListToJson(listTransformers);
		}else {
			messageBean.setMessage( Constant.NO_TRANSFORMERS );
			finalJson = Utilities.mensajeToJson(messageBean);
		}
		

		return finalJson;
	}

	@SuppressWarnings("unused")
	@Transactional
	public String deleteTransformer(int idTransformer) {
		
		MessageBean messageBean = new MessageBean();
		String message = null;
		Long id = Long.valueOf(idTransformer);
		try {
			if(rTransformer.findById(id).isPresent()){
					
			rTransformer.deleteById(id);
			}else {
				messageBean.setMessage( Constant.DELETE_TRANSFORMER_NOT_EXIST );
				message = Utilities.mensajeToJson(messageBean);
				return message;
			}
			messageBean.setMessage( Constant.DELETE_TRANSFORMER_OK );
			message = Utilities.mensajeToJson(messageBean);
			return message;
			
		 } catch (RuntimeException ex) {

	        logger.error(ex.getMessage());
			messageBean.setMessage( Constant.DELETE_TRANSFORMER_FAIL );
			message = Utilities.mensajeToJson(messageBean);
			return message;
		 }
		
	}
	

}


  
