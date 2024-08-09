package app;

import java.util.List;

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

        System.out.println("=== TEST 2: Department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }
        System.out.println();

        System.out.println("=== TEST 3: Department insert ===");
        Department dep3 = new Department(null, "Usados");
        departmentDao.insert(dep3);
        System.out.println("Inserted! new departmet: " + dep3.getName());
        System.out.println();

    }
}
