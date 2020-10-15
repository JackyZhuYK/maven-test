package main.java.java.absfactory.entity;

public class FactoryProducer {

    public AbstractFactory getFactory(String choice){
        switch (choice) {
            case "shape":
                return new ShapeFactory();
            case "color":
                return new ColorFactory();
            default:
                return null;
        }
    }
}
