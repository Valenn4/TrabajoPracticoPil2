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
    public void addV(Number key, V value){
        mapV.put((K) key, value);
    }

    public void addT(Number key, T value){
        mapT.put((K) key, value);
    }

    public void addVandT(Number key,V valueV, T valueT){
        mapV.put((K) key, valueV);
        mapT.put((K) key, valueT);
    }

    //toString

}
