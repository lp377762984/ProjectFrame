package com.nettech.projectframe.model;

/**
 * Created by Administrator on 2018/1/10.
 */
public class User {
    private String name;
    private String psd;

    public User(String name, String psd) {
        this.name = name;
        this.psd = psd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
}
