package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Memoria;

public interface MemoriaService {
    Memoria create(Memoria memoria);
    void update(Long id, Memoria memoria);
    void delete(Long id);
    Memoria findById(Long id);
    List<Memoria> findByMarca(String marca);
    List<Memoria> findByModelo(String modelo);
    List<Memoria> findByGigas(String gigas);
    List<Memoria> findByVelocidade(String velocidade);
    List<Memoria> findAll();
}
