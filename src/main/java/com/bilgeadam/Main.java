package com.bilgeadam;

import com.bilgeadam.controller.FutbolcuController;
import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    FutbolcuController futbolcuController;

    public Main() {
        this.futbolcuController = new FutbolcuController();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();

//        FutbolcuRepository futbolcuRepository=new FutbolcuRepository();
        // save işlemi
//        Futbolcu futbolcu1=new Futbolcu("Gokhan","Defans",3,1L);
//        futbolcuRepository.save(futbolcu1);
        // update işlemi
//        Futbolcu futbolcu=new Futbolcu("Mustafa Ozturk","Orta Saha",8,1000000L,1L);
//        futbolcu.setId(3L);
//       futbolcuRepository.update(futbolcu);

/*        Optional<Futbolcu> futbolcu=futbolcuRepository.findbyId(3L);
        if (futbolcu.isPresent()){
            System.out.println(futbolcu.get());
        }else{
            System.out.println("Boyle bir futbolcu bulunamadı");
        }*/
//        List<Futbolcu> futbolcular=futbolcuRepository.findAll();
//        futbolcular.forEach(System.out::println);
//        futbolcuRepository.delete(2L);
    }

    public void menu() {

        int input = 0;

        do {
            //ctrl+d bi altsatıra kopya olusturur
            System.out.println("1-Futbolcu olusutur");
            System.out.println("2-Futbolcu Guncelle");
            System.out.println("3-Futbolcu Sil");
            System.out.println("4-Futbolcu Bul");
            System.out.println("5-Futbolcuları Getir");
            System.out.println("Lütfen bir seçim yapınız");
            input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    futbolcuOlustur();
                    break;
                case 2:
                    futbolcuGuncelle();
                    break;
                case 3:
                    deleteFutbolcu();
                    break;
                case 4:
                    findFutbolcu();
                    break;
                case 5:
                    futbolcularıListele();
                    break;

            }


        } while (input != 0);


    }


    private  void futbolcuGuncelle(){
        System.out.println("Lütfen bir isim giriniz");
        String isim = scanner.nextLine();
        System.out.println("Lütfen bir mevki giriniz");
        String mevki = scanner.nextLine();
        System.out.println("Lütfen bir forma no giriniz");
        int formaNo = Integer.parseInt(scanner.nextLine());
        System.out.println("Lütfen bir takım id giriniz");
        Long takimId = Long.parseLong(scanner.nextLine());
        System.out.println("Lütfen futbolcunun degerini giriniz");
        Long deger = Long.parseLong(scanner.nextLine());
        System.out.println("Lütfen güncellemek istediğiniz futbolcunun idsini giriniz");
        Long id = Long.parseLong(scanner.nextLine());
        Futbolcu futbolcu = new Futbolcu(isim, mevki, formaNo,deger,takimId);
        futbolcu.setId(id);
        futbolcuController.update(futbolcu);
    }

    private void futbolcuOlustur() {
        System.out.println("Lütfen bir isim giriniz");
        String isim = scanner.nextLine();
        System.out.println("Lütfen bir mevki giriniz");
        String mevki = scanner.nextLine();
        System.out.println("Lütfen bir forma no giriniz");
        int formaNo = Integer.parseInt(scanner.nextLine());
        System.out.println("Lütfen bir takım id giriniz");
        Long takimId = Long.parseLong(scanner.nextLine());
        Futbolcu futbolcu = new Futbolcu(isim, mevki, formaNo, takimId);
        futbolcuController.save(futbolcu);
    }


    private void futbolcularıListele() {
        System.out.println("=====Futbolcu Listesi====");
        futbolcuController.findAll().forEach(System.out::println);
    }

    private void findFutbolcu() {
        System.out.println("Lütfen bir id giriniz");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println(futbolcuController.findbyId(id));
    }

    private void deleteFutbolcu() {
        System.out.println("Lütfen bir id giriniz");
        Long id = Long.parseLong(scanner.nextLine());
        futbolcuController.delete(id);
    }

}