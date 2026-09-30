import java.util.function.BiFunction;

class Fraction {
    private int numerator;  
    private int denominator; 

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменник не може дорівнювати 0");
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator /= gcd;
        this.denominator /= gcd;
        if (this.denominator < 0) { 
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

public class FractionTask {
    public static void main(String[] args) {
        BiFunction<Fraction, Fraction, Fraction> add = (f1, f2) -> new Fraction(
            f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator(),
            f1.getDenominator() * f2.getDenominator()
        );

        BiFunction<Fraction, Fraction, Fraction> subtract = (f1, f2) -> new Fraction(
            f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator(),
            f1.getDenominator() * f2.getDenominator()
        );

        BiFunction<Fraction, Fraction, Fraction> multiply = (f1, f2) -> new Fraction(
            f1.getNumerator() * f2.getNumerator(),
            f1.getDenominator() * f2.getDenominator()
        );

        BiFunction<Fraction, Fraction, Fraction> divide = (f1, f2) -> new Fraction(
            f1.getNumerator() * f2.getDenominator(),
            f1.getDenominator() * f2.getNumerator()
        );

        Fraction f1 = new Fraction(1, 2); // 1/2
        Fraction f2 = new Fraction(3, 4); // 3/4

        System.out.println("=== Завдання 2: Операції з дробами ===");
        System.out.println(f1 + " + " + f2 + " = " + add.apply(f1, f2));
        System.out.println(f1 + " - " + f2 + " = " + subtract.apply(f1, f2));
        System.out.println(f1 + " * " + f2 + " = " + multiply.apply(f1, f2));
        System.out.println(f1 + " / " + f2 + " = " + divide.apply(f1, f2));
    }
}