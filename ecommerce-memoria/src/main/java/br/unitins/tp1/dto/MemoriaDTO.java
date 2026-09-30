package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MemoriaDTO(
        @NotBlank(message = "A Marca deve ser informada")
        @Size(min = 5,max = 20, message = "O nome da marca deve conter no mínimo 5 e no máximo 20 caracteres")
        String marca,
        @NotBlank(message = "O modelo deve ser informado")
        @Size(max = 6, message = "O modelo deve conter no máximo 6 caracteres")
        String modelo,
        @NotBlank(message = "Quantidade de GBytes deve ser informada")
        @Size(max = 8, message = "A quantidade de gigas deve conter no máximo 8 caracteres")
        String gigas,
        @NotBlank(message = "A velocidade de Mhz deve ser informada")
        @Size(min = 5,max = 20, message = "A informação da velocidade deve conter no mínimo 5 e no máximo 20 caracteres")
        String velocidade,

        @NotNull(message = "O fornecedor deve ser informado")
        Long fornecedorId
    ) {
}
