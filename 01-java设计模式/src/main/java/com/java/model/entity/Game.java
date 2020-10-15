package main.java.java.model.entity;

public abstract class Game {

    abstract void start();

    abstract void runing();

    abstract void end();

    public final void play(){
        start();

        runing();

        end();
    }
}
