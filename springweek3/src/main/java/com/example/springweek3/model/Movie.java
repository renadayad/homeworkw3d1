package com.example.springweek3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.validator.constraints.Range;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;
@AllArgsConstructor  @NoArgsConstructor @Data
@Entity
public class Movie {
    @Id
    @Min(value = 3,message ="Length more than 3" ) @Column(unique = true,nullable = false )
    private Integer id;
    @Size(min = 2,message ="Length more than 2" ) @Column(nullable = false,unique = true )
    private String name;
    @NotEmpty (message = "Cannot be null ")@Column(nullable = false)
    @Pattern(regexp = ("Drama|Action|Comedy"))
    private String genre;
    @Positive @NotNull @Range(min = 1,max = 5,message = "must be between 1 - 5")
    private Double rating;
    @NotNull @Positive @Min(value = 60,message = "must be more 60")
    private Double  duration;
    @NotEmpty @Pattern(regexp ="^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")
    private String launchDate;
}
