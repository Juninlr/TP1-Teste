package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped 
public class FornecedorServiceImpl implements FornecedorService {
    
    @Inject
    FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public Fornecedor create(Fornecedor fornecedor) {
        fornecedorRepository.persist(fornecedor);
        return fornecedor;
    }

    @Override
    @Transactional
    public void update(Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorBanco = findById(id);
        fornecedorBanco.setNome(fornecedor.getNome());
        fornecedorBanco.setCnpj(fornecedor.getCnpj());
        fornecedorBanco.setTelefone(fornecedor.getTelefone());
        fornecedorBanco.setEmail(fornecedor.getEmail());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!fornecedorRepository.deleteById(id)) {
            throw new NotFoundException("Fornecedor não encontrado");
        }
    }

    @Override
    public Fornecedor findById(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        if (fornecedor == null) {
            throw new NotFoundException("Fornecedor não encontrado");
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> findAll() {
        return fornecedorRepository.listAll();
    }

}
