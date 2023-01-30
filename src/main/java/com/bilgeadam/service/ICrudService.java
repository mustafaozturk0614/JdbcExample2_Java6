package com.bilgeadam.service;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T> {

    void save(T t);
    void update(T t);
    void delete(Long id);
    List<T> findAll();
    Optional<T> findbyId(Long id);

}
