package br.com.eduardodornelles.infogoods.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eduardodornelles.infogoods.dao.CommentDao;
import br.com.eduardodornelles.infogoods.dao.PostingDao;
import br.com.eduardodornelles.infogoods.dao.ProductDao;
import br.com.eduardodornelles.infogoods.dao.UserDao;
/**
 * Abstract class containing the Daos and 
 * other things useful to all services classes. 
 * @author Eduardo Dornelles
 *
 */
public class AbstractService {

	/**
	 * User repository that allow to search on table T_PESSOA.
	 */
	@Autowired
	protected UserDao userDao;
	
	/**
	 * User repository that allow to search on table T_PRODUTO.
	 */
	@Autowired
	protected ProductDao ProductDao;
	
	/**
	 * User repository that allow to search on table T_POSTAGEM.
	 */
	@Autowired
	protected PostingDao postingDao;
	
	/**
	 * User repository that allow to search on table T_COMENTARIO.
	 */
	@Autowired
	protected CommentDao CommentDao;
	
	/**
	 * Messages repository that allow to search on table T_MENSAGEM
	 */
	@Autowired
	protected MessageService messageService;
	
	/**
	 * ModelMapper Instance to convert DTO to Entity and vice versa
	 */
	@Autowired
	protected ModelMapper modelMapper;
	
	/**
	 * Logger for handling exception messages printing and show current services in use.
	 */
	@Autowired
	protected Logger logger;
	
	/**
	 * method to log when a service is consumed and
	 * aldo the method inside that will be used.
	 * @param serviceConsumed
	 * @param methodName
	 */
	protected void LogServiceConsumed(String serviceConsumed, String methodName){
		this.logger.info("CONSUMIDO SERVIÇO - "+ serviceConsumed); 
		this.logger.info("MÉTODO UTILIZADO - "+ methodName);		
	}
	
	/**
	 * return the complete name of the class.
	 * @return
	 */
	protected String getClassName() {
		return this.getClass().getName();
	}
}
