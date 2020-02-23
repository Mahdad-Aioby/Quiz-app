package com.team3d.quiz.quizapp.AuthServiceWithUserDetails;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Authority;
import com.team3d.quiz.quizapp.entities.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private Account account;

    public MyUserDetails(Account account){
        this.account=account;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //1.first it get authorities from account:roles in type:list-string!
        //2.then convert that string list to authority list!!!
        //3.the whole work is to get authorities from roles in account!
       // return getGrantedAuthorities(getAuthoritiesFromRole(account.getRoles()));

        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        for(Role role : account.getRoles()){
            list.add(new SimpleGrantedAuthority(role.getRole()));
            list.addAll(role.getAuthorities());
        }

        return list;

    }

    private List<String> getAuthoritiesFromRole(Collection<Role> roles) {

        List<String> Authorities = new ArrayList<>();
        List<Authority> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getAuthorities());
        }
        for (Authority item : collection) {
            Authorities.add(item.getAuthority());
        }
        return Authorities;
    }

    private List<Authority> getGrantedAuthorities(List<String> Authorities) {
        List<Authority> authorities = new ArrayList<>();
        for (String authority : Authorities) {
            authorities.add(new Authority(authority));
        }
        return authorities;
    }


    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account.isActive();
    }
}
