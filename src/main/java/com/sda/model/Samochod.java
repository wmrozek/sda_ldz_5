package com.sda.model;

public class Samochod {
  private String marka;
  private String model;
  private int rocznik;

  public Samochod(String marka, String model, int rocznik) {
    this.marka = marka;
    this.model = model;
    this.rocznik = rocznik;
  }

  public String getModel() {
    return model;
  }

  public String getMarka() {
    return marka;
  }

  public void setMarka(String marka) {
    this.marka = marka;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getRocznik() {
    return rocznik;
  }

  public void setRocznik(int rocznik) {
    this.rocznik = rocznik;
  }

  public String toString(){
    return String.format("%s %s, rocznik %d", marka, model, rocznik);
  }
}
