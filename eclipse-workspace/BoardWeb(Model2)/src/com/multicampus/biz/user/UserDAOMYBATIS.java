package com.multicampus.biz.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// 2. DAO(Data Access Object) Ŭ����
//@Repository
public class UserDAOMYBATIS implements UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD ����� �޼ҵ�
	// ȸ�� ���
	public void insertUser(UserVO vo) {}
	
	// ȸ�� ����
	public void updateUser(UserVO vo) {}	
	
	// ȸ�� ����
	public void deleteUser(UserVO vo) {}	
	
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBatis ������� getUser() ��� ó��");
		return (UserVO) mybatis.selectOne("getUser", vo);
	}
	
	// ȸ�� ��� �˻�
	public List<UserVO> getUserList(UserVO vo) {
		return null;
	}
}






