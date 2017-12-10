package com.sda.wyszukiwanie;

import com.sda.sortowanie.Sortowanie;
import com.sda.sortowanie.SortowanieSzybkie;

public class WyszukiwanieBinarne implements Wyszukiwanie{

  private int[] tablicaDoPrzeszukania;
  private String nazwaWyszukiwarki;
  public int licznikWywolan = 0;

  public WyszukiwanieBinarne(int[] tablicaDoPrzeszukania, String nazwaWyszukiwarki) {
    this.tablicaDoPrzeszukania = tablicaDoPrzeszukania;
    this.nazwaWyszukiwarki = nazwaWyszukiwarki;
  }

  public WyszukiwanieBinarne() {
    this.nazwaWyszukiwarki = "Wyszukiwanie binarne";
  }

  public String getNazwaWyszukiwarki() {
    return nazwaWyszukiwarki;
  }

  @Override public int szukaj(int liczba, int[] tablica) {
    if(tablica == null || tablica.length==0){
      return -1;
    }
    licznikWywolan++;
    int szukanaLiczba;
    int przesuniecie = 0;
    int index = tablica.length/2;
    if (tablica[index] == liczba){
      return index;
    }else if(tablica[index] > liczba){
      int[] lewa = new int[index];
      for(int i=0;i<index;i++){
        lewa[i] = tablica[i];
      }
      szukanaLiczba = szukaj(liczba, lewa);
    }else{
      int[] prawa = new int[tablica.length-index-1];
      for(int i=index+1, j=0;i<tablica.length;i++,j++){
        prawa[j] = tablica[i];
      }
      przesuniecie = index+1;
      szukanaLiczba = szukaj(liczba, prawa);
      if (szukanaLiczba !=-1){
        szukanaLiczba += przesuniecie;
      }
    }
    return szukanaLiczba;
  }

  @Override public int szukaj(int liczba) {
    return szukaj(liczba, tablicaDoPrzeszukania);
  }

  @Override public int getLicznikWywolan() {
    return licznikWywolan;
  }

  public static void main(String[] args) {
    int[] tablica = {5,16,5,4,65,46,13,168,43,86,43,8,4,513,43,8,4};
    Sortowanie sortowanie = new SortowanieSzybkie();
    tablica = sortowanie.sortuj(tablica);
    for (int element : tablica){
      System.out.print(element + " ");
    }
    System.out.println();
    Wyszukiwanie naiwne = new WyszukiwanieBinarne();
    System.out.println(naiwne.szukaj(168, tablica));
  }
}
