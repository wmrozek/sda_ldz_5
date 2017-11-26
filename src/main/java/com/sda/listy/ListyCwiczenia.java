package com.sda.listy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListyCwiczenia {
  public static void main(String[] args) {
//    arrayList();
    linkedList();
  }


  public static void arrayList(){
    List<String> lista = new ArrayList<>();
    ArrayList<String> listaArrayList = new ArrayList<>();
    List<String> lista100Elementow = new ArrayList<>(100);

    lista.add("Ala");
    lista.add("kota");
    lista.add("kota");
    lista.add("kota");
    lista.add("kota");
    lista.add(1, "ma");

    System.out.println(lista.toString());

    System.out.println(lista.get(0));
    String zmienna = lista.get(1);
    System.out.println(zmienna);

    lista.remove(0);
    lista.remove("kota");

    System.out.println(lista);

    String poprzednia = lista.set(0, "Ala ma");
    System.out.println(poprzednia);
    System.out.println(lista);

    System.out.println(lista.size());


  }

  public static void linkedList(){
    List<String> lista = new LinkedList();
    lista.add("Ala");
    lista.add("ma");
    lista.add("psa");
    System.out.println(lista);
    String zmienna = lista.get(2);
    System.out.println(zmienna);
    lista.remove(0);
    System.out.println(lista);

    for (int i=0;i<lista.size();i++){
      System.out.println(lista.get(i));
    }

    for (String element : lista){
      System.out.println(element);
    }

    Iterator<String> iterator = lista.iterator();
    while(iterator.hasNext()){
      String element = iterator.next();
      System.out.println(element);
    }


  }
}
