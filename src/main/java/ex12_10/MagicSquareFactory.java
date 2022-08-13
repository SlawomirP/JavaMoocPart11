package ex12_10;

public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        //MagicSquare square = new MagicSquare(size);
        MagicSquare magicSquare = new MagicSquare(size);

        int row = 0;
        int column = size / 2;
        magicSquare.placeValue(row, column, 1);
        for (int k = 2; k <= size * size; k++) {
            int currentRow = row;
            int currentColumn = column;
            row -= 1;
            column += 1;
            if (row < 0) {
                row = size - 1;
            }
            if (column > size - 1) {
                column = 0;
            }
            if (magicSquare.readValue(row, column) > 0) {
                row = currentRow + 1;
                column = currentColumn;
            }
            magicSquare.placeValue(row, column, k);
        }
        return magicSquare;
    }
}