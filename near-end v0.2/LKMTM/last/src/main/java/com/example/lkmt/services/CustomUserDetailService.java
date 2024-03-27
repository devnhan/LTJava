package com.example.lkmt.services;

import com.example.lkmt.repository.IUserRepository;
import com.example.lkmt.entity.CustomUserDetail;
import com.example.lkmt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepoitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepoitory.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetail(user);
    }
}
