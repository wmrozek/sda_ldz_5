package com.sda.streamy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamyCwiczenia {
  public static void main(String[] args) {
    List<Integer> liczby = new ArrayList<>();
    for (int i=1;i<=100;i++){
      liczby.add(i);
    }
    System.out.println(liczby);
    System.out.println("Podzielne przez 3:");
    List<Integer> podzielnePrzez3 = new ArrayList<>();
    for (Integer liczba : liczby){
      if (liczba%3 == 0){
        podzielnePrzez3.add(liczba);
      }
    }
    System.out.println(podzielnePrzez3);
    List<Integer> podzielnePrzez3Stream = liczby.stream()
        .filter(liczba -> liczba%3 == 0)
        .collect(Collectors.toList());
    System.out.println(podzielnePrzez3Stream);

    //podzielne przez 3 i podzielne przez 5 -> zwracamy te liczby pomnożone przez 9
    List<Integer> wyniki = new ArrayList<>();
    for (Integer liczba : liczby){
      if (liczba%3 == 0 && liczba%5 ==0){
        wyniki.add(liczba*9);
      }
    }
    System.out.println(wyniki);
    List<Integer> wynikiStream = liczby.stream()
        .filter(liczba -> liczba%3 == 0) //.filter(liczba -> liczba%3 == 0 && liczba%5 == 0)
        .filter(liczba -> liczba%5 == 0)
        .map(liczba -> liczba*9)
        .collect(Collectors.toList());
    System.out.println(wynikiStream);


    String tekst = "adfsdfwf";
    tekst.trim().substring(0,5).trim().substring(0);

  }
}
