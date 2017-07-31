package com.erickogi14gmail.rog.Bible;

/**
 * Created by kimani kogi on 7/28/2017.
 */

public class BiblePojo {
       private  int id;
       private      int b;
       private      int c;
       private      int v;
       private      String t;

    public BiblePojo() {
    }

    public BiblePojo(int id, int b, int c, int v, String t) {
        this.id = id;
        this.b = b;
        this.c = c;
        this.v = v;
        this.t = t;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}
