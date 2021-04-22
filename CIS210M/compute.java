package CIS210M;

public class compute {

    public int gcd(Integer a, Integer b) {
        // function for finding the greatest common denominator
        if ( a == 0) return b;
        return gcd(b%a, a);
    }
}
