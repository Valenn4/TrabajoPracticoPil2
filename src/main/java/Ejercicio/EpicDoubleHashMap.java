package Ejercicio;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.security.KeyException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EpicDoubleHashMap <K extends Number, V, T> {

    //attributes
    private Map<K,Object[]> map;

    //constructor
    public EpicDoubleHashMap() {
        this.map = new HashMap<>();
    }

    //getter
    public Map<K, Object[]> getMap() {
        return map;
    }

    //methods
    public void addV(Number key, V value){
        try {
            if (map.containsKey(key)) throw new KeyAlreadyExistsException ("The key already exists");
            map.put((K) key, new Object[]{value});
        } catch (KeyAlreadyExistsException e) {
            System.out.println(e);
        }
    }

    public void addT(Number key, T value){
        try {
            if (map.containsKey(key)) throw new KeyAlreadyExistsException ("The key already exists");
            map.put((K) key, new Object[]{value});
        } catch (KeyAlreadyExistsException e) {
            System.out.println(e);
        }
    }

    public void addVandT(Number key, V firstValue, T secondValue){
        try {
            if (map.containsKey(key)) {
                throw new KeyAlreadyExistsException ("The key already exists");
            } else {
                map.put((K) key, new Object[]{firstValue, secondValue});
            }
        } catch (KeyAlreadyExistsException e) {
            System.out.println("you can not add an object with the same key");
        }
    }
    /*
    public V getV(Number key){
        try{
            if (map.containsKey(key)){
                String clase = map.get(key)[0].getClass().getName();
                if(clase.equals("Ejercicio."+Cat.class))
                return map.get(key)[0];
            } else {
                throw new Error("Can not get V");
            }
        } catch (Error e){
            System.out.println(e);
        } finally {
            return null;
        }
    }
    */
    public void removeItem(Number key){
        try{
            if (!map.containsKey(key)){
                throw new KeyException("Key does not exists");
            } else {
                map.remove(key);
            }
        }
        catch (KeyException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {

        String aux = "EpicDoubleHashMap\n";

        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Number key = (Number)entry.getKey();
            Object[] value = (Object[])entry.getValue();
            aux += "\nKey = " + key + ", Values = ";
            for (Object el: value) {
                aux += el + "\t";
            }
        }

        return aux;
    }
}
