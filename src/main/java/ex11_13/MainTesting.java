package ex11_13;

public class MainTesting {
    public static void main(String[] args) {
        SaveableDictionary dictionary = new SaveableDictionary("src/words.txt");
        boolean wasSuccessful = dictionary.load();

        if (wasSuccessful) {
            System.out.println("Successfully loaded the dictionary from file");
        }

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("ohjelmointi"));
        System.out.println(dictionary.translate("alla oleva"));
    }
}
