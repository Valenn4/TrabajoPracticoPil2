package Ejercicio;

import javax.management.InvalidAttributeValueException;
import javax.management.openmbean.KeyAlreadyExistsException;
import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            }else {
                int count = 0;
                for(Map.Entry<K, V> entry : mapV.entrySet()) {
                    if (entry.getValue() == value){
                        count ++;
                    }
                }
                if (count <= 2){
                    mapV.put((K) key, value);
                }else {
                    throw new InvalidAttributeValueException("Invalidad Value");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void addSecondType(Number key, T value){
        try {
            if(mapT.containsKey(key) || mapV.containsKey(key)){
                throw new KeyAlreadyExistsException("The key already exists");
            }else {
                if (howManySecondType((Number) value) <= 2){
                    mapT.put((K) key, value);
                }else {
                    throw new InvalidAttributeValueException("Invalidad Value");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void addBothTypes(Number key,V valueV, T valueT){
        try {
            if(mapT.containsKey(key) || mapV.containsKey(key)){
                throw new KeyAlreadyExistsException("The key already exists");
            }else {
                int count = 0;
                for(Map.Entry<K, V> entry : mapV.entrySet()) {
                    if(mapV.containsKey(entry.getKey()) && mapT.containsKey(entry.getKey())){
                        if (entry.getValue().equals(valueV) && mapT.get(entry.getKey()).equals(valueT)){
                            count ++;
                        }
                    }
                }
                if (count <= 2){
                    mapV.put((K) key, valueV);
                    mapT.put((K) key, valueT);
                }else {
                    throw new InvalidAttributeValueException("Invalidad Value");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public V getFirstType(Number key){
        try {
            if (mapV.containsKey(key)){
                return mapV.get(key);
            } else {
                throw new KeyException("Map does not contain the key");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public T getSecondType(Number key){
        try {
            if (mapT.containsKey(key)){
                return mapT.get(key);
            } else {
                throw new KeyException("Map does not contain the key");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public void removeFirstType(Number key){
        try {
            if (mapV.containsKey(key)){
                mapV.remove(key);
            } else {
                throw new KeyException("Map does not contain the key");
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
    public void removeSecondType(Number key){
        try {
            if (mapT.containsKey(key)){
                mapT.remove(key);
            } else {
                throw new KeyException("Map does not cotain the key");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public String moreRepetitions(){
        if(mapV.size() > mapT.size()){
            return "There are more objects of the first type";
        }else if (mapV.size() < mapT.size()){
            return "There are more objects of the second type";
        } else {
            return "There are same objects of both types";
        }
    }


    private int howManyFirstType(Number key){
        int count = 0;
        for(Map.Entry<K, V> entry : mapV.entrySet()) {
            if (entry.getValue().equals(mapV.get(key))){
                count ++;
            }
        }
        return count;
    }

    private int howManySecondType(Number key){
        int count = 0;
        for(Map.Entry<K, T> entry : mapT.entrySet()) {
            if (entry.getValue().equals(mapT.get(key))){
                count ++;
            }
        }
        return count;
    }

    private int howManyBothTypes(Number key){
        int count = 0;
        for(Map.Entry<K, V> entry : mapV.entrySet()) {
            if(mapV.containsKey(entry.getKey()) && mapT.containsKey(entry.getKey())){
                if (entry.getValue().equals(mapV.get(key)) && mapT.get(entry.getKey()).equals(mapT.get(key))){
                    count ++;
                }
            }
        }
        return count;
    }

    public int howManyFromAKey(Number key){
        int count = 0;
        if (mapV.containsKey(key) && mapT.containsKey(key)){
            count = howManyBothTypes(key);
        }else if (mapV.containsKey(key) && !mapT.containsKey(key)){
            count = howManyFirstType(key);
        } else if (mapT.containsKey(key) && !mapV.containsKey(key)){
            count = howManySecondType(key);
        }
        return count;
    }

    //toString
    @Override
    public String toString() {
        return "EpicDoubleHashMap{" +
                "mapV=" + mapV +
                ", mapT=" + mapT +
                '}';
    }
}
