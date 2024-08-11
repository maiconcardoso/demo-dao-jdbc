package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.exceptions.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement st = null;
        String sql = "INSERT INTO department (name) VALUES (?)";
        
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, department.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Error: " +e.getMessage());
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement st = null;
        String sql = "UPDATE department SET Name = ? WHERE id = ?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, department.getName());
            st.setInt(2, department.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM department WHERE Id = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("Id"));
                department.setName(rs.getString("Name"));
                return department;
            }

        } catch (SQLException e) {
            throw new DbException("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM department";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("Id"));
                department.setName(rs.getString("Name"));
                list.add(department);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
