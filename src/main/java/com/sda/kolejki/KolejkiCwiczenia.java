package com.sda.kolejki;

import com.sda.model.Osoba;
import com.sda.porownania.PorownywarkaOsob;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KolejkiCwiczenia {
  public static void main(String[] args) {
//    testKolejkaZwykla();
//    Comparator porownaniePrzezWiek = new PorownywarkaOsob();

    Comparator<Osoba> porownanieNazwisk = new Comparator<Osoba>() {
      @Override public int compare(Osoba o1, Osoba o2) {
        if (o1.getNazwisko().compareToIgnoreCase(o2.getNazwisko()) < 0){
          return -1;
        }else if (o1.getNazwisko().compareToIgnoreCase(o2.getNazwisko()) > 0){
          return 1;
        }else{
          return 0;
        }
      }
    };
    Queue<Osoba> kolejka = new PriorityQueue<>();
    kolejka.offer(new Osoba("Jan", "Kowalski", 18));
    kolejka.offer(new Osoba("Mariusz", "nowak", 40));
    kolejka.offer(new Osoba("Agnieszka", "kałamaj", 9));
    System.out.println(kolejka);
    System.out.println(kolejka.poll());
    System.out.println(kolejka.poll());
    System.out.println(kolejka.poll());


  }

  private static void testKolejkaZwykla() {
    Queue<String> kolejka = new PriorityQueue<String>();
    kolejka.offer("Element 1");
    kolejka.offer("Element 2");
    kolejka.offer("Element 3");
    System.out.println(kolejka);
    System.out.println(kolejka.peek()); //Pobieramy element, ale nie usuwamy z kolejki
    System.out.println(kolejka.peek());
    System.out.println(kolejka.poll()); //Pobieramy element i usuwamy z kolejki
    System.out.println(kolejka);
    System.out.println(kolejka.poll());
    System.out.println(kolejka);
    System.out.println(kolejka.poll());
    System.out.println(kolejka.poll()); //Jeśli kolejka jest pusta, dostajemy null
  }
}
