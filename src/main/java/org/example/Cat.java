package org.example;

public class Cat {
    String name;

    public void say() {
        String sayWord = "Meow!";
        System.out.print(sayWord + name);
    }

    public String getName() {
        return name;
    }

    public Cat() {
    }



    public Cat(String nameCat) {
        this.name = nameCat;
    }
}
