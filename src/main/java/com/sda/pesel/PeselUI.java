package com.sda.pesel;

import java.util.Scanner;

public class PeselUI {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj numer PESEL");
    String pesel = scanner.nextLine();
//    -----------------------------------
    PeselWynikiWeryfikacji wyniki = PeselWeryfikator.sprawdzPesel(pesel);
    if (wyniki.isPeselPrawidlowy()){
      System.out.println("Wprowadzony numer PESEL jest prawidłowy.");
      System.out.println("Data urodzenia: "+wyniki.getDataUrodzenia());
      System.out.println("Płeć: "+wyniki.getPlec());
    }else{
      System.out.println("Wprowadzony numer PESEL jest nieprawidłowy");
    }
  }
}
