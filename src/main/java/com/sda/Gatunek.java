package com.sda;

public enum Gatunek {

  HORROR("Horror"), SCI_FI("Science-fiction"), EPOPEJA("Epos");

  private String czytelnaNazwa;

  private Gatunek(String czytelnaNazwa){
    this.czytelnaNazwa = czytelnaNazwa;
  }

  public String getCzytelnaNazwa() {
    return czytelnaNazwa;
  }

  public static Gatunek fromValue(String s){
    for (Gatunek gatunek : values()){
      if (gatunek.getCzytelnaNazwa().equals(s)){
        return gatunek;
      }
    }
    return null;
  }
}
