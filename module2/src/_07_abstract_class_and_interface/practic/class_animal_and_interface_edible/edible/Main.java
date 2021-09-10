package _07_abstract_class_and_interface.practic.class_animal_and_interface_edible.edible;


import _07_abstract_class_and_interface.practic.class_animal_and_interface_edible.animal.Animal;
import _07_abstract_class_and_interface.practic.class_animal_and_interface_edible.animal.Chicken;
import _07_abstract_class_and_interface.practic.class_animal_and_interface_edible.animal.Tiger;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
