package com.example.kbvora.arihant1;

/**
 * Created by jinansh12 on 18-03-15.
 */
public class magazines {
    String mname,address,editor,tele1;

    public magazines(String mname, String editor, String address, String tele1) {
        this.mname = mname;
        this.address = address;
        this.editor = editor;
        this.tele1 = tele1;

    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }

   }
