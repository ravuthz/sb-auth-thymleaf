package com.session.auth.service;

import com.session.auth.model.Role;
import com.session.auth.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void createUser() {
        authService.assignPermissionsToRole(
                authService.findOrCreateRole("USER"),
                Arrays.asList(
                        authService.findOrCreatePermission("VIEW_APP")
                ));

        authService.assignRoleToUser(
                authService.findOrCreateRole("USER"),
                authService.findOrCreateUser("user")
        );
    }

    @Test
    public void createAdminUser() {
        authService.assignPermissionsToRole(
                authService.findOrCreateRole("ADMIN"),
                Arrays.asList(
                        authService.findOrCreatePermission("CREATE_APP"),
                        authService.findOrCreatePermission("UPDATE_APP"),
                        authService.findOrCreatePermission("DELETE_APP"),
                        authService.findOrCreatePermission("VIEW_APP")
                ));

        authService.assignRoleToUser(
                authService.findOrCreateRole("ADMIN"),
                authService.findOrCreateUser("admin")
        );
    }

    @Test
    public void testFindOrCreate() {
        roleRepository.findOrCreate("USER1", new Role("USER1"));
    }

    @Test
    public void testValidation() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            Role role1 = new Role("ROLE1");
            role1.setNote("ROLE1 description");

            Role role2 = new Role("ROLE1");
            role2.setNote("ROLE2 description");

            roleRepository.saveAll(Arrays.asList(role1, role2));
        });
    }

}