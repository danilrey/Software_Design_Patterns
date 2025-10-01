package Game;

import Console.Console;

abstract class SandBoxGame {
    Console console;

    public SandBoxGame(Console console) {
        this.console = console;
    }

    public void exit() {
        console.exitGame();
    }

    public void start() {
        console.startGame();
    }

    public void volumeUp() {
        if (console.getVolume() >= 0 && console.getVolume() < 100) {
            console.setVolume(console.getVolume() + 10);
            System.out.println("Volume is " + console.getVolume() + "\n");
        } else if (console.getVolume() == 100) {
            System.out.println("Volume is maximal\n");
        }
    }

    public void volumeDown() {
        if (console.getVolume() > 0 && console.getVolume() <= 100) {
            console.setVolume(console.getVolume() - 10);
            System.out.println("Volume is " + console.getVolume() + "\n");
        }  else if (console.getVolume() == 0) {
            System.out.println("Volume is minimal\n");
        }
    }
    abstract void build();
    abstract void explore();
    abstract void fight();
    abstract void walk();
    abstract void run();

}
