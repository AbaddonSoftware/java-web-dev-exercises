package org.launch.java.studios.discs;

public class Main {

    public static void main(String[] args) {
        CD myCD = new CD();
        DVD myDVD = new DVD();
    
        System.out.println(myCD.spinDisc());
        System.out.println(myDVD.spinDisc());
        System.out.println(myCD.stopDisc());
        System.out.println(myDVD.stopDisc());
    }

}