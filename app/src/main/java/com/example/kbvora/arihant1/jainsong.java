package com.example.kbvora.arihant1;

/**
 * Created by KBVora on 01-03-2015.
 */
public class jainsong {
    private String jainsongs_name;
private  String jainsongs_audiopath;

    public String getJainsongs_audiopath() {
        return jainsongs_audiopath;
    }

    public void setJainsongs_audiopath(String jainsongs_audiopath) {
        this.jainsongs_audiopath = jainsongs_audiopath;
    }

    public jainsong(String jainsongs_name, String jainsongs_audiopath) {
        this.jainsongs_name = jainsongs_name;
        this.jainsongs_audiopath = jainsongs_audiopath;
    }

    public String getJainsongs_name() {
        return jainsongs_name;
    }

    public void setJainsongs_name(String jainsongs_name) {
        this.jainsongs_name = jainsongs_name;
    }

    public jainsong(String jainsongs_name) {

        this.jainsongs_name = jainsongs_name;
    }
}
