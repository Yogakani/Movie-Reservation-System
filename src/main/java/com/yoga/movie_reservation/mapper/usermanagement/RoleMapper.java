package com.yoga.movie_reservation.mapper.usermanagement;

import com.yoga.movie_reservation.dto.usermanagement.RoleDto;
import com.yoga.movie_reservation.entity.usermanagement.Role;
import com.yoga.movie_reservation.response.usermanagement.role.BaseRoleResponse;
import com.yoga.movie_reservation.response.usermanagement.role.GetAllRoleResponse;
import com.yoga.movie_reservation.util.JsonUtil;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class RoleMapper {

    public static List<RoleDto> toRoleDto(List<Role> roleList) {
        List<RoleDto> roleDtoList = new ArrayList<>();
        roleList.forEach(r -> {
            RoleDto dto = new RoleDto();
            BeanUtils.copyProperties(r, dto);
            roleDtoList.add(dto);
        });

        return roleDtoList;
    }

    public static GetAllRoleResponse prepareGetAllRoleResponse(List<RoleDto> roleDtoList) {

        List<BaseRoleResponse> baseRoleResponseList = roleDtoList.stream()
                .map(RoleMapper :: toBaseRoleResponse)
                .toList();

        return (GetAllRoleResponse) new GetAllRoleResponse()
                .setRoleResponseList(baseRoleResponseList)
                .setCode(HttpStatus.OK.value());
    }

    private static BaseRoleResponse toBaseRoleResponse(RoleDto roleDto) {
        List<String> privileges = JsonUtil.getListFromJsonStr(roleDto.getPrivileges(), String.class);
        return new BaseRoleResponse()
                .setId(roleDto.getId())
                .setName(roleDto.getRoleName())
                .setPrivileges(privileges);
    }

}
