package Ejercicio;

import java.util.*;

class EpicDoubleHashMap<K extends Number, V, T>{

    private Map<K, Object> map;

    public EpicDoubleHashMap(){
        this.map = new HashMap<>();
    }

    public Object obtenerV(Number key) {
        return map.get(key);
    }

    /*
    public Object obtenerT(Number key) {
        return map.get(key)[1];
    }*/

    public Object deleteItem(Number key){
        if(map.containsKey(key)){
            return map.remove(key);
        } else {
            return "No existe un item con la key: " + key;
        }
    }

    public void setItemV(K key, V value) {
        if(map.containsKey(key)){
            System.out.println("Ya existe un item con la misma key: " + key);
        } else {
            map.put(key, value);
        }
    }

    public void setItemT(K key, T value) {
        if(map.containsKey(key)){
            System.out.println("Ya existe un item con la misma key: " + key);
        } else {
            map.put(key, value);
        }
    }

    @Override
    public String toString() {

        return map.toString();
    }
}


/*
class Generico<T>{
    private List<T> data;

    public Generico() {
        this.data = new ArrayList<T>();
    }

    public List<T> getData(){
        return data;
    }

    public List<T> setData(String agregar) {
        data.add((T) agregar);
        return data;
    }

    public List<T> deleteData(int index){
        data.remove(index);

        return data;
    }

    public int cantidadElements(){
        return data.size();
    }
}
*/