package com.noirix.domain.hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
public class HibernateCar {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String model;

    @Column(name = "production_date")
    private LocalDateTime productionDate;

    @Column
    private Integer price;

    @OneToOne
    @JoinColumn(name = "owner")
    @JsonBackReference
    private HibernateUser owner;
}
