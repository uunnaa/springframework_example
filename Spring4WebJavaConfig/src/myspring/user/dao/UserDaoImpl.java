package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
    private UserMapper userMapper;
	
//	public void setSqlSession(SqlSession session) {
//		this.userMapper = session;
//	}
	
	@Override
	public UserVO read(String id) {
		UserVO user  = userMapper.selectUserById(id);
		return user;
	}

	public List<UserVO> readAll() {
		List<UserVO> userList = userMapper.selectUserList();
		return userList;
	}
	
	public void insert(UserVO user) {
		userMapper.insertUser(user);
		System.out.println("��ϵ� Record UserId=" + user.getUserId() + " Name=" + user.getName());
	}

	@Override
	public void update(UserVO user) {
		userMapper.updateUser(user);
	}

	@Override
	public void delete(String id) {
		userMapper.deleteUser(id);
		System.out.println("������ Record with ID = " + id ); 
	}




	

}