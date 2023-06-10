package pages;

public class Dino extends Animals {
    public Dino(String name){
        this.name = name;
        age = 0;
    }
    public Dino(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Dino(){
        name = "Nameless one";
        age = 0;
    }

    @Override
    public Boolean isItPetAnimal() {
        return false;
    }

    @Override
    public void talk() {
        System.out.println(getClass() + name + " is roaring");
    }

    public void specialMethod(){
        System.out.println("Dino Stops");
    }
}
