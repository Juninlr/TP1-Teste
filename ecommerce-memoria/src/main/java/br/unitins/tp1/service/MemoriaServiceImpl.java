package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Memoria;
import br.unitins.tp1.repository.MemoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MemoriaServiceImpl implements MemoriaService {

    @Inject
    MemoriaRepository repository;

    @Override
    @Transactional
    public Memoria create(Memoria memoria) {
        repository.persist(memoria);
        return memoria;
    }

    @Override
    @Transactional
    public void update(Long id, Memoria memoria) {
        Memoria memoriaBanco = repository.findById(id);
        if (memoriaBanco == null) {
            throw new RuntimeException("Memoria não encontrada");
        }
        memoriaBanco.setMarca(memoria.getMarca());
        memoriaBanco.setModelo(memoria.getModelo());
        memoriaBanco.setGigas(memoria.getGigas());
        memoriaBanco.setVelocidade(memoria.getVelocidade());
        memoriaBanco.setFornecedor(memoria.getFornecedor());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Memoria findById(Long id) {
       return repository.findById(id);
    }

    @Override
    public List<Memoria> findByMarca(String marca) {
        return repository.findByMarca(marca);
    }

    @Override
    public List<Memoria> findByModelo(String modelo) {
        return repository.findByModelo(modelo);
    }

    @Override
    public List<Memoria> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Memoria> findByGigas(String gigas) {
        return repository.findByGigas(gigas);
    }

    @Override
    public List<Memoria> findByVelocidade(String velocidade) {
        return repository.findByVelocidade(velocidade);
    }
    
}
