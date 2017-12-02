package com.sda.pesel;

/**
 * Wyniki weryfikacji numeru PESEL
 * @author Witold Mrózek
 */
public class PeselWynikiWeryfikacji {
  private boolean peselPrawidlowy;
  private String plec;
  private String dataUrodzenia;

  public PeselWynikiWeryfikacji(boolean peselPrawidlowy, String plec, String dataUrodzenia) {
    this.peselPrawidlowy = peselPrawidlowy;
    this.plec = plec;
    this.dataUrodzenia = dataUrodzenia;
  }

  public PeselWynikiWeryfikacji(boolean peselPrawidlowy){
    this.peselPrawidlowy = peselPrawidlowy;
  }

  public boolean isPeselPrawidlowy() {
    return peselPrawidlowy;
  }

  public void setPeselPrawidlowy(boolean peselPrawidlowy) {
    this.peselPrawidlowy = peselPrawidlowy;
  }

  public String getPlec() {
    return plec;
  }

  public void setPlec(String plec) {
    this.plec = plec;
  }

  public String getDataUrodzenia() {
    return dataUrodzenia;
  }

  public void setDataUrodzenia(String dataUrodzenia) {
    this.dataUrodzenia = dataUrodzenia;
  }
}
