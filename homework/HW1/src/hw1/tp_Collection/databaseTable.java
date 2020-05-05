package hw1.tp_Collection;

import java.util.HashMap;
import java.util.Map;

public class databaseTable <K, V>{
    private Map<K, V> dbTable = new HashMap<K, V>();
    public boolean Create(K key, V value){
        if(key == null){
            return false;
        }
        dbTable.put(key, value);
        return true;
    }
    public V Retrieve(K key){
        return dbTable.get(key);
    }

    public boolean Update(K key, V value){
        if(key == null){
            return false;
        }
        dbTable.put(key, value);
        return true;
    }

    public boolean Delete(K key){
        if(key == null){
            return false;
        }
        if(dbTable.containsKey(key)){
            dbTable.remove(key);
            return true;
        }
        else {
            return false;
        }
    }
}
