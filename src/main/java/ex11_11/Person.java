package ex11_11;

public class Person {

    private String name;
    private int age;
//KONSTRUKTOR MA ZAPWNIĆ ZE PODANE IMIE NIE BEDZIE NULLEM ALBO EMPTY,
    //DODATKOWO NIE MOZE PRZEKROCZYC 40 ZNAKOW-- WIEK POWINIEN ZAWIERAĆ
    //SIE W PRZEDZIALE 0 DO 120 LAT-- NIE SPELNIENIE WARUNKOW WYRZUCI
    //ILLEGALARGUMENTEXCEPTION
    public Person(String name, int age) {
        if(name == null){
            throw new IllegalArgumentException("Your name can not be null");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("Your name can not be empty");
        }
        if(name.length() > 40){
            throw new IllegalArgumentException("Your name can not be so long");
        }
        if(age < 0 || age > 120){
            throw new IllegalArgumentException("Your age should be between 0 and 120");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
