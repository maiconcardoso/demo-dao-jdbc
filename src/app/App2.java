package app;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class App2 {
    public static void main(String[] args) throws Exception {

       // Scanner sc = new Scanner(System.in);
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: Department findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);
        System.out.println();

    }
}
