package com.bilgeadam.service;

import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.repository.entity.Futbolcu;

import java.util.List;
import java.util.Optional;

public class FutbolcuService  implements ICrudService<Futbolcu>{

    FutbolcuRepository futbolcuRepository;

    public FutbolcuService() {
        this.futbolcuRepository = new FutbolcuRepository();
    }

    @Override
    public void save(Futbolcu futbolcu) {
        futbolcuRepository.save(futbolcu);
    }

    @Override
    public void update(Futbolcu futbolcu) {
        if (findbyId(futbolcu.getId()).isPresent()){
            futbolcuRepository.update(futbolcu);
        }

    }

    @Override
    public void delete(Long id) {
        if (findbyId(id).isPresent()){
            futbolcuRepository.delete(id);
        }
    }

    @Override
    public List<Futbolcu> findAll() {
        List<Futbolcu> futbolcular=futbolcuRepository.findAll();
        if (futbolcular.isEmpty()){
            System.out.println("Databesede veri bulunmamaktadır");
        }
        return futbolcular;
    }

    @Override
    public Optional<Futbolcu> findbyId(Long id) {
      Optional<Futbolcu> futbolcu=futbolcuRepository.findbyId(id);
            if (futbolcu.isEmpty()){
                System.out.println("Boyle bir futbolcu bulunamadı");
            }
        return futbolcu;
    }
}
