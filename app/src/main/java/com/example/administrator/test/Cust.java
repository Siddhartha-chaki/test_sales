package com.example.administrator.test;

import java.io.Serializable;

/**
 * Created by Administrator on 9/22/2017.
 */

public class Cust implements Serializable {
    int id;
    String nm,address,email;
    int mob;
    public Cust(String nm, String address, String email, int mob, int id){
        this.nm=nm;
        this.address=address;
        this.email=email;
        this.mob=mob;
        this.id=id;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMob(int mob) {
        this.mob = mob;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public int getMob() {
        return mob;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getNm() {
        return nm;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId() {
        return ""+id;
    }
}
