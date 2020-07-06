package exercises.technology;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        Computer commodore64 = new Computer("Commodore", "6510", 1.02);
        Computer famicom = new Computer("Nintendo", "6502", 1.79);
        ArrayList<String> operatingSystems = new ArrayList<>(Arrays.asList("Ubuntu 20.04", "Windows 10"));
        Laptop myLaptop = new Laptop("HP", "i5-9300H", 2400, operatingSystems, 14, 4);
        Laptop anotherLaptop = new Laptop("Dell", "i5-9300H", 2600, operatingSystems, 14, 4);
        SmartPhone samsung_Galaxy_S5 = new SmartPhone("Samsung", "Samsung Exynos 5420", 1900, "Android", true);
        ArrayList<Computer> computers = new ArrayList<>(Arrays.asList(commodore64, famicom, myLaptop, anotherLaptop, samsung_Galaxy_S5));
        for(Computer computer : computers) {
            System.out.println(computer.getClass()+ " " +computer.getManufacturer()+ " has id - " +computer.getId());
            System.out.println("Processor Speed as GHZ: " +String.format("%.5f", computer.getProcessorSpeedInGHZ()));
        }
    }


}
