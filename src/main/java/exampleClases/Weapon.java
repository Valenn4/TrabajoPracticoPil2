package exampleClases;

import java.util.Objects;

public class Weapon {
    private int ammo;

    public Weapon(int ammo) {
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon weapon)) return false;
        return getAmmo() == weapon.getAmmo();
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "ammo=" + ammo +
                '}';
    }
}
