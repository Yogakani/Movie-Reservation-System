package com.yoga.movie_reservation.entity.usermanagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Data
public class Role implements Serializable {

    @Id
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "privileges")
    private String privileges;
}
