package hw1.Serializable;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String NAME;
    private long ID;
    public String getNAME(){
        return NAME;
    }
    public void setNAME(String name){
        this.NAME = name;
    }
    public long getID(){
        return ID;
    }
    public void setID(long id){
        this.ID = id;
    }
}
