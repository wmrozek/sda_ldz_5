package com.sda;

import com.sda.zadanie4.Adres;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zadanie5{
  public static void main(String[] args) {
    List<Adres> lista = new ArrayList<>();
    lista.add(new Adres("Warszawa", "Piłsudskiego", "00000", 12));
    lista.add(new Adres("Warszawa", "Piłsudskiego", "00000", 13));
    lista.add(new Adres("Warszawa", "Piłsudskiego", "00000", 14));
    lista.add(new Adres("Warszawa", "Piłsudskiego", "00000", 15));
    lista.add(new Adres("Warszawa", "Piłsudskiego", "00000", 16));
    lista.add(new Adres("Kraków", "Piłsudskiego", "00000", 12));
    lista.add(new Adres("Kraków", "Piłsudskiego", "00000", 13));
    lista.add(new Adres("Poznań", "Piłsudskiego", "00000", 14));
    lista.add(new Adres("Poznań", "Piłsudskiego", "00000", 15));
    lista.add(new Adres("Warszawa", "Piłsudskiego", "00000", 16));
    System.out.println(lista.size());

    Set<Adres> adresy = new HashSet<>(lista);
    System.out.println(adresy.size());
    for (Adres adres : adresy){
      System.out.println(adres.getMiejscowosc());
    }


  }
}
