package com.mk.mnx.crUser.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mk.mnx.crUser.repository.PersonRepository;
import com.mk.mnx.crUser.repository.UserRepository;
import com.mk.mnx.infr.service.BaseService;
import com.mk.mnx.model.domain.Person;
import com.mk.mnx.model.domain.RandomUserResponse;
import com.mk.mnx.model.domain.User;

@Service
public class CrearUsuarioService extends BaseService{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${random.user.api}")
	private String RANDOM_USER_URL;
	
	private RestTemplate restTemplate;
	
	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
	}

	private Person descargaPersona() {
		RandomUserResponse rnd = restTemplate.getForObject(RANDOM_USER_URL, RandomUserResponse.class);
		return rnd.getResults().get(0);
	}
	
	
	public Person creaPersona()
	{
		Person p  = descargaPersona();
		
		User u = new User();
		u.setUserName(p.getLogin().getUsername());
		u.setPassword(p.getLogin().getMd5());
		u.setCreation(new Date());
		u.setSalt(p.getLogin().getSalt());
		u=userRepository.insert(u);
		p=personRepository.insert(p);
	
		logger.debug("[{}]",u);
		logger.debug("[{}]",p);
		return p;
	}
	
	
	
}
