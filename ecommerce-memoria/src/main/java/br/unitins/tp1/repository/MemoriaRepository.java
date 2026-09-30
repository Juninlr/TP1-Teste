package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Memoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MemoriaRepository implements PanacheRepository<Memoria> {
    public List<Memoria> findByMarca(String marca) {
        // return find("SELECT e FROM Memoria e WHERE e.marca LIKE ?", marca).list();
        return find("upper(marca) LIKE upper(?1)", "%" + marca + "%").list();
    }

    public List<Memoria> findByModelo(String modelo) {
        // return find("SELECT e FROM Memoria e WHERE e.modelo LIKE ?", modelo).list();
        return find("upper(modelo) LIKE upper(?1)", "%" + modelo + "%").list();
    }

    public List<Memoria> findByGigas(String gigas) {
        // return find("SELECT e FROM Memoria e WHERE e.gigas LIKE ?", gigas).list();
        return find("upper(gigas) LIKE upper(?1)", "%" + gigas + "%").list();
    }

    public List<Memoria> findByVelocidade(String velocidade) {
        // return find("SELECT e FROM Memoria e WHERE e.velocidade LIKE ?", velocidade).list();
        return find("upper(velocidade) LIKE upper(?1)", "%" + velocidade + "%").list();
    }
}
