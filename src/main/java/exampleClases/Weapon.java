package exampleClases;

public class Weapon {
    private int ammo;

    public Weapon(int ammo) {
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public boolean equals(Weapon weapon) {
        return this.ammo == weapon.getAmmo();
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "ammo=" + ammo +
                '}';
    }
}
