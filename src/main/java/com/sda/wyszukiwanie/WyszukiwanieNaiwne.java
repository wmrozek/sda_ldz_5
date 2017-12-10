package com.sda.wyszukiwanie;

public class WyszukiwanieNaiwne implements Wyszukiwanie{

  private int[] tablicaDoPrzeszukania;
  private String nazwaWyszukiwarki;
  public int licznikWywolan = 0;

  public WyszukiwanieNaiwne(int[] tablica, String nazwaWyszukiwarki){
    this.tablicaDoPrzeszukania = tablica;
    this.nazwaWyszukiwarki = nazwaWyszukiwarki;
  }

  public WyszukiwanieNaiwne(){
    this.nazwaWyszukiwarki = "Wyszukiwanie naiwne";
  }

  public String getNazwaWyszukiwarki() {
    return nazwaWyszukiwarki;
  }

  @Override public int szukaj(int liczba, int[] tablica) {
    if (tablica == null || tablica.length==0){
      return -1;
    }
    for (int i=0;i<tablica.length;i++){
      licznikWywolan++;
      if (tablica[i] == liczba){
        return i;
      }
    }
    return -1;
  }

  @Override public int szukaj(int liczba) {
    return szukaj(liczba, tablicaDoPrzeszukania);
  }

  @Override public int getLicznikWywolan() {
    return licznikWywolan;
  }

  public static void main(String[] args) {
    int[] tablica = {5,16,5,4,65,46,13,168,43,86,43,8,4,513,43,8,4};
    Wyszukiwanie naiwne = new WyszukiwanieNaiwne();
    System.out.println(naiwne.szukaj(168, tablica));
  }
}
