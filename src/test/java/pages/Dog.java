package pages;

public class Dog extends Animals{

    public Dog(String name){
        this.name = name;
        age = 0;
    }
    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Dog(){
        name = "Nameless one";
        age = 0;
    }

    @Override
    public Boolean isItPetAnimal() {
        return true;
    }

    @Override
    public void talk() {
            System.out.println(getClass()+ name + " is barking! ");
    }

    public static boolean isDog(Object obj){
        if(obj instanceof Dog){
            return true;
        }

        return false;
    }
}
