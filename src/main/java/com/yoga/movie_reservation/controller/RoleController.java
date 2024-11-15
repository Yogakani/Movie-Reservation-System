package com.yoga.movie_reservation.controller;

import com.yoga.movie_reservation.dto.usermanagement.RoleDto;
import com.yoga.movie_reservation.response.usermanagement.role.GetAllRoleResponse;
import com.yoga.movie_reservation.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yoga.movie_reservation.mapper.usermanagement.RoleMapper.prepareGetAllRoleResponse;

@RestController
@RequestMapping("/api/v1/role")
@Slf4j
public class RoleController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping("/getAll")
    public ResponseEntity<GetAllRoleResponse> getAllRoles() {
        log.info("Get All roles started.");
        List<RoleDto> roleDtoList = userManagementService.fetchAllRoles();
        GetAllRoleResponse getAllRoleResponse = prepareGetAllRoleResponse(roleDtoList);
        log.info("Get All roles request completed.");
        return new ResponseEntity<>(getAllRoleResponse, HttpStatus.OK);
    }


}
