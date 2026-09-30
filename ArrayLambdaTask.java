import java.util.function.IntPredicate;

public class ArrayLambdaTask {

    public static int sumByCondition(int[] array, IntPredicate condition) {
        int sum = 0;
        for (int value : array) {
            if (condition.test(value)) {
                sum += value;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {-10, -5, 0, 5, 10, 15, 20, 25};
        
        int target = 10;
        int minA = 0;
        int maxB = 15;

        System.out.println("=== Завдання 4: Лямбда як параметр методу ===");

        int sumEquals = sumByCondition(numbers, x -> x == target);
        System.out.println("Сума елементів, що дорівнюють " + target + ": " + sumEquals);

        int sumOutOfRange = sumByCondition(numbers, x -> x < minA || x > maxB);
        System.out.println("Сума елементів поза діапазоном [" + minA + ".." + maxB + "]: " + sumOutOfRange);

        // 3. Перевірка на додатне число (> 0)
        int sumPositive = sumByCondition(numbers, x -> x > 0);
        System.out.println("Сума додатних чисел: " + sumPositive);

        int sumNegative = sumByCondition(numbers, x -> x < 0);
        System.out.println("Сума від'ємних чисел: " + sumNegative);
    }
}