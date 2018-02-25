package com.example.bohdan.new_app_tanks;

import java.util.Random;

/** Created by bohdan on 11.02.2018. */

public class Tank implements Runnable {
    public  String name;


    public int speed;
    public int armor;
    public int endurance;
    public int chanceMiss;
    public int precision;

    public MiddleTank tank0, tank1;

    public int shotPower;
    int count = 0;
    public Tank() {
    }

    public Tank(String name) {
        this.name = name;
    }

    public Tank(int speed, int armor, int endurance, int chanceMiss, int precision) {
        this.speed = speed;
        this.armor = armor;
        this.endurance = endurance;
        this.chanceMiss = chanceMiss;
        this.precision = precision;
    }

    public Tank(int speed, int armor, int endurance, int precision) {
        this.speed = speed;
        this.armor = armor;
        this.endurance = endurance;
        this.precision = precision;
    }

    public Tank(int speed, int armor, int endurance) {
        this.speed = speed;
        this.armor = armor;
        this.endurance = endurance;
    }

    public void fireTank(Tank tank1) {
        //this.tank0 = (MiddleTank) tank0;
        this.tank1 = (MiddleTank) tank1;
        System.out.println("shooting: - " + this.name);
        Random random = new Random();
        int a = random.nextInt(100);
        if (a <= 80) { // перевірка на точність. Середня точність у танків - 80
            tank1.receiveProjBullet(this.shotPower);         // має передаватись в параметр постріл першого танку який стріляє
            count++;
        }
        else
            System.out.println("miss...");
    }

    public void receiveProjBullet(int tank0_shotpower) { // ми передали сюди постріл,
        // але він поки не використовується
        Random random = new Random();
        //int a = random.nextInt(100);
        int shot = random.nextInt(tank0_shotpower);
        if (shot > 20)  // перевірка на промах (увернеться чи не увернеться від пострілу)
            chanceToBreakArmor(shot);
        else
            System.out.println("...don't break");
    }

    public void chanceToBreakArmor(int shot) { // метод шанс на пробиття броні
        Random random = new Random();
        int a = 100 - random.nextInt(this.armor); // передається броня танка в який стріляють
        if (a < 0)
            a = 0;
        System.out.println("chanceToBreakArmor = " + a);
        receiveDamage(shot);
    }

    public void receiveDamage(int shot) { // метод урон по танку
        Random random = new Random();
        /*int a = random.nextInt(tank0.shotPower);*/  // передається постріл танка, який вистрілив
        System.out.println("random shot: " + shot);
        this.endurance = this.endurance - shot;
        //return this.tank1.endurance;
        if (this.endurance < 0) {
            endurance = 0;
            System.out.println(this.name + "...death");
            //isDead = true;
        }
        System.out.println("health: " + this.endurance);
        System.out.printf("count " + count + "\n");
    }

    @Override
    public void run() {

    }
}

