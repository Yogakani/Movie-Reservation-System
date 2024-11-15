package com.yoga.movie_reservation.response.usermanagement.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BaseRoleResponse {
    private Long id;
    private String name;
    private List<String> privileges;
}
