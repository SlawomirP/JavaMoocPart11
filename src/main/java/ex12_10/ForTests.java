package ex12_10;

import java.util.ArrayList;

public class ForTests {
    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>();

        int[][] test = new int[3][3];
        test[0][0] = 8;
        test[0][1] = 1;
        test[0][2] = 6;

        test[1][0] = 3;
        test[1][1] = 5;
        test[1][2] = 7;

        test[2][0] = 4;
        test[2][1] = 9;
        test[2][2] = 2;

//        for (int row = 0; row < test.length; row++) {
//            int sumInRow = 0;
//            for (int column = 0; column < test[row].length; column++) {
//                sumInRow += test[row][column];
//            }
//            temp.add(sumInRow);
//        }

//        for (int column = 0; column < test.length; column++) {
//            int sumInColumn = 0;
//            for (int row = 0; row < test[column].length; row++) {
//                sumInColumn += test[row][column];
//            }
//            temp.add(sumInColumn);
//        }
        int sumDiagFirst = 0;
        int sumDiagSecond = 0;
        for (int rowCol = 0; rowCol < test.length; rowCol++) {
            sumDiagFirst += test[rowCol][rowCol];
        }
        temp.add(sumDiagFirst);
        int column = 0;
        for (int row = test.length - 1; row >= 0; row--) {
            sumDiagSecond += test[row][column];
            column++;
        }
        temp.add(sumDiagSecond);
        System.out.println(temp);
    }
}


