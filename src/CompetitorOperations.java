import java.util.*;

public class CompetitorOperations {

    public static void createList(List<Competitor> list, Scanner scanner) {
        System.out.print("Numar concurenti: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Nume: ");
            String name = scanner.nextLine();
            System.out.print("Nota: ");
            double grade = scanner.nextDouble();
            scanner.nextLine();
            list.add(new Competitor(name, grade));
        }
    }

    public static void sortList(List<Competitor> list) {
        list.sort((a, b) -> Double.compare(b.getGrade(), a.getGrade()));
    }

    public static int searchList(List<Competitor> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void splitList(List<Competitor> list, List<Competitor> admitted, List<Competitor> rejected, double threshold) {
        for (Competitor c : list) {
            if (c.getGrade() >= threshold) {
                admitted.add(c);
            } else {
                rejected.add(c);
            }
        }
    }

    public static void displayList(List<Competitor> list) {
        for (Competitor c : list) {
            System.out.println(c);
        }
    }
}
