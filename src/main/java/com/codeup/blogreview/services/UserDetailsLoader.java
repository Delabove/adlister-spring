package com.codeup.blogreview.services;

import com.codeup.blogreview.models.Post;
import com.codeup.blogreview.models.User;
import com.codeup.blogreview.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final User user;

    public UserDetailsLoader(User user){
        this.user = user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = user.findByUsername("username");
        if(user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}
