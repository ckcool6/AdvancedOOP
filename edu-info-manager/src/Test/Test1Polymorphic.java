package Test;

public class Test1Polymorphic {
    public static void main(String[] args) {

        Animal animal = new Cat(); //多态 ,向上转型
        animal.eat();
        useAnimal(new Dog());
        useAnimal(new Cat());

        Cat cat = (Cat) animal; //向下转型
        cat.eat();
    }

   public static void useAnimal(Animal a){
        a.eat();
   }
}

abstract class Animal {
    public abstract void eat();
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
}
