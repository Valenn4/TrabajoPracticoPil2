package exampleClases;

public class Enemy {
    private int damage;

    public Enemy(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public boolean equals(Enemy enemy){
        return this.damage == enemy.getDamage();
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "damage=" + damage +
                '}';
    }
}
