package pages;

import org.checkerframework.checker.units.qual.C;

public class Cat extends Animals{
    public Cat(String name){
        this.name = name;
        age = 0;
    }
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Cat(){
        name = "Nameless one";
        age = 0;
    }

    @Override
    public Boolean isItPetAnimal() {
        return true;
    }

    @Override
    public void talk() {
        System.out.println(getClass()+ name + " is meowing! ");
    }

    public static boolean isCat(Object obj){
        if(obj instanceof Cat){
            return true;
        }

        return false;
    }

    public void specialCheckMethod(){
        System.out.println("All Good");
    }
}
