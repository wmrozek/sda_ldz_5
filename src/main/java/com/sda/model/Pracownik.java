package com.sda.model;

import java.time.LocalDate;

public class Pracownik {
  private String imie;
  private String nazwisko;
  private double waga;
  private int wzrost;
  private int pensja;
  private String adres;
  private String miejscowosc;
  private String kodPocztowy;
  private String przegladarka;
  private Samochod samochod;
  private Plec plec;
  private LocalDate dataUrodzenia;
  private int wiek;

  public Pracownik() {
  }

  public int getWiek() {
    return wiek;
  }

  public void setWiek(int wiek) {
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

  public double getWaga() {
    return waga;
  }

  public void setWaga(double waga) {
    this.waga = waga;
  }

  public int getWzrost() {
    return wzrost;
  }

  public void setWzrost(int wzrost) {
    this.wzrost = wzrost;
  }

  public int getPensja() {
    return pensja;
  }

  public void setPensja(int pensja) {
    this.pensja = pensja;
  }

  public String getAdres() {
    return adres;
  }

  public void setAdres(String adres) {
    this.adres = adres;
  }

  public String getMiejscowosc() {
    return miejscowosc;
  }

  public void setMiejscowosc(String miejscowosc) {
    this.miejscowosc = miejscowosc;
  }

  public String getKodPocztowy() {
    return kodPocztowy;
  }

  public void setKodPocztowy(String kodPocztowy) {
    this.kodPocztowy = kodPocztowy;
  }

  public String getPrzegladarka() {
    return przegladarka;
  }

  public void setPrzegladarka(String przegladarka) {
    this.przegladarka = przegladarka;
  }

  public Samochod getSamochod() {
    return samochod;
  }

  public void setSamochod(Samochod samochod) {
    this.samochod = samochod;
  }

  public Plec getPlec() {
    return plec;
  }

  public void setPlec(Plec plec) {
    this.plec = plec;
  }

  public LocalDate getDataUrodzenia() {
    return dataUrodzenia;
  }

  public void setDataUrodzenia(LocalDate dataUrodzenia) {
    this.dataUrodzenia = dataUrodzenia;
  }

  @Override public String toString() {
    return "Pracownik{" + "imie='" + imie + '\'' + ", nazwisko='" + nazwisko + '\'' + ", miejscowosc='" + miejscowosc + '\'' + ", plec=" + plec + ", wiek=" + wiek + '}';
  }
}
