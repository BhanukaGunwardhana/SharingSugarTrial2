package com.sharingsugar.centraldatabaseservice.model.Entity.SharingSugarMainEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "sugarpostimage")
public class SugarPostImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sugarPostImageId;

    private String postImageUrl;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(
            name = "sugarPostImageId_sugarPostId",
            referencedColumnName = "sugarPostId"
    )
    private SugarPostEntity sugarPost;
}
