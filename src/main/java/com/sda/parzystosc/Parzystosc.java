package com.sda.parzystosc;

import java.util.Scanner;

public class Parzystosc {
  public static void main(String[] args) {
    //1. Pobieramy liczbę od użytkownika
    System.out.println("Podaj liczbę: ");
    Scanner scanner = new Scanner(System.in);
    String liczbaString = scanner.nextLine();
    try{
      Integer liczba = Integer.parseInt(liczbaString);
      //2. Sprawdzamy, czy jest podzielna przez 2 - warunek parzystości
      if (liczba%2 == 0){
        System.out.println("Podana liczba jest parzysta");
      }else{
        System.out.println("Podana liczba jest nieparzysta");
      }
    }catch(NumberFormatException e){
      System.out.println("Podałeś niepoprawną liczbę - program zakończy pracę.");
      return;
    }
  }
}
