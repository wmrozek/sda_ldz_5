package com.sda.model;

public class Osoba implements Comparable<Osoba>{
  private String imie;
  private String nazwisko;
  private int wiek;

  public Osoba(String imie, String nazwisko, int wiek) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.wiek = wiek;
  }

  public String getImie() {
    return imie;
  }

  public void setImie(String imie) {
    this.imie = imie;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }

  public int getWiek() {
    return wiek;
  }

  public void setWiek(int wiek) {
    this.wiek = wiek;
  }


  @Override public String toString() {
    return "Osoba{" + "imie='" + imie + '\'' + ", nazwisko='" + nazwisko + '\'' + ", wiek=" + wiek + '}';
  }

  @Override public int compareTo(Osoba o) {
    if (this.getNazwisko().compareToIgnoreCase(o.getNazwisko()) < 0){
      return -1;
    }else if (this.getNazwisko().compareToIgnoreCase(o.getNazwisko()) > 0){
      return 1;
    }else{
      return 0;
    }
  }
}