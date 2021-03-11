package com.info.notuygulamas;

import java.io.Serializable;

public class Notlar implements Serializable {
    private int not_id;
    private String ders_adi;
    private int not1;
    private int not2;

    public Notlar() {
    }

    public Notlar(int not_id, String ders_adi, int not1, int not2) {
        this.not_id = not_id;
        this.ders_adi = ders_adi;
        this.not1 = not1;
        this.not2 = not2;
    }

    public int getNot_id() {
        return not_id;
    }

    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    public int getNot1() {
        return not1;
    }

    public void setNot1(int not1) {
        this.not1 = not1;
    }

    public int getNot2() {
        return not2;
    }

    public void setNot2(int not2) {
        this.not2 = not2;
    }
}
