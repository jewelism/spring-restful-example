package com.daydic.domain.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kusob on 2017. 5. 20..
 */
@Entity
@Table(
        name="USERSDEVICE"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDevice {
    @Id
    @GeneratedValue
    private long udid;
    private long uid;
    private Date regDate;
    private String name;
    private String os;
    private String version;
    
}
