import java.util.ArrayList;
import java.util.List;

class Character {
    String name;
    String appearance;
    List<String> abilities;
    List<String> equipment;
    Attributes attributes;

    public Character(String name) {
        this.name = name;
        abilities = new ArrayList<>();
        equipment = new ArrayList<>();
        attributes = new Attributes();
    }
}


abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}


class WarriorFactory extends CharacterFactory {
    public Character createCharacter(String name) {
        Character character = new Character(name);
        character.appearance = "Warrior Appearance";
        character.abilities.add("Slash");
        character.abilities.add("Charge");
        character.equipment.add("Sword");
        character.equipment.add("Shield");
        character.attributes.strength = 10;
        character.attributes.defense = 8;
        return character;
    }
}

class MageFactory extends CharacterFactory {
    public Character createCharacter(String name) {
        Character character = new Character(name);
        character.appearance = "Mage Appearance";
        character.abilities.add("Fireball");
        character.abilities.add("Teleport");
        character.equipment.add("Staff");
        character.equipment.add("Robe");
        character.attributes.intelligence = 12;
        character.attributes.mana = 100;
        return character;
    }
}

class ArcherFactory extends CharacterFactory {
    public Character createCharacter(String name) {
        Character character = new Character(name);
        character.appearance = "Archer Appearance";
        character.abilities.add("Shoot");
        character.abilities.add("Dodge");
        character.equipment.add("Bow");
        character.equipment.add("Quiver");
        character.attributes.agility = 15;
        character.attributes.accuracy = 90;
        return character;
    }
}

class Attributes {
    int strength;
    int defense;
    int intelligence;
    int mana;
    int agility;
    int accuracy;
}

class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter(String name) {
        if (factory != null) {
            return factory.createCharacter(name);
        } else {
            System.out.println("Factory not set. Cannot create character.");
            return null;
        }
    }
}

public class assignment5pt1 {
    public static void main(String[] args) {
        // Step 6: Use the CharacterCreator and concrete factories to create characters
        CharacterCreator creator = new CharacterCreator();

        WarriorFactory warriorFactory = new WarriorFactory();
        creator.setFactory(warriorFactory);
        Character warrior = creator.createCharacter("Conan");

        MageFactory mageFactory = new MageFactory();
        creator.setFactory(mageFactory);
        Character mage = creator.createCharacter("Merlin");

        ArcherFactory archerFactory = new ArcherFactory();
        creator.setFactory(archerFactory);
        Character archer = creator.createCharacter("Legolas");



        System.out.println("Created warrior: " + warrior.name);
        System.out.println("Warrior abilities: " + warrior.abilities);
        System.out.println("Warrior equipment: " + warrior.equipment);
        System.out.println("Warrior attributes: " + warrior.attributes.strength + " strength, " + warrior.attributes.defense + " defense");

        System.out.println("Created mage: " + mage.name);
        System.out.println("Mage abilities: " + mage.abilities);
        System.out.println("Mage equipment: " + mage.equipment);
        System.out.println("Mage attributes: " + mage.attributes.intelligence + " intelligence, " + mage.attributes.mana + " mana");

        System.out.println("Created archer: " + archer.name);
        System.out.println("Archer abilities: " + archer.abilities);
        System.out.println("Archer equipment: " + archer.equipment);
        System.out.println("Archer attributes: " + archer.attributes.agility + " agility, " + archer.attributes.accuracy + " accuracy");
    }
}
