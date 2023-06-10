package pages;

public abstract class  Animals {
    protected String name;
    protected int age;

    public Animals(String name){
        this.name = name;
        age = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String noDigitName = name.replaceAll("[0-9]","");
        if(noDigitName.length() != name.length()){
            throw new Error("Digits in name not allowed " + name);
        }
        this.name = name;
    }

    public Animals(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Animals(){
        name = "Nameless one";
        age = 0;
    }

    public void sleep(){
        System.out.println(getClass()+ name + " is sleeping ");
    }

    public void walk(){
        System.out.println(getClass()+ name + " is walking ");
    }

    public void eat(String what){
        System.out.println(getClass()+ name + " is eating " + what);
    }

    public abstract Boolean isItPetAnimal();

    public void talk(){
        System.out.println("This Animal can't talk!");
    }
}
