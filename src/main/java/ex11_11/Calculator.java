package ex11_11;

public class Calculator {

    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }

        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }
        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        //JEZELI JAKIS WARUNEK ZOSTANIE SPELNIONY TO WYWALI EXCEPTION
        if (setSize < 0 || subsetSize < 0 || subsetSize > setSize) {
            throw new IllegalArgumentException();
        }
        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);
        return numerator / denominator;
    }
}
