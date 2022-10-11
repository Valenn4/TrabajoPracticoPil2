package Ejercicio;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Dog perro2 = new Dog();

        EpicDoubleHashMap<Number, Cat, Dog> item1 = new EpicDoubleHashMap<>();
        item1.setItemV(23, new Cat());
        item1.setItemT(2, new Dog());
        System.out.println(item1.toString());

    }
}
