class CustomCharacter {
    String name;
    String characterClass;
    CustomWeapon weapon;
    int health;
    int mana;

    public CustomCharacter(String name, String characterClass, CustomWeapon weapon, int health, int mana) {
        this.name = name;
        this.characterClass = characterClass;
        this.weapon = weapon;
        this.health = health;
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "CustomCharacter{" +
                "name='" + name + '\'' +
                ", characterClass='" + characterClass + '\'' +
                ", weapon=" + weapon +
                ", health=" + health +
                ", mana=" + mana +
                '}';
    }
}

class CustomWeapon {
    String type;
    int damage;
    int speed;
    int range;

    public CustomWeapon(String type, int damage, int speed, int range) {
        this.type = type;
        this.damage = damage;
        this.speed = speed;
        this.range = range;
    }

    @Override
    public String toString() {
        return "CustomWeapon{" +
                "type='" + type + '\'' +
                ", damage=" + damage +
                ", speed=" + speed +
                ", range=" + range +
                '}';
    }
}

abstract class CustomCharacterFactory {
    public abstract CustomCharacter createCustomCharacter();
    public abstract CustomWeapon createCustomWeapon();
}

class WarriorSwordCharacterFactory extends CustomCharacterFactory {
    public CustomCharacter createCustomCharacter() {
        return new CustomCharacter("Warrior", "Warrior", createCustomWeapon(), 100, 50);
    }

    public CustomWeapon createCustomWeapon() {
        return new CustomWeapon("Sword", 20, 10, 2);
    }
}

class MageStaffCharacterFactory extends CustomCharacterFactory {
    public CustomCharacter createCustomCharacter() {
        return new CustomCharacter("Mage", "Mage", createCustomWeapon(), 80, 100);
    }

    public CustomWeapon createCustomWeapon() {
        return new CustomWeapon("Staff", 15, 8, 3);
    }
}

class ArcherBowCharacterFactory extends CustomCharacterFactory {
    public CustomCharacter createCustomCharacter() {
        return new CustomCharacter("Archer", "Archer", createCustomWeapon(), 90, 70);
    }

    public CustomWeapon createCustomWeapon() {
        return new CustomWeapon("Bow", 18, 12, 5);
    }
}

class CustomCharacterCreator {
    private CustomCharacterFactory factory;

    public void setFactory(CustomCharacterFactory factory) {
        this.factory = factory;
    }

    public CustomCharacter createCustomCharacter() {
        return factory.createCustomCharacter();
    }
}

public class assignment5pt4 {
    public static void main(String[] args) {
        CustomCharacterCreator creator = new CustomCharacterCreator();

        creator.setFactory(new WarriorSwordCharacterFactory());
        CustomCharacter warrior = creator.createCustomCharacter();

        creator.setFactory(new MageStaffCharacterFactory());
        CustomCharacter mage = creator.createCustomCharacter();

        creator.setFactory(new ArcherBowCharacterFactory());
        CustomCharacter archer = creator.createCustomCharacter();

        System.out.println("Warrior: " + warrior);
        System.out.println("Mage: " + mage);
        System.out.println("Archer: " + archer);
    }
}
