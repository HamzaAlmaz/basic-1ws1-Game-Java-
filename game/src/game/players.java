/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author hamza
 */
public   class  players  {

    String playerName;
    int hp;

    public players(String playerName, int hp) {
        this.playerName = playerName;
        this.hp = hp;

    }
    public void takedmg(int dmg) {
        this.hp = this.hp - dmg;
    }

    public void healing(int hp) {
        this.hp = this.hp + hp;
    }

    public void superHeling() {
        this.hp = this.hp + 15;
    }

}
