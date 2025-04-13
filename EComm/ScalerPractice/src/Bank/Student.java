package Bank;

public class Student {
    // write the code of student class here

    int age;
    String name;

    public void display()
    {
        System.out.printf("My name is %s. I am %s years old", name, age);
    }

    public void sayHello(String name)
    {
        System.out.printf("%s says hello to %s", this.name, name);
    }
}
