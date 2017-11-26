package com.sda.fibonacci;

import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj ile elementów ciągu chcesz obliczyć: ");
    String iloscElementowString = scanner.nextLine();
    try{
      Integer iloscElementow = Integer.parseInt(iloscElementowString);
      //Wyznaczanie elementów ciągu
      Integer liczbaNMinus1 = 1;
      Integer liczbaNMinus2 = 0;
      String wynikDoWyswietlenia = "%d element ciągu: %d";
      for (int i=0;i<iloscElementow;i++){
        if (i == 0){
          System.out.println(String.format(wynikDoWyswietlenia, i, 0));
        }else if (i==1){
          System.out.println(String.format(wynikDoWyswietlenia, i, 1));
        }else{
          Integer wynik = liczbaNMinus1 + liczbaNMinus2;
          System.out.println(String.format(wynikDoWyswietlenia, i, wynik));
          liczbaNMinus2 = liczbaNMinus1;
          liczbaNMinus1 = wynik;
        }
      }
    }catch (NumberFormatException e){
      System.out.println("Niepoprawna ilość elementów.");
      return;
    }
  }
}
