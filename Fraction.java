/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractions;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.InputMismatchException;

// import calculators.NumberTheoreticFunctionsCalculator;

/**
 *
 * @author AL
 */
public class Fraction {
    
    private final long fractNumer;
    private final long fractDenom;
    
    private static final int HASH_SEP = 65536;
    
    public long getNumerator() {
        return fractNumer;
    }
    
    public long getDenominator() {
        return fractDenom;
    }

    /**
     * This method takes in a fraction and adds it to the fraction
     * @param addend The fraction to add
     * @return The sum of the two fractions added
     */
    public Fraction plus(Fraction addend) {
        return new Fraction(0, 1); // THIS SHOULD FAIL THE FIRST TEST
    }
    
    public Fraction minus(Fraction subtrahend) {
        return new Fraction(0, 1); // THIS SHOULD FAIL THE FIRST TEST
    }
    
    public Fraction times(Fraction multiplicand) {
        return new Fraction(0, 1); // THIS SHOULD FAIL THE FIRST TEST
    }

    /**
     * Divides one Fraction by another.
     * @param divisor The Fraction by which to divide this.
     * @return The resulting Fraction.
     * @throws InputMismatchException If the denominator is 0.
     */
    public Fraction dividedBy(Fraction divisor) {
        return new Fraction(0, 1); // THIS SHOULD FAIL THE FIRST TEST
    }
    
    public Fraction negate() {
        return new Fraction(0, 1); // THIS SHOULD FAIL THE FIRST TEST
    }
    
    @Override
    public String toString() {
        return "Feature not implemented yet"; // THIS SHOULD FAIL THE FIRST TEST
    }
    
    public String toHTMLString() {
        return "Feature not implemented yet"; // THIS SHOULD FAIL THE FIRST TEST
    }
    
    public String toTeXString() {
        return "Feature not implemented yet"; // THIS SHOULD FAIL THE FIRST TEST
    }
    
    @Override
    public int hashCode() {
        long numerHash = fractNumer % HASH_SEP;
        long denomHash = fractDenom % HASH_SEP;
        return (int) (numerHash * HASH_SEP + denomHash);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        if (this.fractNumer != other.fractNumer) {
            return false;
        }
        return (this.fractDenom == other.fractDenom);
    }

    /**
     * Gives a numeric approximation of the fraction.
     * @return A double that is as good as the machine precision of the JVM. For example, 1/7 is approx. 0.142857.
     */
    public double getNumericApproximation() {
        return ((double) this.fractNumer / (double) this.fractDenom);
    }
    
    public Fraction reciprocal() {
        return new Fraction(0, 1); // THIS SHOULD FAIL THE FIRST TEST
    }
    
    // TODO: Write tests for the following cases: 5/4, 1, 1/15, 0, -3/2.
    public Fraction[] getEgyptianFractions() {
        ArrayList<Fraction> fractList = new ArrayList<>();
        long currDenom = 2;
        Fraction currPortion = this;
        Fraction currUnitFract, resetPortion;
        while (currPortion.fractNumer > 0) {
            currUnitFract = new Fraction(1, currDenom);
            resetPortion = currPortion.minus(currUnitFract);
            if (resetPortion.fractNumer >= 0) {
                fractList.add(currUnitFract);
                currPortion = resetPortion;
            }
            currDenom++;
        }
        // Can't convert Object[] to Fraction[], so can't do "return fractList.toArray()"
        Fraction[] fractArray = fractList.toArray(new Fraction[0]); // https://shipilev.net/blog/2016/arrays-wisdom-ancients/
        return fractArray;
    }

    /**
     *
     * @param a
     * @return
     * @throws SQLDataException
     */
    public String throb(int a) throws SQLDataException {
        return "This is gonna fail the first test";
    }
    
    /**
     * Implicit denominator constructor
     * @param numerator 
     */
    public Fraction(long numerator) {
        this.fractNumer = numerator;
        this.fractDenom = 1;
    }
    
    public Fraction(long numerator, long denominator) {
        if (denominator == 0) {
            String exceptionMessage = "Denominator 0 is not allowed.";
            throw new IllegalArgumentException(exceptionMessage);
        }
        long gcdNumDen = 1;
// TODO: Implement gcd(long a, long b) so then you can do
//      long gcdNumDen := gcd(numerator, denominator)
        if (denominator < 0) {
            gcdNumDen *= -1;
        }
        this.fractNumer = numerator / gcdNumDen;
        this.fractDenom = denominator / gcdNumDen;
    }
    
}
