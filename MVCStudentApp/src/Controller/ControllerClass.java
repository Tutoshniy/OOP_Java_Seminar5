package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClassList;
import Model.Core.Student;
import View.ViewClass;

public class ControllerClass {
    private iGetModel model;
    private iGetView view;
    private List<Student> students = new ArrayList<Student>();

    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    private boolean testData(List<Student> studs) {
        if (studs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update() {
        // MVP
        students = model.getStudents();

        if (testData(students)) {
            view.printAllStudent(students);
        } else {
            System.out.println("Список студентов пуст!");
        }

        // MVC
        // view.printAllStudent(model.getStudents());
    }


    public void run(){
        Command com = Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = view.promt("Введите команду");
            com = Command.valueOf(command.toUpperCase());
            switch(com){
                case EXIT:
                    getNewIter = false;
                    System.out.println("Выход из программы");
                    break;
                case LIST:
                    view.printAllStudent(model.getStudents());
                    break;
                case DELETE:
                    System.out.println("Введите номер ученика, которого нужно удалить из списка: ");
                    Scanner scanner = new Scanner(System.in);
                    int num = scanner.nextInt();
                    students = model.getStudents();
                    if (num > 0 & num <= students.size()){
                        model.DELETE(num, students);
                    }
                    else {
                        System.out.println("Недопустимое удаление");
                    }
                    break;
            }
        }
    }

}
