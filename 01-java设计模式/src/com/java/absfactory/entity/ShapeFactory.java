package com.java.absfactory.entity;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String type) {
        return null;
    }

    public Shape getShape(String type) {
        switch (type) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "triangle":
                return new Triangle();
            default:
                return null;
        }
    }
}
