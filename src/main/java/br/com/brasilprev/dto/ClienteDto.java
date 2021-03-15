package br.com.brasilprev.dto;
import java.util.ArrayList;
import java.util.List;

import br.com.brasilprev.model.Cliente;

public class ClienteDto {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneCom() {
		return telefoneCom;
	}

	public void setTelefoneCom(String telefoneCom) {
		this.telefoneCom = telefoneCom;
	}

	public String getTelefoneCel() {
		return telefoneCel;
	}

	public void setTelefoneCel(String telefoneCel) {
		this.telefoneCel = telefoneCel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	private int id;
	private String nome;
	private String email;
	private String telefoneCom;
	private String telefoneCel;
	private String endereco;


	public Cliente convertOne(ClienteDto cliente) {

		Cliente cli = new Cliente();
		cli.setEmail(cliente.getEmail());
		cli.setEndereco(cliente.getEndereco());
		cli.setId(cliente.getId());
		cli.setNome(cliente.getNome());
		cli.setTelefoneCel(cliente.getTelefoneCel());
		cli.setTelefoneCom(cliente.getTelefoneCom());		
		return cli;
	}



public List<ClienteDto> convert(List<Cliente> clientes) {

	ClienteDto cli;
	List<ClienteDto> newlist = new ArrayList<>();

	for (Cliente cliente : clientes) {
		cli = new ClienteDto();
		cli.email = cliente.getEmail();
		cli.endereco = cliente.getEndereco();
		cli.id = cliente.getId();
		cli.nome = cliente.getNome();
		cli.telefoneCel = cliente.getTelefoneCel();
		cli.telefoneCom = cliente.getTelefoneCom();
		newlist.add(cli);
	}
	//		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	return newlist;
}
}
