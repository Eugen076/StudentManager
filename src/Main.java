import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Competitor> list = new ArrayList<>();
        List<Competitor> admitted = new ArrayList<>();
        List<Competitor> rejected = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("\nMENIU:");
            System.out.println("1. Creare lista concurenti");
            System.out.println("2. Sortare dupa nota");
            System.out.println("3. Cautare dupa nume");
            System.out.println("4. Separare admisi/respinsi");
            System.out.println("5. Afisare lista");
            System.out.println("0. Iesire");
            System.out.print("Alege o optiune: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    CompetitorOperations.createList(list, scanner);
                    break;
                case 2:
                    CompetitorOperations.sortList(list);
                    System.out.println("Lista sortata!");
                    break;
                case 3:
                    System.out.print("Nume cautat: ");
                    String name = scanner.nextLine();
                    int index = CompetitorOperations.searchList(list, name);
                    if (index != -1) {
                        Competitor found = list.get(index);
                        System.out.println("Gasit: " + found);
                    } else {
                        System.out.println("Concurentul nu a fost gasit.");
                    }
                    break;
                case 4:
                    System.out.print("Pragul de admitere: ");
                    double threshold = scanner.nextDouble();
                    scanner.nextLine();
                    admitted.clear();
                    rejected.clear();
                    CompetitorOperations.splitList(list, admitted, rejected, threshold);
                    System.out.println("Admisi:");
                    CompetitorOperations.displayList(admitted);
                    System.out.println("Respinsi:");
                    CompetitorOperations.displayList(rejected);
                    break;
                case 5:
                    CompetitorOperations.displayList(list);
                    break;
                case 0:
                    System.out.println("Iesire...");
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }

        } while (option != 0);

        scanner.close();
    }
}
