package com.project.Fitness.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Recommandations {

     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;

     @Column(length = 2000)
     private String recommendations;

     @ManyToOne
     @JoinColumn(name = "user_id",nullable = false)
     @JsonIgnore
     private User user;

    @ManyToOne
    @JoinColumn(name = "activity_id",nullable = false)
    @JsonIgnore
    private Activity activity
            ;

     @JdbcTypeCode(SqlTypes.JSON)
     @Column(columnDefinition = "json")
     private List<String> improvements;

     @JdbcTypeCode(SqlTypes.JSON)
     @Column(columnDefinition = "json")
     private List<String> suggestions;

     @JdbcTypeCode(SqlTypes.JSON)
     @Column(columnDefinition = "json")
     private List<String> safety;

     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

}
