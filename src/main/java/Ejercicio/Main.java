package Ejercicio;


public class Main {

    public static void main(String[] args) {
        /*
        Dog perro2 = new Dog();

        TestEpicDoubleHashMap<Number, Cat, Dog> item1 = new TestEpicDoubleHashMap<>();
        item1.setItemV(23, new Cat());
        item1.setItemT(2, new Dog());
        System.out.println(item1.toString());

         */

        EpicDoubleHashMap<Number, Cat, Dog> epicDoubleHashMap = new EpicDoubleHashMap<>();

        epicDoubleHashMap.addFirstType(1, new Cat());
        epicDoubleHashMap.addFirstType(1, new Cat());
        epicDoubleHashMap.addSecondType(3, new Dog());

        epicDoubleHashMap.addBothTypes(12, new Cat(), new Dog());

        System.out.println(epicDoubleHashMap);




    }
}
