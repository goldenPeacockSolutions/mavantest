package com.society.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.model.Society;
import com.society.repository.SocietyRepository;

@Service("societyService")
public class SocietyServiceImpl implements SocietyService{

	@Autowired
	private SocietyRepository societyRepository;
	/*@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	@Override
	public void saveSociety(Society society) {
	society.setName(society.getName());
	societyRepository.save(society);}

	@Override
	public Society findSocietyByName(String name) {
		// TODO Auto-generated method stub
		return societyRepository.findByName(name);
	}

	@Override
	public List<Society> listAllSocieties() {
		// TODO Auto-generated method stub
		return societyRepository.findByNameNotNull();
	}
	
	/*@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}*/

	/*@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}*/

}
