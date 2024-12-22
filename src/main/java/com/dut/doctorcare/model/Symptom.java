package com.dut.doctorcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "symptoms")
public class Symptom extends BaseClazz {
    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Column(nullable = false, unique = true, name = "slug")
    private String slug;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(mappedBy = "symptoms") // Định nghĩa bên bị chi phối
    private List<Doctor> doctors = new ArrayList<>();

}
