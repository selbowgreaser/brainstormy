package ru.frolov.distlearning.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@Getter
@Setter
public class Teacher {

    @Id
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "degree")
    private String degree;
}
