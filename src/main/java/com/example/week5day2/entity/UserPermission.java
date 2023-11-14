package com.example.week5day2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "UserPermission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "permissionId")
    private Permission permission;
}
