package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

/* Controller + ResponseBody */
@RestController
public class RestUserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<UserVO> getUserList() {
		return userService.getUserList();
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public UserVO getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	/*RequestBody : Http Request Body를 Java 객체로 받을 수 있음 */
	@RequestMapping(value="/users", method=RequestMethod.POST, headers= {"content-type=application/json"})
	public Boolean insertUser(@RequestBody UserVO user) {
		if(user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	/*RequestBody : Http Request Body를 Java 객체로 받을 수 있음 */
	@RequestMapping(value="/users", method=RequestMethod.PUT, headers= {"content-type=application/json"})
	public Boolean updateUser(@RequestBody UserVO user) {
		if(user != null) {
			userService.updateUser(user);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable String id) {
		if(id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	/* Xml 형태로 데이터 내려주기 */
	@RequestMapping(value="/usersXml", method=RequestMethod.GET)
	public UserVOXML getUserListXml() {
		List<UserVO> userList = userService.getUserList();
		UserVOXML xml = new UserVOXML("success", userList);
		return xml;
	}
}
