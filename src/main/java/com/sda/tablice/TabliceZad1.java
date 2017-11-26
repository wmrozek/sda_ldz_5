package com.sda.tablice;

public class TabliceZad1 {
  public static void main(String[] args) {
    int[] tablica = new int[10];
    //Uzupełniamy kolejno
    for(int i=0;i<tablica.length;i++){
      tablica[i] = i+1;
    }
    wyswietlTablice(tablica);
    //Zwiększenie co 3 liczby wartością poprzednika
    for(int i=2;i<tablica.length;i=i+3){ //i += 3
      tablica[i] += tablica[i-1];
    }
    wyswietlTablice(tablica);
    //Każdą parzystą dzielimy przez 2
    for(int i=0;i<tablica.length;i++){
      if(tablica[i]%2 == 0){
        tablica[i] /= 2; //tablica[i] = tablica[i] / 2;
      }
    }
    wyswietlTablice(tablica);
    //Wyświetlamy sumę
    int suma = 0;
    for (int element : tablica){
      suma += element;
    }
    System.out.println("SUMA: "+suma);
  }

  public static void wyswietlTablice(int[] tab){
    for (int i=0;i<tab.length;i++){
      System.out.print(tab[i]+" ");
    }
    System.out.println("===================");
  }
}
