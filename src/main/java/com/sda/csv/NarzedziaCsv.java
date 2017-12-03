package com.sda.csv;

import com.sda.model.Plec;
import com.sda.model.Pracownik;
import com.sda.model.Samochod;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NarzedziaCsv {
  public static List<Pracownik> czytajCsvZPliku(String sciezkaDoPliku){
    List<Pracownik> pracownicy = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader(sciezkaDoPliku))){
      String linia = reader.readLine();
      String[] naglowki = null;
      while (linia != null){
        if (naglowki == null){
          naglowki = linia.split(";");
        }else{
          String[] wiersz = linia.split(";");
          if (wiersz.length != 13){
            System.out.println("Nieprawidłowy wiersz: "+linia);
            linia = reader.readLine();
            continue;
          }
          Pracownik pracownik = new Pracownik();
          ustawPlecPracownika(wiersz[0], pracownik);
          pracownik.setImie(wiersz[1]);
          pracownik.setNazwisko(wiersz[2]);
          pracownik.setAdres(wiersz[3]);
          pracownik.setMiejscowosc(wiersz[4]);
          pracownik.setKodPocztowy(wiersz[5]);
          pracownik.setPrzegladarka(wiersz[6]);
          LocalDate dataUrodzenia = getDataUrodzenia(wiersz[7]);
          if (dataUrodzenia == null){
            System.out.println("Nieprawidłowy format daty urodzenia: "+wiersz[7]);
            linia = reader.readLine();
            continue;
          }
          pracownik.setDataUrodzenia(dataUrodzenia);
          pracownik.setWiek(Integer.parseInt(wiersz[8]));
          String[] samochodParts = wiersz[9].split(" ");
          Samochod samochod = utworzSamochod(samochodParts);
          if (samochod == null){
            System.out.println("Nieprawidłowe dane samochodu: "+wiersz[9]);
            linia = reader.readLine();
            continue;
          }
          pracownik.setSamochod(samochod);
          pracownik.setWaga(Double.parseDouble(wiersz[10]));
          pracownik.setWzrost(Integer.parseInt(wiersz[11]));
          pracownik.setPensja(Integer.parseInt(wiersz[12]));
          pracownicy.add(pracownik);
        }
        linia = reader.readLine();
      }
    }catch (FileNotFoundException e) {
      System.out.println("Nie udało się otworzyć pliku");
    } catch (IOException e) {
      System.out.println("Wystąpił błąd: "+e.getMessage());
    }
    return pracownicy;
  }

  private static LocalDate getDataUrodzenia(String rekord){
    String[] dataUr = rekord.replaceAll("\\.", "/")
        .split("/");
    if (dataUr.length != 3){
      return null;
    }
    //Integer[] dataUrInt = new Integer[3];
    //Arrays.stream(dataUr).map(element -> Integer.parseInt(element))
    //.collect(Collectors.toList()).toArray(dataUrInt);
    LocalDate dataUrodzenia = LocalDate.of(Integer.parseInt(dataUr[2]),
        Integer.parseInt(dataUr[0]),
        Integer.parseInt(dataUr[1]));
    return dataUrodzenia;
  }

  private static void ustawPlecPracownika(String s, Pracownik pracownik) {
    if (s.equals("male")){
      pracownik.setPlec(Plec.MEZCZYZNA);
    }else{
      pracownik.setPlec(Plec.KOBIETA);
    }
  }

  private static Samochod utworzSamochod(String[] elementy){
    if (elementy == null || elementy.length < 3){
      return null;
    }
    int rocznik = Integer.parseInt(elementy[0]);
    String marka = elementy[1];
    StringBuilder sb = new StringBuilder();
    for (int i=2;i<elementy.length;i++){
      sb.append(elementy[i]+" ");
    }
    Samochod samochod = new Samochod(marka, sb.toString(), rocznik);
    return samochod;
  }
}
