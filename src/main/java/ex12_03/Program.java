package ex12_03;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = {3, -1, 8, 4};

        System.out.println(sum(numbers, 0, 0, 0, 0));
        System.out.println(sum(numbers, 0, 0, 0, 10));
        System.out.println(sum(numbers, 0, 1, 0, 10));
        System.out.println(sum(numbers, 0, 1, -10, 10));
        System.out.println(sum(numbers, -1, 999, -10, 10));


    }

    //NAPISAC METODE KTORA SUMUJE ELEMENTY TABLICY MIEDZY
    //DOLNYM A GORNYM LIMITEM. TYLKO LICZBY MNIEJSZE LUB RÓWNE
    // INT LARGEST --I-- WIEKSZE ALBO ROWNE INT SMALLEST SA
    //SUMOWANE
    //METODA MUSI ROWNIEZ SPRAWDZAC CZY DOLNY I GORNY LIMIT
    //MAJA PRAWIDŁOWE INDEXY W TABLICY -- JEZELI FROMWHERE JEST
    //MNIEJSZE OD 0 TO FROMWHERE PRZYJMUJE WART 0
    //JEZELI TOWHERE JEST WIEKSZY NIZ ROZMIAR TABLICY
    //WTEDY TOWHERE STAJE SIE OSTATNIM INDEXEM TABLICY
    static int sum (int[] array, int fromWhere, int toWhere, int smallest, int largest){
        if (fromWhere < 0){
            fromWhere = 0;
        }
        if(toWhere > array.length){
            toWhere = array.length;
        }
        int sum = 0;
    for(int i = fromWhere; i < toWhere; i++){
        if(array[i] <= largest || array[i] >= smallest){
            sum += array[i];
        }
    }
        return sum;
    }
}
