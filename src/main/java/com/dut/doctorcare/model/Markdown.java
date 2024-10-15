package com.dut.doctorcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "markdowns")
public class Markdown extends BaseClazz{

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor; // Liên kết với bác sĩ

    @OneToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization; // Liên kết với chuyên khoa

    @Column(name = "content_html", columnDefinition = "TEXT") // Định nghĩa kiểu dữ liệu
    private String contentHTML; // Nội dung HTML

    @Column(name = "content_markdown", columnDefinition = "TEXT") // Định nghĩa kiểu dữ liệu
    private String contentMarkdown; // Nội dung Markdown

    @Column(name = "description", columnDefinition = "TEXT") // Định nghĩa kiểu dữ liệu
    private String description; // Mô tả
}
