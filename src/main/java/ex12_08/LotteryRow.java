package ex12_08;


import java.util.ArrayList;
import java.util.Random;

//LOSOWANIE 7 RÓŻNYCH LICZB Z ZAKRESU 1-40
public class LotteryRow {

    private ArrayList<Integer> numbers;
    private Random r = new Random();

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();
        while (this.numbers.size() == 7) {
            int drawNumber = r.nextInt(1, 41);
            if (!this.numbers.contains(drawNumber)) {
                this.numbers.add(drawNumber);
            }
        }
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
//        boolean status = false;
//        for (Integer num : this.numbers) {
//            if (num == number) {
//                status = true;
//            }
//        }
//        return status;
    }
}

