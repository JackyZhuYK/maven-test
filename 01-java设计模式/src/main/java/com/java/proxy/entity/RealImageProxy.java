package main.java.java.proxy.entity;

public class RealImageProxy implements Image{

    private String fileName;

    private RealImage realImage;

    public RealImageProxy(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage==null){
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
