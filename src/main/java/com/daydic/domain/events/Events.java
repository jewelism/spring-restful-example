package com.daydic.domain.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by megap on 2017-05-13.
 */

@Entity
@Table(
        name="EVENTS"
//        uniqueConstraints={
//                @UniqueConstraint(
//                        columnNames={"email"}
//                )
//        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Events {

    @Id
    @GeneratedValue
    private long eid;
    @Column(nullable = false, length = 100)
    private String email;
    private String rStatus;
    private LocalDate createdDate;
    private String host;
    private long uid;
    private String title;
    private String shortDescription;
    private String eventsBody;
    private Double lat;
    private Double lng;
    private String locationName;
    private long eventsType;
    private long dateType;
    private long timeType;
    private LocalDate startDate;
    private LocalDate endDate;
    private long repeatType;
    private String mainImage;
    private long publishRole;

}
