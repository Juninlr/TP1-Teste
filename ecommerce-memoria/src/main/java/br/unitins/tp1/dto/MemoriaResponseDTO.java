package br.unitins.tp1.dto;

import br.unitins.tp1.model.Memoria;

public record MemoriaResponseDTO(
    Long id,
    String marca,
    String modelo,
    String gigas,
    String velocidade,
    Long fornecedorId
) {

    public static MemoriaResponseDTO fromEntity(Memoria memoria) {
        return new MemoriaResponseDTO(
            memoria.getId(),
            memoria.getMarca(),
            memoria.getModelo(),
            memoria.getGigas(),
            memoria.getVelocidade(),
            memoria.getFornecedor().getId()
        );
    }
}
