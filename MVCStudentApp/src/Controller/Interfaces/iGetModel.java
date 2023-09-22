package Controller.Interfaces;

import java.util.List;

import Model.Core.Student;

public interface iGetModel {
    public List<Student> getStudents();
    /**
     * Удаление ученика из списка
     * @param num - индекс элемента на удаление
     */
    public void DELETE(int num, List<Student> students);
}
