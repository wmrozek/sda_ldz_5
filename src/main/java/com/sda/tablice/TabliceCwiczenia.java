package com.sda.tablice;

public class TabliceCwiczenia {
  public static void main(String[] args) {
    //Deklaracje tablic
    int[] tablica = new int[10];
    int[] tablica2 = new int[]{3,45,7,5,76,3,2,5,63,23};
    int[] tablica3 = {231,4356,456,345,6456,234,234};
    //Wstawianie wartości
    tablica[0] = 2;
    tablica[5] = 53;
    tablica[2] = tablica[1];
    for(int i=0; i<tablica.length;i++){
      tablica[i] = 30;
    }
    System.out.println(tablica[0]);
    System.out.println(tablica[0]);


  }
}
