package exercise;

import javax.management.InvalidAttributeValueException;
import javax.management.openmbean.KeyAlreadyExistsException;
import java.security.KeyException;
import java.util.*;

public class EpicDoubleHashMap <K extends Number, V, T> {

    //attributes
    private Map<K,V> mapV;
    private Map<K,T> mapT;

    //constructor
    public EpicDoubleHashMap() {
        this.mapV = new HashMap<>();
        this.mapT = new HashMap<>();
    }

    //getters
    public Map<K, V> getMapV() {
        return mapV;
    }

    public Map<K, T> getMapT() {
        return mapT;
    }

    //methods

    //in add methods we can not do overwrite because we do not know the type of V and T
    public void addFirstType(Number key, V value){
        try {
            if(mapV.containsKey(key) || mapT.containsKey(key)){
                throw new KeyAlreadyExistsException("The key already exists");
            }else {
                int count = 0;
                for(Map.Entry<K, V> entry : mapV.entrySet()) {
                    if (entry.getValue().equals(value)){
                        count ++;
                    }
                }
                if (count <= 2){
                    mapV.put((K) key, value);
                }else {
                    throw new InvalidAttributeValueException("Value is already 3 times");
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
                int count = 0;
                for(Map.Entry<K, T> entry : mapT.entrySet()) {
                    if (entry.getValue().equals(value)){
                        count ++;
                    }
                }
                if (count <= 2){
                    mapT.put((K) key, value);
                }else {
                    throw new InvalidAttributeValueException("Value is already 3 times");
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
                    if(mapV.containsKey(entry.getKey()) && mapT.containsKey(entry.getKey()) &&
                            entry.getValue().equals(valueV) && mapT.get(entry.getKey()).equals(valueT)){
                        count ++;
                    }
                }
                if (count <= 2){
                    mapV.put((K) key, valueV);
                    mapT.put((K) key, valueT);
                }else {
                    throw new InvalidAttributeValueException("Values are already 3 times");
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
                throw new KeyException("Map does not contain the key or is in another value");
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
                throw new KeyException("Map does not contain the key or is in another value");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public void remove(Number key){
        try {
            if (mapV.containsKey(key) && mapT.containsKey(key)){
                mapV.remove(key);
                mapT.remove(key);
            } else if (mapV.containsKey(key)){
                mapV.remove(key);
            } else if (mapT.containsKey(key)){
                mapT.remove(key);
            } else {
                throw new KeyException("Map does not contain the key");
            }
        } catch (Exception e) {
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

    public int howManyRepeatedFromAKey(Number key){
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

    public boolean valuesRepeated(){
        List<Object> valuesList = new ArrayList<>();
        Set<Object> valuesSet = new HashSet<>();
        String value;

        for(Map.Entry<K, V> entry : mapV.entrySet()) {
            if(mapV.containsKey(entry.getKey()) && mapT.containsKey(entry.getKey())){
                value = "{" + entry.getValue().toString() + "," + mapT.get(entry.getKey()) + "}";
                valuesList.add(value);
                valuesSet.add(value);
            } else if(mapV.containsKey(entry.getKey()) && !mapT.containsKey(entry.getKey())){
                value = "{" + entry.getValue().toString() + "}";
                valuesList.add(value);
                valuesSet.add(value);
            } else if(!mapV.containsKey(entry.getKey()) && mapT.containsKey(entry.getKey())){
                value = "{" + mapT.get(entry.getKey()) + "}";
                valuesList.add(value);
                valuesSet.add(value);
            }
        }

        return valuesList.size() != valuesSet.size();
    }
    
    public boolean equals(EpicDoubleHashMap epicDoubleHashMap){
        return this.mapT.equals(epicDoubleHashMap.getMapT()) && mapV.equals(epicDoubleHashMap.getMapV());
    }

    //toString
    @Override
    public String toString() {
        return "Values{" +
                "mapV=" + mapV +
                ", mapT=" + mapT +
                '}';
    }
}
