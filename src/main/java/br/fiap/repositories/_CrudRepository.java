package br.fiap.repositories;

import java.util.List;
import java.util.Optional;

public interface _CrudRepository<T> {

    void add(T object);
    // remoção fisica
    boolean remove(T object);
    boolean removeById(int id);

    // remoção logica
    boolean delete(T object);
    boolean deleteById(int id);

    void update(T object);

    // traz tudo idependente do status
    List<T> getAll();

    // busca não considera os itens deletados
    List<T> get();
    Optional<T> getById(int id);

}
