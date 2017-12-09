package com.sda.sortowanie;

public class SortowaniePrzezWybor implements Sortowanie {
  @Override public String getNazwaAlgorytmu() {
    return "Sortowanie przez wybór";
  }

  @Override public int[] sortuj(int[] tablica) {
    for(int i=0;i<tablica.length;i++){
      int wartoscMinimalna = tablica[i];
      int indexMin = i;
      for(int j=i+1;j<tablica.length;j++){
        if (tablica[j] < wartoscMinimalna){
          wartoscMinimalna = tablica[j];
          indexMin = j;
        }
      }
      if (i != indexMin){
        int temp = tablica[i];
        tablica[i] = wartoscMinimalna;
        tablica[indexMin] = temp;
      }
    }
    return tablica;
  }
}
