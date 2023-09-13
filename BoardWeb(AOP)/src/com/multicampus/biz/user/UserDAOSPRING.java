package com.multicampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.JDBCUtil;

// 2. DAO(Data Access Object) Ŭ����
// @Repository
public class UserDAOSPRING implements UserDAO {
	
	@Autowired
	private JdbcTemplate spring;
	
	// USERS ���̺� ���� SQL ��ɾ��
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD ����� �޼ҵ�
	// ȸ�� ���
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING ������� insertUser() ��� ó��");
	}
	
	// ȸ�� ����
	public void updateUser(UserVO vo) {
		System.out.println("===> SPRING ������� updateUser() ��� ó��");
	}	
	
	// ȸ�� ����
	public void deleteUser(UserVO vo) {
		System.out.println("===> SPRING ������� deleteUser() ��� ó��");
	}	
	
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING ������� getUser() ��� ó��");
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
	// ȸ�� ��� �˻�
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> SPRING ������� getUserList() ��� ó��");
		return null;
	}
}
