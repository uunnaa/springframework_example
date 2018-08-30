package myspring.user.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/main.xml")
public class UserTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void studentTable() {
		List<StudentVO> stuList = sqlSession.selectList("studentNS.selectStudentDeptById");
		
		for (StudentVO studentVO : stuList) {
			System.out.println(studentVO);
		}
	}
	
	@Test @Ignore
	public void usersTable() {
		List<UserVO> userList = sqlSession.selectList("userNS.selectUserList");
		
		for (UserVO userVO : userList) {
			System.out.println(userVO);
		}
	}
	
	@Test @Ignore
	public void connection() {
		
		System.out.println(sqlSessionFactory.getClass().getName());
		
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
