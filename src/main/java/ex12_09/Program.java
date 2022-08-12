package ex12_09;

public class Program {

    public static void main(String[] args) {
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));
        System.out.println("--------------------");
        int[][] matrix1 = {{3, 2, 7, 6}, {2, 4, 1, 0}, {3, 2, 1, 0}};
        System.out.println(arrayAsString(matrix1));
    }

    //METODA KTORA ZWROCI ZAWARTOSC TABLICY DWUWYMIAROWEJ W POSTACI STRINGA
    public static String arrayAsString(int[][] array) {
//TWORZE OBIEKT STRINGBUILDERA W KTORY BEDZIE ZAPISYWANY KAZDY RZAD
        StringBuilder builder = new StringBuilder();
        //PIERWSZA PETLA PRZELATUJE PRZEZ RZEDY
        for (int i = 0; i < array.length; i++) {
            //DRUGA PETLA PRZELATUJE PRZEZ KOLUMNY W RZEDZIE
            for (int j = 0; j < array[i].length; j++) {
                //NASTEPNIE ZAPISUJE W BUILDERZE POLA
                builder.append(array[i][j]);
            }
            //DODAJAC PO KAZDYM RZEDZIE PRZEJSCIE DO NASTEPNEJ LINII
            builder.append("\n");
        }
        //BUILDER JEST PRZETWARZANY NA STRING I ZAPISYWANY DO ZMIENNEJ
        //KTORA NASTEPNIE JEST ZWRACANA JAKO WYNIK METODY
        String returnThis = String.valueOf(builder);
        return returnThis;
    }
}
