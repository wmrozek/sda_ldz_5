package com.sda.streamy;

public class MiejscowoscLiczbaPracownikow {
  private String miejscowosc;
  private int liczbaPracownikow;

  public MiejscowoscLiczbaPracownikow(String miejscowosc){
    this.miejscowosc = miejscowosc;
    this.liczbaPracownikow = 0;
  }

  public void dodajPracownika(){
    this.liczbaPracownikow++;
  }

  public int getLiczbaPracownikow() {
    return liczbaPracownikow;
  }

  public String getMiejscowosc() {
    return miejscowosc;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    MiejscowoscLiczbaPracownikow that = (MiejscowoscLiczbaPracownikow) o;

    return miejscowosc.equals(that.miejscowosc);
  }

  @Override public int hashCode() {
    return miejscowosc.hashCode();
  }
}
