package org.kopenom;

public class Kopenom {
    public String name;
    public String type;
    public int health;
    public int power;

    public Kopenom(String name, String type, int health, int power) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.power = power;
    }

    public int decreaseHealth(int damage) {
        this.health -= damage;
        return this.health;
    }

    public void attackKopenom(Kopenom other) {
        other.decreaseHealth(this.power);
    }

    public boolean isDead() {
        return this.health <= 0;
    }

}
