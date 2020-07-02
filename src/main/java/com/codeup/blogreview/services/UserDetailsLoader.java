package com.codeup.blogreview.services;

import com.codeup.blogreview.DAO.UserRepository;
import com.codeup.blogreview.models.Post;
import com.codeup.blogreview.models.User;
import com.codeup.blogreview.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository userdao;

    public UserDetailsLoader(UserRepository userdao){
        this.userdao = userdao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userdao.findByUsername("username");
        if(user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}
