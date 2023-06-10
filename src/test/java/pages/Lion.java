package pages;

public class Lion extends Animals{

    public Lion(String name){
        this.name = name;
    }
    public Lion(){
        name = "Nameless one";
        age = 0;
    }

    @Override
    public Boolean isItPetAnimal() {
        return false;
    }

    public Lion(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void talk(){
        System.out.println(getClass() + name + " is roaring");
    }

}
