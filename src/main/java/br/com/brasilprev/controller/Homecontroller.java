package br.com.brasilprev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.Repository.ClienteRepository;
import br.com.brasilprev.dto.ClienteDto;
import br.com.brasilprev.model.Cliente;

@RestController
public class Homecontroller {
	@Autowired
	private ClienteRepository _clienteRepository;
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = "http://192.168.0.18:4200")	
	@RequestMapping("/clientes")
	public List<ClienteDto> home (String nome) 
	{
		List<Cliente>  lista =  
				IsNullOrEmpty(nome) ? _clienteRepository.findAll() : _clienteRepository.findBynome(nome) ;

		ClienteDto x = new ClienteDto();
		return x.convert(lista);	
	}

//	@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = "http://192.168.0.18:4200")	
	@RequestMapping(value = "/clientes",method = RequestMethod.POST)
	public Cliente NewCliente(@RequestBody ClienteDto cliente) {
		System.out.println("calling post url");
		ClienteDto x = new ClienteDto();
		return _clienteRepository.save(x.convertOne(cliente));
	}
	
	public boolean IsNullOrEmpty(String value_) {		
		return value_ == null  ? true : false;
	}
}

