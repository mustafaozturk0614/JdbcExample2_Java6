package com.bilgeadam;

import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;

public class Main {
    public static void main(String[] args) {

        FutbolcuRepository futbolcuRepository=new FutbolcuRepository();
        Futbolcu futbolcu=new Futbolcu("Mustafa","Orta Saha",7,1L);
        futbolcuRepository.save(futbolcu);

    }
}