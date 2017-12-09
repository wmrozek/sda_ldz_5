package com.sda.sortowanie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortowanieSzybkie implements Sortowanie {
  @Override public String getNazwaAlgorytmu() {
    return "Sortowanie szybkie";
  }

  @Override public int[] sortuj(int[] tablica) {
    List<Integer> lista = new ArrayList();
    for (int element : tablica){
      lista.add(element);
    }
    lista = sortujRekurencyjnie(lista);
    for (int i=0;i<lista.size();i++){
      tablica[i] = (int) lista.get(i);
    }
    return tablica;
  }

  private List<Integer> sortujRekurencyjnie(List<Integer> lista){
    if (lista.size()<2){
      return lista;
    }else if (lista.size()==2){
      if (lista.get(0) > lista.get(1)){
        int temp = lista.get(0);
        lista.set(0, lista.get(1));
        lista.set(1, temp);
      }
      return lista;
    }
    int srodek = lista.get(0);
    List<Integer> mniejszeRowne = new ArrayList<>();
    List<Integer> wieksze = new ArrayList<>();
    for (int i=1; i<lista.size();i++){
      if (lista.get(i) <= srodek){
        mniejszeRowne.add(lista.get(i));
      }else{
        wieksze.add(lista.get(i));
      }
    }
    mniejszeRowne = sortujRekurencyjnie(mniejszeRowne);
    wieksze = sortujRekurencyjnie(wieksze);

    List<Integer> wyniki = new ArrayList<>();
    wyniki.addAll(mniejszeRowne);
    wyniki.add(srodek);
    wyniki.addAll(wieksze);

    return wyniki;
  }

  public static void main(String[] args) {
    int[] test = new int[]{2,4,5,7,8};
    test = new SortowanieSzybkie().sortuj(test);
  }

}
