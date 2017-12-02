package com.sda.porownania;

import com.sda.model.Osoba;

import java.util.Comparator;

public class PorownywarkaOsob implements Comparator<Osoba>{
  @Override public int compare(Osoba o1, Osoba o2) {
    if (o1.getWiek() < o2.getWiek()){
      return 1;
    }else if (o1.getWiek() > o2.getWiek()){
      return -1;
    }else{
      return 0;
    }
  }
}
