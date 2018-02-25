package com.example.bohdan.new_app_tanks;

import java.io.Serializable;

/** Created by bohdan on 11.02.2018. */

public class MiddleTank extends Tank implements Serializable {
    public String name;
    public String image;

    public MiddleTank() {
        armor = 100;
        speed = 80;
        endurance = 100;
        precision = 80;
        shotPower = 50;
    }
    public MiddleTank(String name){
        this.name = name;
        armor = 100;
        speed = 80;
        endurance = 100;
        precision = 80;
        shotPower = 50;
    }
   /* public MiddleTank(String name, String image) {
        this.name = name;
        armor = 100;
        speed = 80;
        endurance = 100;
        precision = 80;
        shotPower = 50;
        this.image = image;
    }*/

    public MiddleTank(int speed, int sheetArmor, int endurance, int precision) {
        super(speed, sheetArmor, endurance, precision);
    }


}
