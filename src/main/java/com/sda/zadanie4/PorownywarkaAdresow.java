package com.sda.zadanie4;

import java.util.Comparator;
import java.util.List;

public class PorownywarkaAdresow implements Comparator<Adres> {

  private Porzadek porzadek;
  private List<KryteriumSortujace> kryteria;

  public PorownywarkaAdresow(Porzadek porzadek) {
    this.porzadek = porzadek;
  }

  public PorownywarkaAdresow(Porzadek porzadek, List<KryteriumSortujace> kryteria) {
    this.porzadek = porzadek;
    this.kryteria = kryteria;
  }

  @Override public int compare(Adres o1, Adres o2) {
    int result = 0;
    if (kryteria != null && !kryteria.isEmpty()) {
      for (KryteriumSortujace kryterium : kryteria) {
        result = compareByKryterium(kryterium, o1, o2);
        if (result != 0){
          break;
        }
      }
    } else {
      result = compareDefault(o1, o2);
    }
    if (porzadek.equals(Porzadek.MALEJACO)) {
      result *= -1;
    }
    return result;
  }

  private int compareByKryterium(KryteriumSortujace kryterium, Adres o1, Adres o2) {
    switch (kryterium) {
      case MIEJSCOWOSC:
        return o1.getMiejscowosc().compareToIgnoreCase(o2.getMiejscowosc());
      case ULICA:
        return o1.getUlica().compareToIgnoreCase(o2.getUlica());
      case NR_BUDYNKU:
        return o1.getNrBudynku() - o2.getNrBudynku();
      case KOD_POCZTOWY:
        return o1.getKodPocztowy().compareToIgnoreCase(o2.getKodPocztowy());
      default:
        return 0;
    }
  }

  private int compareDefault(Adres o1, Adres o2) {
    if (o1.getUlica().compareToIgnoreCase(o2.getUlica()) < 0) {
      return -1;
    } else if (o1.getUlica().compareToIgnoreCase(o2.getUlica()) > 0) {
      return 1;
    } else {
      if (o1.getNrBudynku() < o2.getNrBudynku()) {
        return -1;
      } else if (o1.getNrBudynku() > o2.getNrBudynku()) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
