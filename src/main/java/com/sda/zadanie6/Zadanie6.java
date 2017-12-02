package com.sda.zadanie6;

import com.sda.model.Osoba;
import com.sda.porownania.PorownywarkaOsob;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Zadanie6 {
  public static void main(String[] args) {
    Map<String, Osoba> osoby = new HashMap<>();
    Osoba osoba1 = new Osoba("Jan", "Kowalski", 11, "9090909090");
    Osoba osoba2 = new Osoba("Jan", "Nowak", 25, "9090909091");
    Osoba osoba3 = new Osoba("Jan", "Nowak", 28, "9090909092");
    Osoba osoba4 = new Osoba("Jan", "Kowalski1", 15, "9090909093");
    Osoba osoba5 = new Osoba("Jan", "Kowalski2", 25, "9090909094");
    Osoba osoba6 = new Osoba("Jan", "Kowalski3", 35, "9090909095");
    Osoba osoba7 = new Osoba("Jan", "Kowalski4", 8, "9090909096");
    Osoba osoba8 = new Osoba("Jan", "Kowalski5", 110, "9090909097");
    osoby.put(osoba1.getPesel(), osoba1);
    osoby.put(osoba2.getPesel(), osoba2);
    osoby.put(osoba3.getPesel(), osoba3);
    osoby.put(osoba4.getPesel(), osoba4);
    osoby.put(osoba5.getPesel(), osoba5);
    osoby.put(osoba6.getPesel(), osoba6);
    osoby.put(osoba7.getPesel(), osoba7);
    osoby.put(osoba8.getPesel(), osoba8);
    System.out.println(osoby);

    //Starsze niż 25 lat
    for (Osoba osoba : osoby.values()){
      if(osoba.getWiek()>25){
        System.out.println(osoba);
      }
    }
    System.out.println("------------------------");
    for (Osoba osoba : osoby.values()){
      if (osoba.getNazwisko().equals("Nowak") || osoba.getNazwisko().equals("Kowalski")){
        System.out.println(osoba);
      }
    }
    System.out.println("----------------");

    System.out.println(osoby
        .values()
        .stream()
        .filter(osoba -> osoba.getNazwisko().equals("Nowak") || osoba.getNazwisko().equals("Kowalski"))
        .collect(Collectors.toList()));



    System.out.println("----------------");
    Set<Osoba> set = new TreeSet<>(new PorownywarkaOsob());
    set.addAll(osoby.values());
    for (Osoba osoba : set){
      System.out.println(osoba);
    }

  }
}
