package com.sda.erastotenes;

public class Sito {
  public static void main(String[] args) {
    int iloscElementow = 1000;
    sitoBoolean(iloscElementow);
    System.out.println();
    sitoInteger(iloscElementow);
  }

  public static void sitoBoolean(int rozmiarTablicy){
    boolean[] tablica = new boolean[rozmiarTablicy+1];
    //Obliczanie sita
    for (int start=2; start<tablica.length;start++){
      if (tablica[start]){ //if (tablica[start] == true)
        continue;
      }
      for(int wielokrotnosc = 2*start;wielokrotnosc<tablica.length;wielokrotnosc += start){
        tablica[wielokrotnosc] = true;
      }
    }

    for (int i = 1; i<tablica.length;i++){
      if (!tablica[i]){
        System.out.print(i+" ");
      }
    }

  }

  public static void sitoInteger(int rozmiarTablicy){
    int[] tablica = new int[rozmiarTablicy];
    for(int i=0;i<rozmiarTablicy;i++){
      tablica[i] = i+1;
    }

    //Obliczanie sita
    for(int start = 2;start<tablica.length;start++){
      if(tablica[start-1] == -1){
        continue;
      }
      for(int wielokrotnosc = 2*start; wielokrotnosc<=tablica.length;wielokrotnosc += start){
        tablica[wielokrotnosc-1] = -1;
      }
    }

    for(int element : tablica){
      if (element != -1){
        System.out.print(element+" ");
      }
    }
  }


}
