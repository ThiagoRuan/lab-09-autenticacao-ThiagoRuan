package br.ufpb.dcx.dsc.repositorios.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {
    @NotBlank
    private String userName;
    @NotBlank
    private String senha;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
