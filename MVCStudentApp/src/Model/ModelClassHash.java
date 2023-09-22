package Model;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelClassHash implements iGetModel {
    /**
     * @param storage  - hash хранилище данных
     */
    private HashMap<Long, Student> storage;
    private List<Student> students;

    /**
     * 
     * @param students - список учеников
     */
    public ModelClassHash(List<Student> students) {
        this.storage = new HashMap<Long, Student>();
        this.students = students;
    }

    /**
     * @return захешированный список учеников
     */
    public HashMap<Long, Student> saveAllStudentToHash() {
        for (Student stud : students) {
            storage.put((long) stud.getId(), stud);
        }
        return storage;

    }

    @Override
    public List<Student> getStudents() {
        saveAllStudentToHash();
        List<Student> studs = new ArrayList<>();

        for (Map.Entry<Long, Student> entry : storage.entrySet()) {

            studs.add(entry.getValue());

        }
        return studs;
    }


    @Override
    public void DELETE(int num, List<Student> students) {
        students.remove(num);
    }
}
