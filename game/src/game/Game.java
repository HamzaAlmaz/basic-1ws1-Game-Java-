/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package game;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hamza
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int turn = r.nextInt(2) + 1;
        String Player1Name, Player2Name;
        int hp1, hp2;
        if (turn == 1) {
            System.out.println("Oyuna İlk Player1 Başliycak ");
            hp1 = 100;
            hp2 = 110;

        } else {
            System.out.println("Oyuna İlk Player2 Başliycak ");
            hp1 = 110;
            hp2 = 100;
        }

        System.out.println("Player1 Name=");
        Player1Name = sc.nextLine();
        System.out.println("Player2 Name=");
        Player2Name = sc.nextLine();
        System.out.println(turn);
        players p1 = new players(Player1Name, hp1);
        players p2 = new players(Player2Name, hp2);
        players a, b;
        if (turn == 1) {
            a = p1;
            b = p2;
        } else {
            a = p2;
            b = p1;
        }

        System.out.println("Oyun Başlıyor");
        int healing1 = 0;
        int healing2 = 0;

        while (true) {
            System.out.println("turn: " + a.playerName);
            while (true) {
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println(" Fire: A  \n Healing: C \n superHealing: S(just 1 more +15)");
                String choice = sc.nextLine();
                if (choice.equals("A")) {
                    int dmg = r.nextInt(11);
                    System.out.println("dmg: "+dmg);
                    b.takedmg(dmg);
                    System.out.println(b.playerName+" hp: "+b.hp);
                    System.out.println( a.playerName+" hp:"+a.hp);
                    if (dmg > 4) {
                        break;
                    }
                    System.out.println("tekrar sıra"+a.playerName);
                } else if (choice.equals("C")) {
                    int heal = r.nextInt(16);
                    System.out.println("Heal: " +heal);
                    System.out.println(a.playerName+"Hp:" +a.hp);
                    a.healing(heal);
                    if (heal > 6) {
                        break;
                    }
                    System.out.println("tekrar sıra "+a.playerName);
                } else if (choice.equals("S")) {
                    if(healing1!=0){
                        System.out.println("1 Defa kullandınız");
                        continue;
                    }
                    a.superHeling();
                    System.out.println(a.playerName+"Hp:" +a.hp);
                    healing1++;
                    break;
                } else {
                    System.out.println("Yanliş şeçenek");

                }
                if(b.hp<=0){
                    break;
                }
            }
            
            if(b.hp<=0){
                   System.out.println("win:"+a.playerName);
                   break;
                }
            System.out.println("turn: " + b.playerName);
            while(true){
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println(" Fire: A  \n Healing: C \n superHealing: S(just 1 more +15)");
                String choice = sc.nextLine();
                
                if (choice.equals("A")) {
                    int dmg = r.nextInt(11);
                    System.out.println("dmg: "+dmg);
                    System.out.println(b.playerName+" hp: "+b.hp);
                    System.out.println( a.playerName+" hp:"+a.hp);
                    a.takedmg(dmg);
                    if (dmg > 4) {
                        break;
                    }
                    System.out.println("tekrar sıra "+b.playerName);
                } else if (choice.equals("C")) {
                    int heal = r.nextInt(16);
                    System.out.println("Heal:"+heal);
                    b.healing(heal);
                   System.out.println(b.playerName+" hp: "+b.hp);
                    if (heal > 6) {
                        break;
                    }
                    System.out.println("tekrar sıra " +b.playerName);
                } else if (choice.equals("S") ) {
                    if(healing2!=0){
                        System.out.println("1 Defa kullandınız");
                        continue;
                    }
                    b.superHeling();
                    System.out.println(b.playerName+" hp: "+b.hp);
                    healing2++;
                    break;
                } else {
                    System.out.println("Yanliş şeçenek");

                }
                
            if(a.hp<=0){
                    break;
                }
            }
            
            if(a.hp<=0){
                   System.out.println("win:"+b.playerName);
                   break;
                }
                
            }
        }

}

