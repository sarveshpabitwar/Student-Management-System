package com.dao;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.student;

public class studentdao {

    private Connection conn;

    public studentdao(Connection conn) {
        this.conn = conn;
    }

    public boolean addStudent(student s) {
        boolean f = false;

        try {
            String sql = "INSERT INTO student_db(name, dob, address, qualification, email) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getFullname());
            ps.setString(2, s.getDob());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getQualification());
            ps.setString(5, s.getEmail());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }
    
    public List<student> getallstudent(){
    	List<student> list = new ArrayList<student>();
    	student s=null;
    	try {
    		
    		String sql = "select * from student_db";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		
    		ResultSet set = ps.executeQuery();
    		
    		while(set.next()) {
    			s=new student();
    			s.setId(set.getInt(1));
    			s.setFullname(set.getString(2));
    			s.setDob(set.getString(3));
    			s.setAddress(set.getString(4));
    			s.setQualification(set.getString(5));
    			s.setEmail(set.getString(6));
    			list.add(s);
    			
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	return list;
    }
    
    
    public student getstudentbyid(int id) {
    	student s=null;
try {
    		
    		String sql = "select * from student_db where id=?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, id);
    		
    		ResultSet set = ps.executeQuery();
    		
    		while(set.next()) {
    			s=new student();
    			s.setId(set.getInt(1));
    			s.setFullname(set.getString(2));
    			s.setDob(set.getString(3));
    			s.setAddress(set.getString(4));
    			s.setQualification(set.getString(5));
    			s.setEmail(set.getString(6));
    			
    			
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

			return s;
    }
    
    public boolean updateStudent(student s) {
        boolean f = false;

        try {
            String sql = "update student_db set name=?, dob=?, address=?, qualification=?, email=? where id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getFullname());
            ps.setString(2, s.getDob());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getQualification());
            ps.setString(5, s.getEmail());
            ps.setInt(6, s.getId());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }
    
    
    public boolean deletestudentbyid(int id) {
    	boolean f= false;
    	
    	try {
    		String sql = "delete from student_db where id=?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, id);
    		
    		int i=ps.executeUpdate();
    		if(i==1) {
    			f=true;
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	return f;
    }
    
}
