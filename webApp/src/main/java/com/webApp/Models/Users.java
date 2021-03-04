package com.webApp.Models;

import javax.persistence.Id;

public class Users {
	
	@Id
	private int id;
	private String name;
	private String login;
	private String pass;
	private String pass_alt;
	private String mail;
	
	public Users() {
		super();
	}

	//INSERT INTO
	public Users(int id, String name, String login, String pass, String pass_alt, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.pass = pass;
		this.pass_alt = pass_alt;
		this.mail = mail;
	}
		
	//RECUPERAR PASSWORD
	public Users( String pass, String pass_alt, String login) {
		this.pass = pass;
		this.pass_alt = pass_alt;
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass_alt() {
		return pass_alt;
	}

	public void setPass_alt(String pass_alt) {
		this.pass_alt = pass_alt;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	
	
	
}
