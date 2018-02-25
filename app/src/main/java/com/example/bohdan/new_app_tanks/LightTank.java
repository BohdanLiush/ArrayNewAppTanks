package com.example.bohdan.new_app_tanks;

/**
 * Created by bohdan on 11.02.2018.
 */

public class LightTank extends Tank {
    public LightTank() {
        armor = 50;
        speed = 50;
        endurance = 100;
        chanceMiss = 60;
        precision = 80;
        shotPower = 75;
    }

    public LightTank(int speed, int sheetArmor, int endurance, int chanceMiss, int precision) {
        super(speed, sheetArmor, endurance, chanceMiss, precision);
    }
}
