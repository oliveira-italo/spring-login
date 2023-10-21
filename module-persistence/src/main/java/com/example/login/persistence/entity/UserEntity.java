package com.example.login.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "idt_uuid", nullable = false, unique = true, updatable = false)
    private String uuid;

    @Column(name = "chr_name", nullable = false)
    private String name;

    @Column(name = "chr_email", nullable = false, unique = true)
    private String email;

    @Column(name = "chr_password", nullable = false)
    private String password;

    @PrePersist
    private void prePersist() {
        this.uuid = UUID.randomUUID().toString();
    }
}
