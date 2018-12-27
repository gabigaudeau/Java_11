public class Fraction {

    private int num;
    private int den;

    public Fraction(int num, int den) {
        if (den < 0) {
            this.num = - num;
            this.den = - den;
        } else if ((num * den) > 0){
            this.num = Math.abs(num);
            this.den = Math.abs(den);
        } else if (den == 0){
            throw new IllegalArgumentException();
        } else {
            this.num = num;
            this.den = den;
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

    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return den;
    }

    @Override
    public String toString() {
        if (this.den == 1) {
                return String.valueOf(this.num);
        } else {
            return (this.num + " / " + this.den);
        }
    }

    public double toDouble() {
        return((double)this.num / (double)this.den);
    }

    public Fraction add(Fraction other) {
        Fraction addition = new Fraction((this.num * other.den) + (other.num * this.den), this.den * other.den);
        addition.toLowestTerms();
        return addition;
    }

    public Fraction subtract(Fraction other) {
        Fraction subtraction = new Fraction((this.num * other.den) - (other.num * this.den), this.den * other.den);
        subtraction.toLowestTerms();
        return subtraction;
    }

    public Fraction multiply(Fraction other) {
        Fraction multiplication = new Fraction(this.num * other.getNumerator(), other.getDenominator() * this.den);
        multiplication.toLowestTerms();
        return multiplication;
    }

    public Fraction divide(Fraction other) {
        if (other.getNumerator() == 0) {
            throw new IllegalArgumentException(Integer.toString(other.getNumerator()));

        } else {
            Fraction division = new Fraction(this.num * other.getDenominator(), other.getNumerator() * this.den);
            division.toLowestTerms();
            return division;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            if (this.toDouble() == ((Fraction)other).toDouble()) {
                return true;
            } else return false;
        } else {
            return false;
        }
    }

    public void toLowestTerms()  {
        int r = gcd(Math.abs(this.num), Math.abs(this.den));
        this.num /= r;
        this.den /= r;
    }

    private int gcd(int num, int den) {
        int a = Math.max(num, den);
        int b = Math.min(num, den);
        int r;

        while (a != 0 && b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

}
