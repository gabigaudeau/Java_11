import java.lang.Math.*;

public class Fraction {

    private static int num;
    private static int den;

    public Fraction(int num, int den) {
        if (den < 0) {
            this.num = -num;
            this.den = -den;

        } else {
            this.num = num;

            if (den != 0) {
                this.den = den;
            } else {
                throw new IllegalArgumentException();
            }
        }

    }

    public Fraction(int num) {
        this.num = num;
        this.den = 1;
    }

    public Fraction() {
        this.num = 0;
        this.den = 1;
    }

    public static int getNumerator() {
        return num;
    }

    public static int getDenominator() {
        return den;
    }

    @Override
    public String toString() {
        if (den == 1) {
                return String.valueOf(num);
        } else {
            return(num + " / " + den);
        }
    }

    public double toDouble() {
        return((double)num/den);
    }

    public Fraction add(Fraction other) {
        System.out.println(other.num + " " + this.num);
        Fraction addition = new Fraction((this.num * other.den) + (other.num * this.den), this.den * other.den);
        System.out.println(addition);
        addition.toLowestTerms();
        return addition;
    }

    public void multiply(Fraction other) {

    }

    public void toLowestTerms()  {
        int r = gcd(this.num, this.den);
        this.num /= r;
        this.den /= r;
    }

    public int gcd(int num, int den) {
        int a = Math.max(num, den);
        int b = Math.min(num, den);

        while((a != 0) && (b != 0)) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

}
