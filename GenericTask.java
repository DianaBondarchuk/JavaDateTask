@FunctionalInterface
interface FourOp<T> {
    T apply(T a, T b, T c, T d);
}

public class GenericTask {
    public static void main(String[] args) {
        FourOp<Comparable> maxOfFour = (a, b, c, d) -> {
            Comparable max = a;
            if (b.compareTo(max) > 0) max = b;
            if (c.compareTo(max) > 0) max = c;
            if (d.compareTo(max) > 0) max = d;
            return max;
        };

        FourOp<Comparable> minOfFour = (a, b, c, d) -> {
            Comparable min = a;
            if (b.compareTo(min) < 0) min = b;
            if (c.compareTo(min) < 0) min = c;
            if (d.compareTo(min) < 0) min = d;
            return min;
        };

        System.out.println("=== Завдання 3: Шаблони (Generics) ===");
        
        System.out.println("Max (Integer): " + maxOfFour.apply(10, 45, 3, 22));
        System.out.println("Min (Integer): " + minOfFour.apply(10, 45, 3, 22));

        System.out.println("Max (Double): " + maxOfFour.apply(5.5, 2.1, 9.8, 4.3));
        
        System.out.println("Min (String): " + minOfFour.apply("Apple", "Banana", "Cat", "Dog"));
    }
}