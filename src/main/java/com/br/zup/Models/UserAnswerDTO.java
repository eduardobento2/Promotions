package com.br.zup.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserAnswerDTO {
	private Integer id;
	private String nome;
	private String email;
	private boolean admin;
		
	public UserAnswerDTO(Integer id, String nome, String email, boolean admin) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public static UserAnswerDTO transformaEmDTO(UserAdmin user) {
		return  new UserAnswerDTO(user.getId(), user.getName(), user.getEmail(),user.getAdmin());
}
}