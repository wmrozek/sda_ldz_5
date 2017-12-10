package com.sda.wyszukiwanie;

import com.sda.sortowanie.Sortowanie;
import com.sda.sortowanie.SortowanieSzybkie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wyszukiwarka {
  public static void main(String[] args) {
    Random random = new Random();

    int[] tablica = new int[50000];
    int[] kopia = new int[50000];

    for (int i=0;i<tablica.length;i++){
      int liczba = random.nextInt(1000);
      tablica[i] = liczba;
      kopia[i] = liczba;
    }

    Sortowanie sortowanie = new SortowanieSzybkie();
    int[] tablicaPosortowana = sortowanie.sortuj(kopia);

    //3 TESTY:
    //1: Czas wyszukania liczby za pomocą wyszukiwania naiwnego po nieposortowanej tablicy
    //2: j.w tylko z posortowaną tablicą
    //3: Za pomocą wyszukiwania binarnego
    Wyszukiwanie naiwneBezSortowania = new WyszukiwanieNaiwne(tablica, "Naiwne bez sortowania");
    Wyszukiwanie naiwneZSortowaniem = new WyszukiwanieNaiwne(tablicaPosortowana, "Naiwne z sortowaniem");
    Wyszukiwanie binarne= new WyszukiwanieBinarne(tablicaPosortowana, "Binarne");
    List<Wyszukiwanie> wyszukiwarki = new ArrayList<>();
    wyszukiwarki.add(naiwneBezSortowania);
    wyszukiwarki.add(naiwneZSortowaniem);
    wyszukiwarki.add(binarne);

    for(Wyszukiwanie wyszukiwarka : wyszukiwarki){
      long start = System.currentTimeMillis();
      int index = wyszukiwarka.szukaj(50);
      long end = System.currentTimeMillis();
      System.out.println(wyszukiwarka.getNazwaWyszukiwarki());
      System.out.println("Znaleziony index: "+index);
      System.out.println("Czas wykonania: "+(end - start));
      System.out.println("Ilość operacji porównania: "+wyszukiwarka.getLicznikWywolan());
    }


  }
}
