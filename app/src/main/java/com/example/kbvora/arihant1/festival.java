package com.example.kbvora.arihant1;

/**
 * Created by KBVora on 07-02-2015.
 */
public class festival {
    private String festivalname;
    private String description;

    public String getFestivalname() {
        return festivalname;
    }

    public void setFestivalname(String festivalname) {
        this.festivalname = festivalname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public festival(String festivalname, String description) {
        this.festivalname = festivalname;
        this.description = description;
    }
}
