/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Service s = new Service();

    while (true) {
      System.out.println("\nWybierz opcje:");
      System.out.println("1 - Dodaj nowego studenta");
      System.out.println("2 - Wypisz wszystkich studentow");
      System.out.println("0 - Wyjscie");
      System.out.print("Wybor: ");

      String choice = scanner.nextLine();

      if (choice.equals("0")) 
      {
        break;
      }

      try 
        {
        switch (choice) 
        {
          case "1":
            System.out.print("Podaj imie: ");
            String name = scanner.nextLine();

            System.out.print("Podaj nazwisko: ");
            String surname = scanner.nextLine();

            System.out.print("Podaj wiek: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Podaj date urodzenia ");
            String birthDate = scanner.nextLine();

            s.addStudent(new Student(name, surname, age, birthDate));
            System.out.println("Dodano studenta do bazy.");
            break;

          case "2":
            var students = s.getStudents();
            System.out.println("\nLista studentow:");
            for (Student current : students) {
              System.out.println(current.ToString());
            }
            break;

          default:
            System.out.println("Nieznana opcja");
        }
      } 
      catch(IOException e) 
        {
        System.out.println("Blad obslugi pliku db.txt: " + e.getMessage());
      } catch (NumberFormatException e) {
        System.out.println("Wiek musi byc liczba calkowita.");
      }
    }

    scanner.close();
  }
}