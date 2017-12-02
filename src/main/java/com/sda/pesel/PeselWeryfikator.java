package com.sda.pesel;

import java.time.DateTimeException;
import java.time.LocalDate;

public class PeselWeryfikator {
  public static PeselWynikiWeryfikacji sprawdzPesel(String pesel){
    if(!czyPeselMa11Znakow(pesel)){
      return new PeselWynikiWeryfikacji(false);
    }
    int[] peselArray = sprawdzIZamienPeselNaTabliceIntow(pesel);
    if (peselArray == null){
      return new PeselWynikiWeryfikacji(false);
    }
    String dataUrodzenia = sprawdzIZwrocDateUrodzenia(pesel);
    if (dataUrodzenia == null){
      return new PeselWynikiWeryfikacji(false);
    }
    if (!sprawdzSumeKontrolna(peselArray)){
      return new PeselWynikiWeryfikacji(false);
    }
    String plec = wezPlec(peselArray);
    return new PeselWynikiWeryfikacji(true, plec, dataUrodzenia);
  }

  private static boolean czyPeselMa11Znakow(String pesel){
    return pesel != null && pesel.length() == 11;
  }

  private static int[] sprawdzIZamienPeselNaTabliceIntow(String pesel){
    int[] result = new int[11];
    for (int i=0;i<pesel.length();i++){
      try{
        result[i] = Integer.parseInt(pesel.substring(i,i+1));
      }catch(NumberFormatException e){
        return null;
      }
    }
    return result;
  }

  private static String sprawdzIZwrocDateUrodzenia(String pesel){
    //Wyodrębniamy części daty z PESEL
    int rok = Integer.parseInt(pesel.substring(0,2));
    int miesiac = Integer.parseInt(pesel.substring(2,4));
    int dzien = Integer.parseInt(pesel.substring(4,6));
    //Weryfikujemy liczbę miesięcy
    if (miesiac<20){
      rok += 1900;
    }else if (miesiac < 40){
      miesiac -=20;
      rok +=2000;
    }else if (miesiac < 60){
      miesiac -=40;
      rok += 2100;
    }else if (miesiac < 80){
      miesiac -=60;
      rok +=2200;
    }else{
      miesiac -= 80;
      rok += 1800;
    }
    //Próbujemy utworzyć datę
    try {
      LocalDate date = LocalDate.of(rok, miesiac, dzien);
      return date.toString();
    }catch(DateTimeException e){
      return null;
    }
  }

  private static boolean sprawdzSumeKontrolna(int[] pesel){
    //9×a + 7×b + 3×c + 1×d + 9×e + 7×f + 3×g + 1×h + 9×i + 7×j
    int[] wagi = {9,7,3,1,9,7,3,1,9,7};
    int suma = 0;
    for (int i=0;i<10;i++){
      suma += wagi[i] * pesel[i];
    }
    return suma%10 == pesel[10];
//    Równoważne:
//    if (suma%10 == pesel[10]){
//      return true;
//    }else{
//      return false;
//    }
  }

  private static String wezPlec(int[] pesel){
    if (pesel[9] %2 == 0){
      return "Kobieta";
    }else{
      return "Mężczyzna";
    }
  }
}
