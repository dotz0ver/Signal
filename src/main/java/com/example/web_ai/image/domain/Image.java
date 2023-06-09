package com.example.web_ai.image.domain;

import com.example.web_ai.gps.Gps;
import com.example.web_ai.image.dto.ImageDto;
import com.example.web_ai.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Image {
    @Id
    @Column(name = "Image_Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String savedPath;

    @ManyToOne
    @JoinColumn(name = "Member_Idx")
    private Member member;

    @Embedded
    @Column(nullable = false)
    private Gps gps;

    private int factor1;
    private int factor2;
    private int factor3;
    private int factor4;
    private int factor5;

    public void updateSavedPath(String savedPath) {
        this.savedPath = savedPath;
    }

    public ImageDto toDTO(Image image) {
        ImageDto imageDto = ImageDto.builder()
                .idx(image.getIdx())
                .savedPath(image.getSavedPath())
                .memberIdx(image.getMember().getIdx())
                .gps(image.getGps())
                .factor1(image.getFactor1())
                .factor2(image.getFactor2())
                .factor3(image.getFactor3())
                .factor4(image.getFactor4())
                .factor5(image.getFactor5())
                .build();
        return imageDto;
    }

}
