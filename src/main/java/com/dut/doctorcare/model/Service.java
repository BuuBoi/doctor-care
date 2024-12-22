package com.dut.doctorcare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "services")
public class Service extends BaseClazz {
    @Column(nullable = false, unique = true, name = "name")
    private String name;
    @Column(nullable = false, unique = true, name = "slug")
    private String slug;

    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "image_url")
    private String imageUrl;
    @OneToMany(mappedBy = "service")
    private List<Doctor> doctors;
}
