package br.unitins.tp1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FornecedorDTO(
        @NotBlank(message = "O nome deve ser informado")
        String nome,
        @NotBlank(message = "O CNPJ deve ser informado")
        String cnpj,
        @NotBlank(message = "O telefone deve ser informado")
        String telefone,
        @NotBlank(message = "O e-mail deve ser informado")
        @Email(message = "O e-mail informado é inválido")
        String email) {
}