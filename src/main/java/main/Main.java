package main;

import epicDoubleHashMap.EpicDoubleHashMap;
import exampleClases.Enemy;
import exampleClases.Player;
import exampleClases.Weapon;

public class Main {
    public static void main(String[] args) {

        EpicDoubleHashMap<Integer, Player, Weapon> epicDoubleHashMap = new EpicDoubleHashMap<>();
        EpicDoubleHashMap<Float, Enemy, Weapon> epicDoubleHashMap1 = new EpicDoubleHashMap<>();
        EpicDoubleHashMap<Byte, Player, Enemy> epicDoubleHashMap2 = new EpicDoubleHashMap<>();

        //add First type
        epicDoubleHashMap.addFirstType(1, new Player("Juan"));
        epicDoubleHashMap1.addFirstType(1.0f, new Enemy(10));
        epicDoubleHashMap2.addFirstType((byte) 1, new Player("Pedro"));

        //add Second types
        epicDoubleHashMap.addSecondType(2, new Weapon(10));
        epicDoubleHashMap1.addSecondType(2f, new Weapon(15));
        epicDoubleHashMap2.addSecondType((byte) 2, new Enemy(12));

        //add Both types
        epicDoubleHashMap.addBothTypes(3, new Player("Pedro"), new Weapon(23));
        epicDoubleHashMap1.addBothTypes(3f, new Enemy(123), new Weapon(123));
        epicDoubleHashMap2.addBothTypes((byte) 3, new Player("Paulo"), new Enemy(21));

        //show added items
        System.out.println("Show added items");
        System.out.println("epicDoubleHashMap: " + epicDoubleHashMap);
        System.out.println("epicDoubleHashMap1: " + epicDoubleHashMap1);
        System.out.println("epicDoubleHashMap2: " + epicDoubleHashMap2);

        //get First
        System.out.println("Get value from a key");
        System.out.println("Get first Value to Key 1 from epicDoubleHashMap: " +
                epicDoubleHashMap.getFirstType(1));
        System.out.println("Get first Value to Key 1 from epicDoubleHashMap: " +
                epicDoubleHashMap1.getFirstType(1.0f));
        System.out.println("Get first Value to Key 1 from epicDoubleHashMap2: " +
                epicDoubleHashMap2.getFirstType((byte) 1));

        //get Second
        System.out.println("Get second Value to Key 1 from epicDoubleHashMap: " +
                epicDoubleHashMap.getSecondType(1));
        System.out.println("Get second Value to Key 1 from epicDoubleHashMap: " +
                epicDoubleHashMap1.getFirstType(1.0f));
        System.out.println("Get second Value to Key 1 from epicDoubleHashMap2: " +
                epicDoubleHashMap2.getSecondType((byte) 1));

        //remove
        System.out.println("Remove items with Key");
        epicDoubleHashMap.remove(1);
        epicDoubleHashMap1.remove(2.0f);
        epicDoubleHashMap2.remove((byte) 3);
        System.out.println("epicDoubleHashMap: " + epicDoubleHashMap);
        System.out.println("epicDoubleHashMap1: " + epicDoubleHashMap1);
        System.out.println("epicDoubleHashMap2: " + epicDoubleHashMap2);

        //exceptions
        System.out.println("\nExceptions");
        //add an item with an existing key
        System.out.println("Add an item with an existing key");
        epicDoubleHashMap.addFirstType(10, new Player("Carlos"));
        epicDoubleHashMap.addSecondType(10, new Weapon(12));
        epicDoubleHashMap.addBothTypes(10, new Player("Steve"), new Weapon(120));
        //remove with missing key
        System.out.println("Remove with missing key");
        epicDoubleHashMap.remove(4);
        //add an item with values repeated 3 times;
        System.out.println("Add an item with values repeated 3 times");
        epicDoubleHashMap.addFirstType(100,new Player("Hello"));
        epicDoubleHashMap.addFirstType(200,new Player("Hello"));
        epicDoubleHashMap.addFirstType(300,new Player("Hello"));
        epicDoubleHashMap.addBothTypes(400, new Player("Hello"), new Weapon(15));
        epicDoubleHashMap.addFirstType(500,new Player("Hello"));
        System.out.println(epicDoubleHashMap);
        //get a missing key
        System.out.println("Get a missing key");
        epicDoubleHashMap.getFirstType(101);

        //auxiliary methods
        System.out.println("\nAuxiliary methods");
        EpicDoubleHashMap<Integer, Player, Weapon> epicDoubleHashMap3 = new EpicDoubleHashMap<>();
        //more repetitions
        System.out.println("More repetitions");
        System.out.println(epicDoubleHashMap3.moreRepetitions());
        epicDoubleHashMap3.addFirstType(50, new Player("Player1"));
        System.out.println(epicDoubleHashMap3.moreRepetitions());
        epicDoubleHashMap3.remove(50);
        epicDoubleHashMap3.addSecondType(50, new Weapon(1));
        System.out.println(epicDoubleHashMap3.moreRepetitions());
        epicDoubleHashMap3.remove(50);
        //howManyRepeatedFromAKey
        epicDoubleHashMap3.addFirstType(40, new Player("Player2"));
        epicDoubleHashMap3.addFirstType(41, new Player("Player2"));
        epicDoubleHashMap3.addBothTypes(42, new Player("Player2"), new Weapon(5));
        System.out.println("Values repeated from key 40: " + epicDoubleHashMap3.howManyRepeatedFromAKey(40));
        epicDoubleHashMap3.addBothTypes(70, new Player("Player3"), new Weapon(1));
        epicDoubleHashMap3.addBothTypes(71, new Player("Player3"), new Weapon(1));
        epicDoubleHashMap3.addBothTypes(72, new Player("Player3"), new Weapon(5));
        epicDoubleHashMap3.addBothTypes(73, new Player("Player3"), new Weapon(1));
        System.out.println("Values repeated from key 70: " + epicDoubleHashMap3.howManyRepeatedFromAKey(70));
        //values repeated
        System.out.println(epicDoubleHashMap3.valuesRepeated() ? "There are values repeated" :
                "There are not values repeated");
        System.out.println(new EpicDoubleHashMap<Integer, Object, Object>());
    }
}
