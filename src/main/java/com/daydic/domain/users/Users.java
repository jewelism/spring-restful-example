package com.daydic.domain.users;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by megap on 2017-04-29.
 */

@Entity
@Table(
        name="USERS",
        uniqueConstraints={
                @UniqueConstraint(
                        columnNames={"email"}
                )
        }
)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable
{
    @Id
    @GeneratedValue
    private long uid;
    @Column(nullable = false, length = 100)
    private String email;
    private String passwd;
    private LocalDate createdDate;
    private String userStatus;
    private String name;
    private String firstName;
    private String lastName;
    private LocalDate birth;
    private String gender;
    private String userId;
    private String tel;
}
