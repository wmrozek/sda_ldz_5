package com.sda.model;

public class Osoba implements Comparable<Osoba>{
  private String imie;
  private String nazwisko;
  private int wiek;
  private String pesel;

  public Osoba(String imie, String nazwisko, int wiek) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.wiek = wiek;
  }

  public Osoba(String imie, String nazwisko, int wiek, String pesel) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.wiek = wiek;
    this.pesel = pesel;
  }

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
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

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Osoba osoba = (Osoba) o;

    if (wiek != osoba.wiek)
      return false;
    if (!imie.equals(osoba.imie))
      return false;
    return nazwisko.equals(osoba.nazwisko);
  }

  @Override public int hashCode() {
    int result = imie.hashCode();
    result = 31 * result + nazwisko.hashCode();
    result = 31 * result + wiek;
    return result;
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
