/**
 * 
 */
package in.sachin.cricket.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.Role;
import in.sachin.cricket.entity.User;
import in.sachin.cricket.repository.RoleRepository;
import in.sachin.cricket.repository.UserRepository;
import in.sachin.cricket.util.CommonUtils;

/**
 * @author sachingoyal
 *
 */
@Service("userService")
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(0);
		user.setSerAnswer(bCryptPasswordEncoder.encode(user.getSerAnswer()));
		user.setUserActivationKey(CommonUtils.generateToken(user.getEmail()));
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	public void updateUserPassword(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public String getFirstName(String email) {
		User user = userRepository.findByEmail(email);
		return user == null ? "" : CommonUtils.upperCaseFirst(user.getName());
	}

}
