package com.session.auth.service.roles;

import com.session.auth.model.Role;
import com.session.auth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> list() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role add() {
        return null;
    }

    @Override
    public Role delete() {
        return null;
    }

}