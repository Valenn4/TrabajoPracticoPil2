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

        EpicDoubleHashMap<Number, Integer, String> epicDoubleHashMap = new EpicDoubleHashMap<>();
        /*
        epicDoubleHashMap.addFirstType(1, new Cat());
        epicDoubleHashMap.addFirstType(1, new Cat());
        epicDoubleHashMap.addSecondType(3, new Dog());

        epicDoubleHashMap.addBothTypes(12, new Cat(), new Dog());

        System.out.println(epicDoubleHashMap);


        System.out.println(epicDoubleHashMap.getFirstType(12));
        System.out.println(epicDoubleHashMap);*/

        epicDoubleHashMap.addBothTypes(1, 23, "asdada");
        epicDoubleHashMap.addBothTypes(3, 23, "asdada");
        epicDoubleHashMap.addBothTypes(4, 23, "asdada");
        epicDoubleHashMap.addBothTypes(6, 23, "asdada");
        epicDoubleHashMap.addFirstType(9,454);
        epicDoubleHashMap.addFirstType(92,454);
        epicDoubleHashMap.addFirstType(93,454);

        System.out.println();
        System.out.println(epicDoubleHashMap);
        System.out.println(epicDoubleHashMap.moreRepetitions());
        System.out.println(epicDoubleHashMap.howManyFromAKey(4));
    }
}
