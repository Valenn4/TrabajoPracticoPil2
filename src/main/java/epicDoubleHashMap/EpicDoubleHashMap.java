package epicDoubleHashMap;

import javax.management.InvalidAttributeValueException;
import javax.management.openmbean.KeyAlreadyExistsException;
import java.security.KeyException;
import java.util.*;

public class EpicDoubleHashMap <K extends Number, V, T> {

    //attributes
    private Map<K,V> mapV = new HashMap<>();
    private Map<K,T> mapT = new HashMap<>();

    //methods

    private int howManyFirstType(V value){
        int count = 0;
        for(Map.Entry<K, V> entry : mapV.entrySet()) {
            if (entry.getValue().equals(value) && !mapT.containsKey(entry.getKey())){
                count ++;
            }
        }
        return count;
    }

    private int howManySecondType(T value){
        int count = 0;
        for(Map.Entry<K, T> entry : mapT.entrySet()) {
            if (entry.getValue().equals(value) && !mapV.containsKey(entry.getKey())){
                count ++;
            }
        }
        return count;
    }

    private int howManyBothTypes(V valueV, T valueT){
        int count = 0;
        for(Map.Entry<K, V> entry : mapV.entrySet()) {
            if(mapV.containsKey(entry.getKey()) && mapT.containsKey(entry.getKey()) &&
                    entry.getValue().equals(valueV) && mapT.get(entry.getKey()).equals(valueT)){
                count ++;
            }
        }
        return count;
    }

    //in add methods we can not do overwrite because we do not know the type of V and T
    public void addFirstType(K key, V value){
        try {
            if(mapV.containsKey(key) || mapT.containsKey(key)){
                throw new KeyAlreadyExistsException("The key " + key + " already exists");
            }else {
                if (howManyFirstType(value) <= 2){
                    mapV.put(key, value);
                }else {
                    throw new InvalidAttributeValueException("Value " + value + " is already 3 times");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void addSecondType(K key, T value){
        try {
            if(mapT.containsKey(key) || mapV.containsKey(key)){
                throw new KeyAlreadyExistsException("The key " + key + " already exists");
            }else {
                if (howManySecondType(value) <= 2){
                    mapT.put(key, value);
                }else {
                    throw new InvalidAttributeValueException("Value is already 3 times");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void addBothTypes(K key,V valueV, T valueT){
        try {
            if(mapT.containsKey(key) || mapV.containsKey(key)){
                throw new KeyAlreadyExistsException("The key " + key + " already exists");
            }else {
                if (howManyBothTypes(valueV, valueT) <= 2){
                    mapV.put(key, valueV);
                    mapT.put(key, valueT);
                }else {
                    throw new InvalidAttributeValueException("Values are already 3 times");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public V getFirstType(K key){
        try {
            if (mapV.containsKey(key)){
                return mapV.get(key);
            } else {
                throw new KeyException("Map does not contain the key " +  key + " or is in in T value");
            }
        } catch (KeyException e){
            System.out.println(e);
        }
        return null;
    }

    public T getSecondType(K key){
        try {
            if (mapT.containsKey(key)){
                return mapT.get(key);
            } else {
                throw new KeyException("Map does not contain the key " +  key + " or is in V value");
            }
        } catch (KeyException e){
            System.out.println(e);
        }
        return null;
    }

    public void remove(K key){
        try {
            if (mapV.containsKey(key) && mapT.containsKey(key)){
                mapV.remove(key);
                mapT.remove(key);
            } else if (mapV.containsKey(key)){
                mapV.remove(key);
            } else if (mapT.containsKey(key)){
                mapT.remove(key);
            } else {
                throw new KeyException("Map does not contain the key " + key);
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

    public int howManyRepeatedFromAKey(K key){
        Set<K> keysVAndT = mapT.keySet();
        keysVAndT.retainAll(mapV.keySet());
        int count = 0;
        if(mapV.containsKey(key) && mapT.containsKey(key)){
            for(K element:keysVAndT){
                if(mapV.get(element).equals(mapV.get(key)) && mapT.get(element).equals(mapT.get(key))){ count++;}
            }
        } else if (mapV.containsKey(key) && !mapT.containsKey(key)){
            for(K element:mapV.keySet()) {
                if (mapV.containsKey(element) && !mapT.containsKey(element) &&
                        mapV.get(key).equals(mapV.get(element))) {
                        count++;
                }
            }
        } else if (mapT.containsKey(key) && !mapV.containsKey(key)){
            for(K element:mapT.keySet()) {
                 if (mapT.containsKey(element) && !mapV.containsKey(element) &&
                         mapT.get(key).equals(mapT.get(element))) {
                        count++;
                }
            }
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


    //toString
    @Override
    public String toString() {
        Set<K> mergedKeys = new TreeSet<>();
        mergedKeys.addAll(mapV.keySet());
        mergedKeys.addAll(mapT.keySet());

        String string = "Values: {\n";
        if (mergedKeys.size() == 0){
            string += "No values\n}";
        } else {
            for (K key: mergedKeys) {
                string += "[Key: " + key;
                if (mapV.containsKey(key)){
                    string += " | V value: " + mapV.get(key);
                }
                if (mapT.containsKey(key)){
                    string += " | T value: " + mapV.get(key);
                }
                string += " ];\n";
            }
            string+= " }";
        }

        return string;
    }
}
