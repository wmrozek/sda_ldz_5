package com.sda.zadanie4;

import com.sda.model.Osoba;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Zadanie4 {
  public static void main(String[] args) {
    Osoba osoba = new Osoba("a", "b", 22);
    typKlasy(osoba);
    List<KryteriumSortujace> kryteria = new ArrayList<>();
    kryteria.add(KryteriumSortujace.ULICA);
    kryteria.add(KryteriumSortujace.MIEJSCOWOSC);
    kryteria.add(KryteriumSortujace.NR_BUDYNKU);
    Queue<Adres> kolejka = new PriorityQueue<Adres>(new PorownywarkaAdresow(Porzadek.MALEJACO, kryteria));
    kolejka.offer(new Adres("Warszawa", "Mickiewicza", "00-000", 15));
    kolejka.offer(new Adres("Kraków", "Rojna", "00-000", 25));
    kolejka.offer(new Adres("Warszawa", "Wici", "00-000", 50));
    kolejka.offer(new Adres("Warszawa", "Politechniki", "00-000", 5));
    kolejka.offer(new Adres("Poznań", "Mickiewicza", "00-000", 10));
    kolejka.offer(new Adres("Warszawa", "Politechniki", "00-000", 20));

    while(!kolejka.isEmpty()){
      System.out.println(kolejka.poll());
    }

//    System.out.println(kolejka.poll());
//    System.out.println(kolejka.poll());
//    System.out.println(kolejka.poll());
//    System.out.println(kolejka.poll());
//    System.out.println(kolejka.poll());
//    System.out.println(kolejka.poll());
  }


  public static void typKlasy(Object obj){
    System.out.println(obj.getClass());
  }
}
