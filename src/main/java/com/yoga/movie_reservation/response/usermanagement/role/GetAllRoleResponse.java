package com.yoga.movie_reservation.response.usermanagement.role;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yoga.movie_reservation.dto.usermanagement.RoleDto;
import com.yoga.movie_reservation.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GetAllRoleResponse extends BaseResponse {

    @JsonProperty(value = "roles")
    private List<BaseRoleResponse> roleResponseList;
}
