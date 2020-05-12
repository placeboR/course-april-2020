package org.hw2.beans;

import java.io.Serializable;

public class Department implements Serializable {
    private int depid;
    private String name;
    private String loc;

    public Department() {
        super();
    }

    public Department(int depid, String name, String loc) {
        super();
        this.depid = depid;
        this.name = name;
        this.loc = loc;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depid=" + depid +
                ", name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
