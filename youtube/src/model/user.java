package model;

import java.util.ArrayList;
import java.util.List;

public class user {

	private String mail;
	private String pass;
	private String name;
	private List<Error> errors;

	// Constructor para validar
	public user(String mail, String pass) {
		super();
		this.mail = mail;
		this.pass = pass;
		errors = new ArrayList<Error>();
	}

	// Constructor para ya validado
	public user(String mail, String pass, String name) {
		super();
		this.mail = mail;
		this.pass = pass;
		this.name = name;
		errors = new ArrayList<Error>();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addError(Error error) {
		errors.add(error);
	}

	public boolean errorExist() {
		return !errors.isEmpty();
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	
}