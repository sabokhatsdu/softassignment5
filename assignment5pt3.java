class Furniture {
    String name;
    String style;
    String material;
    float price;

    public Furniture(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                '}';
    }
}

abstract class FurnitureFactory {
    public abstract Chair createChair();
    public abstract Table createTable();
    public abstract Sofa createSofa();
}

class ModernWoodFactory extends FurnitureFactory {
    public Chair createChair() {
        return new Chair("Modern Chair", "Modern", "Wood", 150);
    }

    public Table createTable() {
        return new Table("Modern Table", "Modern", "Wood", 300);
    }

    public Sofa createSofa() {
        return new Sofa("Modern Sofa", "Modern", "Wood", 500);
    }
}

class TraditionalMetalFactory extends FurnitureFactory {
    public Chair createChair() {
        return new Chair("Traditional Chair", "Traditional", "Metal", 100);
    }

    public Table createTable() {
        return new Table("Traditional Table", "Traditional", "Metal", 250);
    }

    public Sofa createSofa() {
        return new Sofa("Traditional Sofa", "Traditional", "Metal", 450);
    }
}

class IndustrialGlassFactory extends FurnitureFactory {
    public Chair createChair() {
        return new Chair("Industrial Chair", "Industrial", "Glass", 120);
    }

    public Table createTable() {
        return new Table("Industrial Table", "Industrial", "Glass", 280);
    }

    public Sofa createSofa() {
        return new Sofa("Industrial Sofa", "Industrial", "Glass", 480);
    }
}

class Chair {
    String name;
    String style;
    String material;
    float price;

    public Chair(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }
}

class Table {
    String name;
    String style;
    String material;
    float price;

    public Table(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }
}

class Sofa {
    String name;
    String style;
    String material;
    float price;

    public Sofa(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }
}

class FurnitureCreator {
    private FurnitureFactory factory;

    public void setFactory(FurnitureFactory factory) {
        this.factory = factory;
    }

    public Chair createChair() {
        return factory.createChair();
    }

    public Table createTable() {
        return factory.createTable();
    }

    public Sofa createSofa() {
        return factory.createSofa();
    }
}

public class assignment5pt3 {
    public static void main(String[] args) {
        FurnitureCreator creator = new FurnitureCreator();

        creator.setFactory(new ModernWoodFactory());
        Chair modernWoodChair = creator.createChair();
        Table modernWoodTable = creator.createTable();
        Sofa modernWoodSofa = creator.createSofa();

        creator.setFactory(new TraditionalMetalFactory());
        Chair traditionalMetalChair = creator.createChair();
        Table traditionalMetalTable = creator.createTable();
        Sofa traditionalMetalSofa = creator.createSofa();

        creator.setFactory(new IndustrialGlassFactory());
        Chair industrialGlassChair = creator.createChair();
        Table industrialGlassTable = creator.createTable();
        Sofa industrialGlassSofa = creator.createSofa();

        System.out.println("Modern Wood Chair: " + modernWoodChair);
        System.out.println("Modern Wood Table: " + modernWoodTable);
        System.out.println("Modern Wood Sofa: " + modernWoodSofa);

        System.out.println("Traditional Metal Chair: " + traditionalMetalChair);
        System.out.println("Traditional Metal Table: " + traditionalMetalTable);
        System.out.println("Traditional Metal Sofa: " + traditionalMetalSofa);

        System.out.println("Industrial Glass Chair: " + industrialGlassChair);
        System.out.println("Industrial Glass Table: " + industrialGlassTable);
        System.out.println("Industrial Glass Sofa: " + industrialGlassSofa);
    }
}
