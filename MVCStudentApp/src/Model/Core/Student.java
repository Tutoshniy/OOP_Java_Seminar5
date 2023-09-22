package Model.Core;

public class Student extends Person{
    private int id;
    private static int generalID;

    public Student(String name, int age) {
        super(name, age);
        this.id = generalID;
        generalID++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person name: " + super.getName() + "; age: " + super.getAge() + "; id:" + id;
    }
}
