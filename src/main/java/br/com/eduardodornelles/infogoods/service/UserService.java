package br.com.eduardodornelles.infogoods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.eduardodornelles.infogoods.domain.Messages;
import br.com.eduardodornelles.infogoods.domain.Parameters;
import br.com.eduardodornelles.infogoods.dto.HttpResponseDTO;
import br.com.eduardodornelles.infogoods.dto.UserDTO;
import br.com.eduardodornelles.infogoods.entity.User;
import br.com.eduardodornelles.infogoods.utility.ValidationUtils;

/**
 * class that have method related to services concerning users
 * 
 * @author Eduardo Dornelles
 */
@Service
public class UserService extends AbstractService {



	/**
	 * retrieve a user from database based on its email and password.
	 * 
	 * @param email
	 * @param password
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO getUser(final String email, final String password) {
		HttpResponseDTO response = new HttpResponseDTO();

		User user = userDao.findByEmailAndSenha(email, password);

		if (user != null) {
			UserDTO userDTO = modelMapper.map(user, UserDTO.class);
			response.setSuccess(true);
			response.addContent("user", userDTO);
			return response;
		} else {
			response.addMessage(this.messageService.getMessageDTOByCode(Messages.A001));
			response.setSuccess(false);
			return response;
		}
	}

	/**
	 * register an user on database.
	 * 
	 * @param user
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO registerUser(final User user) {
		HttpResponseDTO response = new HttpResponseDTO();
		String errorMessage = ValidationUtils.validateUserFields(user);

		if (errorMessage.equals(Parameters.AUTHORIZED)) {			
			userDao.save(user);
			response.setSuccess(true);
			response.addMessage(this.messageService.getMessageDTOByCode(Messages.A002));
		} else {
			response.setSuccess(false);
			response.addMessage(this.messageService.getMessageDTOByCode(errorMessage));
		}
		return response;
	}

}
