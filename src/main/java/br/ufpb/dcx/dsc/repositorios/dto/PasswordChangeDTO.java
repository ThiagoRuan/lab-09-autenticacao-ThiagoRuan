package br.ufpb.dcx.dsc.repositorios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PasswordChangeDTO {
    @NotBlank
    private String nome;
    @NotBlank(message = "Preencha com sua senha anterior.")
    private String oldPassword;
    @NotBlank(message = "Preencha com sua nova senha.")
    @Size(min = 6, message = "A nova senha precisa possuir no mínimo 6 (seis) caracteres.")
    private String newPassword;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
