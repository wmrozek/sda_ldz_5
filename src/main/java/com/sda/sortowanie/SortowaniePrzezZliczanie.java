package com.sda.sortowanie;

import java.util.Map;
import java.util.TreeMap;

public class SortowaniePrzezZliczanie implements Sortowanie{
  @Override public String getNazwaAlgorytmu() {
    return "Sortowanie przez zliczanie";
  }

  @Override public int[] sortuj(int[] tablica) {
    return zaPomocaMapy(tablica);
  }

  private int[] zaPomocaMapy(int[] tablica){
    Map<Integer, Integer> mapaZliczen = new TreeMap<>();
    for (int element : tablica){
      if (mapaZliczen.containsKey(element)){
        mapaZliczen.put(element, mapaZliczen.get(element)+1);
      }else{
        mapaZliczen.put(element, 1);
      }
    }
    int counter = 0;
    for (Map.Entry<Integer, Integer> entry : mapaZliczen.entrySet()){
      if (entry.getValue()>0){
        for (int i=0;i<entry.getValue();i++){
          tablica[counter] = entry.getKey();
          counter++;
        }
      }
    }
    return tablica;
  }

  private int[] zaPomocaTablic(int[] tablica) {
    int max = tablica[0];
    int min = tablica[0];
    for (int i=1;i<tablica.length;i++){
      if (tablica[i] > max){
        max = tablica[i];
      }
      if (tablica[i] < min){
        min = tablica[i];
      }
    }
    int przesuniecie = min*(-1);
    int[] zliczenia = new int[max-min+1];

    for(int element : tablica){
      zliczenia[element+przesuniecie] ++;
    }
    int counter = 0;
    for (int i=0; i<zliczenia.length;i++){
      if (zliczenia[i] > 0){
        for(int j=0;j<zliczenia[i];j++) {
          tablica[counter] = i - przesuniecie;
          counter++;
        }
      }
    }

    return tablica;
  }
}
