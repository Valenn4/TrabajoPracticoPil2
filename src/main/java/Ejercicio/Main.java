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

        epicDoubleHashMap.addV(1, new Cat());
        epicDoubleHashMap.addV(1, new Cat());
        epicDoubleHashMap.addT(3, new Dog());

        epicDoubleHashMap.addVandT(12, new Cat(), new Dog());
        epicDoubleHashMap.addTandV(14, new Dog(), new Cat());

        System.out.println(epicDoubleHashMap);

        epicDoubleHashMap.getT(1);
        epicDoubleHashMap.getT(3);
        epicDoubleHashMap.getT(12);
        epicDoubleHashMap.getT(14);



    }
}
