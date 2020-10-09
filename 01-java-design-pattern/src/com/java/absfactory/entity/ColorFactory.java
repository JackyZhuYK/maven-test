package com.java.absfactory.entity;

public class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String type) {
        switch (type) {
            case "red":
                return new Red();
            case "green":
                return new Green();
            case "blue":
                return new Blue();
            default:
                return null;
        }
    }

    @Override
    public Shape getShape(String type) {
        return null;
    }
}
