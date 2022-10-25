package exampleClases;

public class Enemy {
    private int damage;

    public Enemy(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enemy enemy)) return false;
        return getDamage() == enemy.getDamage();
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "damage=" + damage +
                '}';
    }
}
