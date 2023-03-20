package ProyectoNegocio.service;

import java.util.ArrayList;
import java.util.List;
import loginSecurity.entity.Authority;
import loginSecurity.entity.User;
import loginSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    UserRepository userRepository;
	
    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
     
     loginSecurity.entity.User appUser = 
                 userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		
    
    List grantList = new ArrayList();
    for (Authority authority: appUser.getAuthority()) {
        
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
    }
		
    
    UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
         return user;
    }
}

