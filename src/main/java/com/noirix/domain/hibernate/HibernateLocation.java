package com.noirix.domain.hibernate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
public class HibernateLocation {

    @Id
    private Long id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private Float latitude;

    @Column
    private Float longitude;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<HibernateDealer> dealers = Collections.emptySet();
}
