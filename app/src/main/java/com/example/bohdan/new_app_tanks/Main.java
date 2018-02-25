package com.example.bohdan.new_app_tanks;

/**  Created by bohdan on 11.02.2018. */

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MiddleTank [] tanksGreen = new MiddleTank[15];
        for (int i = 0; i < tanksGreen.length; i++){
            tanksGreen[i] = new MiddleTank("Jack"+i);
        }

        for (int i = 0; i < tanksGreen.length; i++) {
            System.out.println(tanksGreen[i].name);
        }
       /* final MiddleTank tank0 = new MiddleTank("one");
        final MiddleTank tank1 = new MiddleTank("two");*/

        /*new Thread(new Runnable() {
            public void run() {
                while (tank0.endurance > 0 && tank1.endurance > 0) {
                    System.out.println("Player 1 health: " + tank0.endurance + " ***  Player 2 health: " + tank1.endurance);
                    tank0.fireTank(tank1);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (tank0.endurance > 0)

                    System.out.println("The winner is: " + tank0.name);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (tank0.endurance > 0 && tank1.endurance > 0) {
                    System.out.println("Player 1 health: " + tank0.endurance + " ***  Player 2 health: " + tank1.endurance);
                    System.out.println("------------------------");
                    tank1.fireTank(tank0);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("------------------------ * ---------------------------");
                if (tank1.endurance > 0)
                    System.out.println("The winner is: " + tank1.name);
            }
        }).start();*/
    }
}
