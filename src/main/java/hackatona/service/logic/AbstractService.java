package hackatona.service.logic;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import hackatona.utility.ObjectMapperUtils;
/**
 * Abstract class containing the Daos and 
 * other things useful to all services classes. 
 * @author Eduardo Dornelles
 *
 */
public class AbstractService {
	
	@Autowired
	protected ObjectMapperUtils mapper;
	
	@Autowired
	protected Logger logger;
	
	/**
	 * method to log when a service is consumed and
	 * also the method inside that will be used.
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
