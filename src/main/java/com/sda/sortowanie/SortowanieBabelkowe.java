package com.sda.sortowanie;

import java.util.List;

public class SortowanieBabelkowe implements Sortowanie {

  @Override public String getNazwaAlgorytmu() {
    return "Sortowanie bąbelkowe";
  }

  public String podajZlozonoscObliczeniowa(){
    return "O(n^2)";
  }

  @Override public int[] sortuj(int[] tablica) {
    int licznikPorownan = 0;
    for (int i=0 ; i<tablica.length;i++){
      for(int j=i+1; j<tablica.length;j++){
        licznikPorownan++;
        if(tablica[i] > tablica[j]){
          int tmp = tablica[i];
          tablica[i] = tablica[j];
          tablica[j] = tmp;
        }
      }

    }
    System.out.println("Licznik porównań: "+licznikPorownan);
    return tablica;
  }

  public static void main(String[] args) {
    int[] test = new int[]{5,4,3,2,1};
    for (int i=0;i<test.length;i++){
      System.out.print(test[i]+" ");
    }
    System.out.println();
    Sortowanie sortowanie = new SortowanieBabelkowe();
    test = sortowanie.sortuj(test);
    for (int i=0;i<test.length;i++){
      System.out.print(test[i]+" ");
    }
  }
}
