package com.agnc.carthy.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity(name="authorities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "user")
@Setter
public class Authority implements GrantedAuthority{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String authority;

}
