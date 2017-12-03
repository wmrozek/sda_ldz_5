package com.sda.streamy;

import com.sda.csv.NarzedziaCsv;
import com.sda.model.Pracownik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PracownicyCwiczenia {
  public static void main(String[] args) {
    String sciezkaDoPliku = "E:/SDA/data.csv";
    List<Pracownik> pracownicy = NarzedziaCsv.czytajCsvZPliku(sciezkaDoPliku);
    System.out.println(pracownicy.size());
    System.out.println(pracownicy.get(0));

    //    //Wszyscy pracownicy, których nazwisko zaczyna się na literę C
    //    List<Pracownik> nazwiskaNaC = pracownicy.stream()
    //        .filter(pracownik -> pracownik.getNazwisko().startsWith("C"))
    //        .collect(Collectors.toList());
    //    System.out.println(nazwiskaNaC.size());
    //
    //    //Pracownicy po 50-tce jeżdżący BMW
    //    List<Pracownik> po50tceIBMW = pracownicy.stream()
    //        .filter(pracownik -> pracownik.getWiek()>50 && pracownik.getSamochod().getMarka().equalsIgnoreCase("bmw"))
    //        .collect(Collectors.toList());
    //    for (Pracownik pracownik : po50tceIBMW){
    //      System.out.println(String.format("%s %s %d %s",
    //          pracownik.getImie(), pracownik.getNazwisko(), pracownik.getWiek(), pracownik.getSamochod()));
    //    }
    //
    //    //Lista pracowników posortowana wg pensji (malejąco)
    //    List<Pracownik> posortowanaPoPensji = pracownicy.stream().sorted((o1, o2) -> o2.getPensja() - o1.getPensja())
    //        .collect(Collectors.toList());
    //
    //    for(Pracownik pracownik : posortowanaPoPensji){
    //      System.out.println(String.format("Nazwisko: %s, pensja: %d", pracownik.getNazwisko(), pracownik.getPensja()));
    //    }

    List<Pracownik> pierwsze10Pensji = pracownicy.stream().sorted(((o1, o2) -> o2.getPensja() - o1.getPensja()))
        .limit(10)
        .collect(Collectors.toList());
    for (Pracownik pracownik : pierwsze10Pensji) {
      System.out.println(String.format("Nazwisko: %s, pensja: %d", pracownik.getNazwisko(), pracownik.getPensja()));
    }

    List<Pracownik> pracownicyKopia = new ArrayList<>(pracownicy);
    pracownicyKopia.sort(new Comparator<Pracownik>() {
      @Override public int compare(Pracownik o1, Pracownik o2) {
        return o2.getPensja() - o1.getPensja();
      }
    });
    List<Pracownik> pierwsze10 = new ArrayList<>();
    for (int i=0;i<10;i++){
      pierwsze10.add(pracownicyKopia.get(i));
    }
    for (Pracownik pracownik : pierwsze10) {
      System.out.println(String.format("Nazwisko: %s, pensja: %d", pracownik.getNazwisko(), pracownik.getPensja()));
    }


  }
}
