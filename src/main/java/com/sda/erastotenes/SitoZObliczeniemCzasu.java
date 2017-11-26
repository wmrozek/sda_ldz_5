package com.sda.erastotenes;

public class SitoZObliczeniemCzasu {
  public static void main(String[] args) {
    int iloscElementow = 100000000;
    boolean[] tablicaBoolean = new boolean[iloscElementow + 1];
    long start = System.currentTimeMillis();
    tablicaBoolean = sitoBoolean(tablicaBoolean);
    long end = System.currentTimeMillis();
//    for (int i = 1; i < tablicaBoolean.length; i++) {
//      if (!tablicaBoolean[i]) {
//        System.out.print(i + " ");
//      }
//    }
    System.out.println();
    int[] tablicaInt = new int[iloscElementow];
    for (int i = 0; i < iloscElementow; i++) {
      tablicaInt[i] = i + 1;
    }
    long start2 = System.currentTimeMillis();
    tablicaInt = sitoInteger(tablicaInt);
    long end2 = System.currentTimeMillis();
//    for (int element : tablicaInt) {
//      if (element != -1) {
//        System.out.print(element + " ");
//      }
//    }
    System.out.println();
    System.out.println("BOOLEAN: " + (end - start));
    System.out.println("Integer: " + (end2 - start2));
  }

  public static boolean[] sitoBoolean(boolean[] tablica) {

    //Obliczanie sita
    for (int start = 2; start < tablica.length; start++) {
      if (tablica[start]) { //if (tablica[start] == true)
        continue;
      }
      for (int wielokrotnosc = 2 * start; wielokrotnosc < tablica.length; wielokrotnosc += start) {
        tablica[wielokrotnosc] = true;
      }
    }
    return tablica;


  }

  public static int[] sitoInteger(int[] tablica) {


    //Obliczanie sita
    for (int start = 2; start < tablica.length; start++) {
      if (tablica[start - 1] == -1) {
        continue;
      }
      for (int wielokrotnosc = 2 * start; wielokrotnosc <= tablica.length; wielokrotnosc += start) {
        tablica[wielokrotnosc - 1] = -1;
      }
    }
    return tablica;

  }


}
