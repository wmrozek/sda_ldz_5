package com.sda.streamy;

import com.sda.csv.NarzedziaCsv;
import com.sda.model.Plec;
import com.sda.model.Pracownik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PracownicyCwiczenia {
  public static void main(String[] args) {
    String sciezkaDoPliku = "E:/SDA/data.csv";
    List<Pracownik> pracownicy = NarzedziaCsv.czytajCsvZPliku(sciezkaDoPliku);
//    System.out.println(pracownicy.size());
//    System.out.println(pracownicy.get(0));

    //    //Wszyscy pracownicy, których nazwisko zaczyna się na literę C
    //    List<Pracownik> nazwiskaNaC = pracownicy.stream()
    //        .filter(pracownik -> pracownik.getNazwisko().startsWith("C"))
    //        .collect(Collectors.toList());
    //    System.out.println(nazwiskaNaC.size());
    //
    //    //Pracownicy po 50-tce jeżdżący BMW
    //    List<Pracownik> po50tceIBMW = pracownicy.stream()
    //        .filter(pracownik -> pracownik.getWiek()>50 && pracownik.getSamochod().getMarka().equalsIgnoreCase("bmw"))
    //        .collect(Collectors.toList());
    //    for (Pracownik pracownik : po50tceIBMW){
    //      System.out.println(String.format("%s %s %d %s",
    //          pracownik.getImie(), pracownik.getNazwisko(), pracownik.getWiek(), pracownik.getSamochod()));
    //    }
    //
    //    //Lista pracowników posortowana wg pensji (malejąco)
    //    List<Pracownik> posortowanaPoPensji = pracownicy.stream().sorted((o1, o2) -> o2.getPensja() - o1.getPensja())
    //        .collect(Collectors.toList());
    //
    //    for(Pracownik pracownik : posortowanaPoPensji){
    //      System.out.println(String.format("Nazwisko: %s, pensja: %d", pracownik.getNazwisko(), pracownik.getPensja()));
    //    }

//    List<Pracownik> pierwsze10Pensji = pracownicy.stream().sorted(((o1, o2) -> o2.getPensja() - o1.getPensja()))
//        .limit(10)
//        .collect(Collectors.toList());
//    for (Pracownik pracownik : pierwsze10Pensji) {
//      System.out.println(String.format("Nazwisko: %s, pensja: %d", pracownik.getNazwisko(), pracownik.getPensja()));
//    }
//
//    List<Pracownik> pracownicyKopia = new ArrayList<>(pracownicy);
//    pracownicyKopia.sort(new Comparator<Pracownik>() {
//      @Override public int compare(Pracownik o1, Pracownik o2) {
//        return o2.getPensja() - o1.getPensja();
//      }
//    });
//    List<Pracownik> pierwsze10 = new ArrayList<>();
//    for (int i=0;i<10;i++){
//      pierwsze10.add(pracownicyKopia.get(i));
//    }
//    for (Pracownik pracownik : pierwsze10) {
//      System.out.println(String.format("Nazwisko: %s, pensja: %d", pracownik.getNazwisko(), pracownik.getPensja()));
//    }
//      zadanie1(pracownicy);
//    zadanie3(pracownicy);
//    zadanie4(pracownicy);
//    zadanie7(pracownicy);
//    zadanie11(pracownicy);
    lista5MiejscowosciZNajwiekszaLiczbaPracownikow(pracownicy);
    lista5MiejscowosciZNajwiekszaLiczbaPracownikowDrugiSposob(pracownicy);
  }


  private static void zadanie11(List<Pracownik> pracownicy){
    Map<Integer, Long> mapa = new HashMap<>();
    for (Pracownik pracownik : pracownicy){
      int rocznikSamochodu = pracownik.getSamochod().getRocznik();
      if(mapa.containsKey(rocznikSamochodu)){
        mapa.put(rocznikSamochodu, mapa.get(rocznikSamochodu)+1);
      }else{
        mapa.put(rocznikSamochodu, 1l); //1l oznacza, że to wartość jako long, a nie int.
      }
    }
    System.out.println(mapa);
  }

  //Procent kobiet
  private static void zadanie9(List<Pracownik> pracownicy){
    int licznik = 0;
    for (Pracownik pracownik : pracownicy){
      if (pracownik.getPlec().equals(Plec.KOBIETA)){
        licznik++;
      }
    }
    double procent = (1.0*licznik/pracownicy.size()) * 100;
    System.out.println(procent);
    long iloscKobiet = pracownicy.stream()
        .filter(pracownik -> pracownik.getPlec().equals(Plec.KOBIETA))
        .count();
    procent = (1.0*iloscKobiet/pracownicy.size()) * 100;
    System.out.println(procent);
  }

  //Osoby korzystające z linuxa
  private static void zadanie4(List<Pracownik> pracownicy){
    List<Pracownik> opcja1 = pracownicy.stream()
        .filter(pracownik -> pracownik.getPrzegladarka().toLowerCase().contains("linux"))
        .collect(Collectors.toList());
    for (Pracownik p : opcja1){
      System.out.println(wypiszPracownika(p.getNazwisko(), p.getPrzegladarka()));
    }
    List<Pracownik> opcja2 = new ArrayList<>();
    for (Pracownik pracownik : pracownicy){
      if (pracownik.getPrzegladarka().toLowerCase().contains("linux")){
        opcja2.add(pracownik);
      }
    }
    System.out.println("----------------------");
    for (Pracownik p : opcja2){
      System.out.println(wypiszPracownika(p.getNazwisko(), p.getPrzegladarka()));
    }

  }
  //Osoby z prawidłowym BMI
  private static void zadanie8(List<Pracownik> pracownicy){
    List<Pracownik> wyniki = new ArrayList<>();
    for (Pracownik pracownik : pracownicy){
      double waga = pracownik.getWaga();
      int wzrostCm = pracownik.getWzrost();
      double wzrost = (1.0*wzrostCm)/100;
      double bmi = waga / (wzrost * wzrost);  //Math.pow(wzrost, 2)
      if (bmi > 18.5 && bmi < 25.0){
        wyniki.add(pracownik);
      }
    }
    for (Pracownik p : wyniki){
      System.out.println(wypiszPracownika(p.getNazwisko(), p.getWaga(), p.getWzrost()));
    }

    List<Pracownik> stream = pracownicy.stream()
        .filter(pracownik -> {
          double waga = pracownik.getWaga();
          int wzrostCm = pracownik.getWzrost();
          double wzrost = (1.0*wzrostCm)/100;
          double bmi = waga / (wzrost * wzrost);  //Math.pow(wzrost, 2)
          return bmi > 18.5 && bmi < 25.0;
        })
        .collect(Collectors.toList());
    for (Pracownik p : stream){
      System.out.println(wypiszPracownika(p.getNazwisko(), p.getWaga(), p.getWzrost()));
    }


  }

  //Osoba z najniższymi dochodami jeżdżąca Porsche
  private static void zadanie7(List<Pracownik> pracownicy){
    List<Pracownik> pracownicyZPorsche = new ArrayList<>();
    for (Pracownik pracownik : pracownicy){
      if (pracownik.getSamochod().getMarka().equalsIgnoreCase("porsche")){
        pracownicyZPorsche.add(pracownik);
      }
    }
    Pracownik najbiedniejszy = null;
    for(Pracownik pracownik : pracownicyZPorsche){
      if (najbiedniejszy != null){
        if (pracownik.getPensja() < najbiedniejszy.getPensja()){
          najbiedniejszy = pracownik;
        }
      }else{
        najbiedniejszy = pracownik;
      }
    }
    System.out.println(wypiszPracownika("Najbiedniejszy: ", najbiedniejszy.getNazwisko(), najbiedniejszy.getPensja(), najbiedniejszy.getSamochod()));

    Optional<Pracownik> pracownikNajbiedniejszy = pracownicy.stream()
        .filter(pracownik -> pracownik.getSamochod().getMarka().equalsIgnoreCase("porsche"))
        .min(((o1, o2) -> o1.getPensja() - o2.getPensja()));
    if (pracownikNajbiedniejszy.isPresent()){
      Pracownik wartosc = pracownikNajbiedniejszy.get();
      System.out.println(wypiszPracownika("Najbiedniejszy: ", wartosc.getNazwisko(), wartosc.getPensja(), wartosc.getSamochod()));
    }else{
      System.out.println("Nie ma takiej osoby");
    }

  }

  //Pensja > 80tys i miejscowość = Wrocław
  private static void zadanie3(List<Pracownik> pracownicy){
    List<Pracownik> opcja1 = pracownicy.stream()
        .filter(pracownik -> pracownik.getPensja()>80000 && pracownik.getMiejscowosc().equalsIgnoreCase("wrocław"))
        .collect(Collectors.toList());
    for(Pracownik p : opcja1){
      System.out.println(wypiszPracownika(p.getImie(), p.getNazwisko(), p.getPensja(), p.getMiejscowosc()));
    }
    List<Pracownik> opcja2 = new ArrayList<>();
    for (Pracownik pracownik : pracownicy){
      if (pracownik.getPensja() > 80000 && pracownik.getMiejscowosc().equalsIgnoreCase("wrocław")){
        opcja2.add(pracownik);
      }
    }
    for(Pracownik p : opcja2){
      System.out.println(wypiszPracownika(p.getImie(), p.getNazwisko(), p.getPensja(), p.getMiejscowosc()));
    }
  }

  //Lista unikalna marek samochodów
  private static void zadanie1(List<Pracownik> pracownicy){
    Set<String> opcja1 = pracownicy
        .stream()
        .map(pracownik -> pracownik.getSamochod().getMarka())
        .collect(Collectors.toSet());
    System.out.println(opcja1);
    List<String> opcja2 = pracownicy
        .stream()
        .map(pracownik -> pracownik.getSamochod().getMarka())
        .distinct()
        .collect(Collectors.toList());
    System.out.println(opcja2);

    Set<String> opcja3 = new HashSet<>();
    for (Pracownik pracownik : pracownicy){
      String markaSamochodu = pracownik.getSamochod().getMarka();
      opcja3.add(markaSamochodu);
    }
    System.out.println(opcja3);
    List<String> opcja4 = new ArrayList<>();
    for(Pracownik pracownik : pracownicy){
      String markaSamochodu = pracownik.getSamochod().getMarka();
      if (!opcja4.contains(markaSamochodu)){
        opcja4.add(markaSamochodu);
      }
    }
    System.out.println(opcja4);
  }

  private static void lista5MiejscowosciZNajwiekszaLiczbaPracownikow(List<Pracownik> pracownicy){
    Map<String, Integer> mapaMiejscowosci = new HashMap<>();
    for (Pracownik pracownik : pracownicy){
      String miejscowosc = pracownik.getMiejscowosc();
      if (mapaMiejscowosci.containsKey(miejscowosc)){
        Integer iloscPracownikow = mapaMiejscowosci.get(miejscowosc);
        mapaMiejscowosci.put(miejscowosc, iloscPracownikow+1);
      }else{
        mapaMiejscowosci.put(miejscowosc, 1);
      }
    }

    TreeMap<Integer, List<String>> posortowanaMapa = new TreeMap<>(new Comparator<Integer>() {
      @Override public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    for (Map.Entry<String, Integer> para : mapaMiejscowosci.entrySet()){
      if (!posortowanaMapa.containsKey(para.getValue())){
        List<String> listaMiejscowosci = new ArrayList<>();
        listaMiejscowosci.add(para.getKey());
        posortowanaMapa.put(para.getValue(), listaMiejscowosci);
      }else{
        List<String> listaMiesjcowosci = posortowanaMapa.get(para.getValue());
        listaMiesjcowosci.add(para.getKey());
        posortowanaMapa.put(para.getValue(), listaMiesjcowosci);
      }
    }
    boolean canContinue = true;
    while(canContinue){
      int ilosc = 0;
      Iterator<Map.Entry<Integer, List<String>>> iter = posortowanaMapa.entrySet().iterator();
      while(iter.hasNext()){
        List<String> lista = iter.next().getValue();
        ilosc = ilosc + lista.size();
        System.out.println(lista);
        if (ilosc>4){
          canContinue=false;
          break;
        }
      }
    }

  }

  private static void lista5MiejscowosciZNajwiekszaLiczbaPracownikowDrugiSposob(List<Pracownik> pracownicy){
    List<MiejscowoscLiczbaPracownikow> lista = new ArrayList<MiejscowoscLiczbaPracownikow>();
    for (Pracownik pracownik : pracownicy){
      MiejscowoscLiczbaPracownikow miejscowoscLiczbaPracownikow = new MiejscowoscLiczbaPracownikow(pracownik.getMiejscowosc());
      if (lista.contains(miejscowoscLiczbaPracownikow)){
        lista.get(lista.indexOf(miejscowoscLiczbaPracownikow)).dodajPracownika();
      }else{
        miejscowoscLiczbaPracownikow.dodajPracownika();
        lista.add(miejscowoscLiczbaPracownikow);
      }
    }
    Collections.sort(lista, new Comparator<MiejscowoscLiczbaPracownikow>() {
      @Override public int compare(MiejscowoscLiczbaPracownikow o1, MiejscowoscLiczbaPracownikow o2) {
        return o2.getLiczbaPracownikow() - o1.getLiczbaPracownikow();
      }
    });
    for (int i=0;i<5;i++){
      System.out.println(lista.get(i).getMiejscowosc());
    }
  }

  private static String wypiszPracownika(Object... parametry){
    StringBuilder sb = new StringBuilder();
    for (Object parametr : parametry){
      sb.append(parametr.toString()+" ");
    }
    return sb.toString();
  }
}
