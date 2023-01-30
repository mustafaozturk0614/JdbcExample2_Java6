package com.bilgeadam.controller;

import com.bilgeadam.repository.ICrud;
import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.service.FutbolcuService;

import java.util.List;
import java.util.Optional;

public class FutbolcuController implements ICrud <Futbolcu > {


    FutbolcuService futbolcuService;

    public FutbolcuController() {
        this.futbolcuService = new FutbolcuService();
    }

    @Override
    public void save(Futbolcu futbolcu) {
            futbolcuService.save(futbolcu);
    }

    @Override
    public void update(Futbolcu futbolcu) {
            futbolcuService.update(futbolcu);
    }

    @Override
    public void delete(Long id) {
        futbolcuService.delete(id);
    }

    @Override
    public List<Futbolcu> findAll() {
        return  futbolcuService.findAll();
    }

    @Override
    public Optional<Futbolcu> findbyId(Long id) {
        return futbolcuService.findbyId(id);
    }
}
