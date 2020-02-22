package com.team3d.quiz.quizapp.services;

import com.team3d.quiz.quizapp.entities.Role;
import com.team3d.quiz.quizapp.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(Long roleId){
       return roleRepository.getOne(roleId);
    }
}
