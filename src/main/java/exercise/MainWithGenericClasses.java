package exercise;


public class MainWithGenericClasses {

    public static void main(String[] args) {

        EpicDoubleHashMap<Integer, Integer, String> epicDoubleHashMap = new EpicDoubleHashMap<>();
        EpicDoubleHashMap<Integer, Integer, String> epicDoubleHashMap1 = new EpicDoubleHashMap<>();
        EpicDoubleHashMap<Integer, Integer, String> epicDoubleHashMap2 = new EpicDoubleHashMap<>();

        //add First
        epicDoubleHashMap.addFirstType(1, 1);
        epicDoubleHashMap1.addFirstType(1, 1);
        epicDoubleHashMap2.addFirstType(1, 2);

        //add Second
        epicDoubleHashMap.addSecondType(2, "Red");
        epicDoubleHashMap1.addSecondType(2, "Red");
        epicDoubleHashMap2.addSecondType(2, "Blue");

        //add Both
        epicDoubleHashMap.addBothTypes(3, 10, "Messi");
        epicDoubleHashMap1.addBothTypes(3, 10, "Messi");
        epicDoubleHashMap2.addBothTypes(3, 5, "Paredes");

        //show added items
        System.out.println("epicDoubleHashMap: " + epicDoubleHashMap);
        System.out.println("epicDoubleHashMap1: " + epicDoubleHashMap1);
        System.out.println("epicDoubleHashMap2: " + epicDoubleHashMap2);

        //get First
        System.out.println("Get first Value to Key 1 from epicDoubleHashMap: " +
                epicDoubleHashMap.getFirstType(1));
        System.out.println("Get first Value to Key 1 from epicDoubleHashMap2: " +
                epicDoubleHashMap2.getFirstType(3));

        //get Second
        System.out.println("Get second Value to Key 1 from epicDoubleHashMap: " +
                epicDoubleHashMap.getSecondType(2));
        System.out.println("Get second Value to Key 1 from epicDoubleHashMap2: " +
                epicDoubleHashMap2.getSecondType(3));

        //remove
        epicDoubleHashMap2.remove(1);
        epicDoubleHashMap2.remove(3);
        System.out.println("epicDoubleHashMap2: " + epicDoubleHashMap2);

        //exceptions
        //add an item with an existing key
        epicDoubleHashMap.addFirstType(1, 10);
        epicDoubleHashMap.addSecondType(1, "Ten");
        epicDoubleHashMap.addBothTypes(1, 10, "Ten");
        //remove with missing key
        epicDoubleHashMap.remove(4);
        //add an item with values repeated 3 times;
        epicDoubleHashMap2.addBothTypes(20, 20, "Twenty");
        epicDoubleHashMap2.addBothTypes(21, 20, "Twenty");
        epicDoubleHashMap2.addFirstType(22, 20);
        epicDoubleHashMap2.addSecondType(23, "Twenty");
        epicDoubleHashMap2.addBothTypes(24, 20, "Twenty");
        epicDoubleHashMap2.addBothTypes(25, 20, "Twenty");
        //get a missing key
        epicDoubleHashMap.getFirstType(100);
        epicDoubleHashMap.getSecondType(200);

        //auxiliary methods
        //more repetitions
        System.out.println(epicDoubleHashMap.moreRepetitions());
        epicDoubleHashMap.addFirstType(50, 50);
        System.out.println(epicDoubleHashMap.moreRepetitions());
        epicDoubleHashMap.remove(50);
        epicDoubleHashMap.addSecondType(50, "50");
        System.out.println(epicDoubleHashMap.moreRepetitions());
        epicDoubleHashMap.remove(50);
        //howManyRepeatedFromAKey
        epicDoubleHashMap2.addFirstType(40, 40);
        epicDoubleHashMap2.addFirstType(41, 40);
        epicDoubleHashMap2.addFirstType(42, 40);
        System.out.println(epicDoubleHashMap2.howManyRepeatedFromAKey(40));
        epicDoubleHashMap2.addBothTypes(70, 7, "Seven");
        epicDoubleHashMap2.addBothTypes(71, 7, "Seven");
        epicDoubleHashMap2.addBothTypes(72, 7, "Seven");
        System.out.println(epicDoubleHashMap2.howManyRepeatedFromAKey(70));
        //values repeated
        System.out.println(epicDoubleHashMap.valuesRepeated());
        epicDoubleHashMap.addFirstType(12, 1);
        System.out.println(epicDoubleHashMap.valuesRepeated());

    }
}
