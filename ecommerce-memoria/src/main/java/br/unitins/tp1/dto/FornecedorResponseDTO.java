package br.unitins.tp1.dto;

import br.unitins.tp1.model.Fornecedor;

public record FornecedorResponseDTO(
        Long id,
        String nome,
        String cnpj,
        String telefone,
        String email) {

    public static FornecedorResponseDTO fromEntity(Fornecedor fornecedor) {
        return new FornecedorResponseDTO(
                fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getTelefone(),
                fornecedor.getEmail());
    }
}