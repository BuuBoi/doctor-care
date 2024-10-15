package com.dut.doctorcare.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseClazz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public static String toSnakeCase(String str) {
        /**
         * Convert camel case to snake case
         *
         * @author DNAnh01[Do Nguyen Anh]
         */
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return str.replaceAll(regex, replacement).toLowerCase();
    }

    public static String getTableName(Class<?> clazz) {
        /**
         * Get table name from class name
         *
         * @author DNAnh01[Do Nguyen Anh]
         */
        return toSnakeCase(clazz.getSimpleName());
    }
}