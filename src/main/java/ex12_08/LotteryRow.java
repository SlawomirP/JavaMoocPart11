package ex12_08;


import java.util.ArrayList;
import java.util.Random;

//LOSOWANIE 7 RÓŻNYCH LICZB Z ZAKRESU 1-40
public class LotteryRow {

    private ArrayList<Integer> numbers;
    private Random r = new Random();

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        while (this.numbers.size() == 7) {
            int drawNumber = r.nextInt(1, 41);
            if (!this.numbers.contains(drawNumber)) {
                this.numbers.add(drawNumber);
            }
        }
    }
    // Implement the random number generation here
    // the method containsNumber is probably useful


    public boolean containsNumber(int number) {
        for (Integer num : this.numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }
}

