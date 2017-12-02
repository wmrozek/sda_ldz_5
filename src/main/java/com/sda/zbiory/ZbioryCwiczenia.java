package com.sda.zbiory;

import com.sda.model.Osoba;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ZbioryCwiczenia {
  public static void main(String[] args) {
    //    hashSetPrzyklad();
    Set<Osoba> osoby = new TreeSet<>();
    Osoba janKowalski = new Osoba("Jan", "Kowalski", 25);
    Osoba janKowalski2 = new Osoba("Jan", "Kowalski", 25);
    Osoba tomaszNowak = new Osoba("Tomasz", "Nowak", 30);
    Osoba tomaszNowak2 = new Osoba("Tomasz", "Żak", 23);
    System.out.println(osoby.add(janKowalski));
    System.out.println(osoby.add(janKowalski2));
    System.out.println(osoby.add(janKowalski2));
    System.out.println(osoby.add(tomaszNowak));
    System.out.println(osoby.add(tomaszNowak2));
    System.out.println(osoby);

  }

  private static void hashSetPrzyklad() {
    Set<Integer> zbior = new HashSet<>();
    zbior.add(2);
    zbior.add(5);
    zbior.add(8);
    zbior.add(2);
    zbior.add(2);
    System.out.println(zbior.add(3));
    System.out.println(zbior.add(3));
    System.out.println(zbior);
    zbior.remove(5);
    System.out.println(zbior);

    Iterator<Integer> iterator = zbior.iterator();
    while (iterator.hasNext()) {
      Integer value = iterator.next();
      System.out.println(value);
    }
  }
}
