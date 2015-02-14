package com.rizki.mufrizal.belajar.oauth2.service;

import com.rizki.mufrizal.belajar.oauth2.domain.UserRole;
import com.rizki.mufrizal.belajar.oauth2.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailLoginService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.rizki.mufrizal.belajar.oauth2.domain.User user = userRepository.getUserByUsername(username);

        if (user == null) {
            return null;
        }

        List<GrantedAuthority> userGrantedAuthorities = buildUserAuthority(user.getUserRoles());
        return buildUserForAuthentication(user, userGrantedAuthorities);
    }

    private User buildUserForAuthentication(com.rizki.mufrizal.belajar.oauth2.domain.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnable(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoleSet) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (UserRole userRole : userRoleSet) {
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<>(grantedAuthorities);
    }
}
