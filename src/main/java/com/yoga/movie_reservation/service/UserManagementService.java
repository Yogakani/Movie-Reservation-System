package com.yoga.movie_reservation.service;

import com.yoga.movie_reservation.dto.usermanagement.RoleDto;
import com.yoga.movie_reservation.entity.usermanagement.Role;
import com.yoga.movie_reservation.repository.usermanagement.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yoga.movie_reservation.mapper.usermanagement.RoleMapper.toRoleDto;

@Service
@Slf4j
public class UserManagementService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDto> fetchAllRoles() {
        log.info("Fetching all roles from db..");
        List<Role> roles = roleRepository.findAll();
        log.info("Fetched all roles from db..");
        return toRoleDto(roles);
    }
}
