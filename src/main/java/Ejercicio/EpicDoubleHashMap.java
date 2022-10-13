package Ejercicio;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.security.KeyException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EpicDoubleHashMap <K extends Number, V, T> {

    //attributes
    private Map<K,V> mapV;
    private Map<K,T> mapT;

    //constructor


    public EpicDoubleHashMap() {
        this.mapV = new HashMap<>();
        this.mapT = new HashMap<>();
    }

    //getter

    //methods
    public void addFirstType(Number key, V value){
        try {
            if(mapV.containsKey(key) || mapT.containsKey(key)){
                throw new KeyAlreadyExistsException("The key already exists");
            }
            mapV.put((K) key, value);
        } catch (Exception e){
            System.out.println(e);
        }

    }

    public void addSecondType(Number key, T value){
        try {
            if(mapV.containsKey(key) || mapT.containsKey(key)){
                throw new KeyAlreadyExistsException("The key already exists");
            }
            mapT.put((K) key, value);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void addBothTypes(Number key,V valueV, T valueT){
        try {
            if(mapV.containsKey(key) || mapT.containsKey(key)){
                throw new KeyAlreadyExistsException("The key already exists");
            }
            mapV.put((K) key, valueV);
            mapT.put((K) key, valueT);

        } catch (Exception e){
            System.out.println(e);
        }
    }

    //toString

}
