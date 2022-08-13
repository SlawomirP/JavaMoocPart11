package ex12_10;

import java.util.ArrayList;
import java.util.Collections;

//SPRAWDZENIE CZY KWADRAT JEST MAGIC SQUARE A NASTEPNIE
//NAPISANIE ALGORYTMU KTORY TWORZY TAKI SQUARE
public class MagicSquare {
    //UTWORZENIE POLA TABLICY DWUWYMIAROWEJ
    private int[][] square;

    // ready constructor
    //USTALAMY JUZ W KONSTRUKTORZE ROZMIAR TABLICY
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }
        this.square = new int[size][size];
    }

    // METODA MA ZWROCIC SUMĘ LICZB W KAZDYM RZEDZIE W POSTACI
    // LISTY
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> listSums = new ArrayList<>();
        for (int row = 0; row < this.square.length; row++) {
            int sumInRow = 0;
            for (int column = 0; column < this.square[row].length; column++) {
                sumInRow += this.square[row][column];
            }
            listSums.add(sumInRow);
        }
        return listSums;
    }

    //METODA KTORA ZWROLI SUME LICZB W KAZDEJ KOLUMNIE W POSTACI LISTY
    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> listSums = new ArrayList<>();
        int sumInColumn = 0;
        for (int column = 0; column < this.square.length; column++) {
            for (int row = 0; row < this.square[column].length; row++) {
                sumInColumn += this.square[row][column];
            }
            listSums.add(sumInColumn);
        }
        return listSums;
    }
//ZWROCI SUME LICZB PO PRZEKATNYCH KWADRATU I ZWROCI W LISCIE
    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> listSums = new ArrayList<>();
        int sumDiagFirst = 0;
        int sumDiagSecond = 0;
        for(int rowCol = 0; rowCol < this.square.length; rowCol++){
            sumDiagFirst += this.square[rowCol][rowCol];
        }
        listSums.add(sumDiagFirst);
        int column = 0;
        for(int row = this.square.length-1; row >=0 ;row--){
            sumDiagSecond += this.square[row][column];
            column++;
        }
        listSums.add(sumDiagSecond);
        return listSums;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }
        return numbers;
    }
    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }
        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return -1;
        }
        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }
}