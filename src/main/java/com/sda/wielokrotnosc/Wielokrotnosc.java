package com.sda.wielokrotnosc;

import java.util.Scanner;

public class Wielokrotnosc {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj pierwszą liczbę: ");
    String liczbaPodstawowaString = scanner.nextLine();
    try{
      Integer liczbaPodstawowa = Integer.parseInt(liczbaPodstawowaString);
      System.out.println("Ile wielokrotności wyświetlić?");
      //Równoważne:
      //String iloscWielokrotnosci = scanner.nextLine();
      //Integer wielokrotnosc = Integer.parseInt(iloscWielokrotnosci);
      Integer wielokrotnosc = Integer.parseInt(scanner.nextLine());
      if (wielokrotnosc <= 0){
        System.out.println("Niepoprawna liczba wielokrotności");
        return;
      }else{
        System.out.println(String.format("Mając podaną liczbę %d i ilość wielokrotności %d wyniki są następujące: ", liczbaPodstawowa, wielokrotnosc));
        for (int i=1;i<=wielokrotnosc;i++){
          System.out.println(liczbaPodstawowa*i);
        }
      }

    }catch(NumberFormatException e){
      System.out.println("Wystąpił błąd.");
      return;
    }
  }

}
