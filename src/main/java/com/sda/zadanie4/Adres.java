package com.sda.zadanie4;

public class Adres {
  private String miejscowosc;
  private String ulica;
  private String kodPocztowy;
  private int nrBudynku;

  public Adres(String miejscowosc, String ulica, String kodPocztowy, int nrBudynku) {
    this.miejscowosc = miejscowosc;
    this.ulica = ulica;
    this.kodPocztowy = kodPocztowy;
    this.nrBudynku = nrBudynku;
  }

  public String getMiejscowosc() {
    return miejscowosc;
  }

  public void setMiejscowosc(String miejscowosc) {
    this.miejscowosc = miejscowosc;
  }

  public String getUlica() {
    return ulica;
  }

  public void setUlica(String ulica) {
    this.ulica = ulica;
  }

  public String getKodPocztowy() {
    return kodPocztowy;
  }

  public void setKodPocztowy(String kodPocztowy) {
    this.kodPocztowy = kodPocztowy;
  }

  public int getNrBudynku() {
    return nrBudynku;
  }

  public void setNrBudynku(int nrBudynku) {
    this.nrBudynku = nrBudynku;
  }

  @Override public String toString() {
    return "Adres{" + "miejscowosc='" + miejscowosc + '\'' + ", ulica='" + ulica + '\'' + ", kodPocztowy='" + kodPocztowy + '\'' + ", nrBudynku=" + nrBudynku + '}';
  }
}
