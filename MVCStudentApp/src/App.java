import java.util.ArrayList;
import java.util.List;

import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClassFile;
import Model.ModelClassHash;
import Model.ModelClassList;
import Model.Core.Student;
import View.ViewClass;
import View.ViewClassEng;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Сергей", 21);
        Student s2 = new Student("Иван", 22);
        Student s3 = new Student("Дарья", 25);
        Student s4 = new Student("Георгий", 23);
        Student s5 = new Student("Мария", 20);
        Student s6 = new Student("Евегений", 26);
        Student s7 = new Student("Олег", 22);
        students.add(0, s1);
        students.add(0, s2);
        students.add(0, s3);
        students.add(0, s4);
        students.add(0, s6);
        students.add(0, s5);
        students.add(0, s7);

        ModelClassHash hModel = new ModelClassHash(students);

        // ModelClassFile fModel = new ModelClassFile("StudentDB.csv");


        // ModelClassList modelList = new ModelClassList(students);
        // ViewClass view = new ViewClass();

        iGetModel modelList = hModel;
        iGetView view = new ViewClassEng();

        ControllerClass controller = new ControllerClass(modelList, view);
        controller.run();

    }
}
