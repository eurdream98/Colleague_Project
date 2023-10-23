package com.example.structure.member.domain;

import static com.example.structure.member.domain.MemberState.ACTIVE;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@SQLDelete(sql = "UPDATE member SET status = 'DELETED' WHERE id = ?")
@Where(clause = "status = 'ACTIVE'")
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer memberCode;

    @Column(nullable = false, length = 30)
    private String memberSocialId;


    @Column(nullable = false, unique = true, length = 20)
    private String memberName;

    @Column(nullable = false)
    private Character memberGender;

    @Column(nullable = false)
    private Integer memberAge;

    @Column(nullable = false)
    private String memberPhone;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String memberNickName;

    @Column(nullable = false)
    private Integer goalCategoryCode;

    @Enumerated(EnumType.STRING)
    private MemberState state;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

//    public Member(Long memberCode, String memberSocialId, String memberName, String memberGender, int memberAge, String memberPhone, String memberEmail, String memberNickName, String goalCategoryCode, MemberState state, LocalDateTime createdAt, LocalDateTime modifiedAt) {
//        this.memberCode = memberCode;
//        this.memberSocialId = memberSocialId;
//        this.memberName = memberName;
//        this.memberGender = memberGender;
//        this.memberAge = memberAge;
//        this.memberPhone = memberPhone;
//        this.memberEmail = memberEmail;
//        this.memberNickName = memberNickName;
//        this.goalCategoryCode = goalCategoryCode;
//        this.state = ACTIVE;
//        this.createdAt = createdAt;
//        this.modifiedAt = modifiedAt;
//    }

    public Member(Integer memberCode, String memberSocialId, String memberName, Character memberGender, Integer memberAge, String memberPhone, String memberEmail, String memberNickName, Integer goalCategoryCode, MemberState state, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.memberCode = memberCode;
        this.memberSocialId = memberSocialId;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberAge = memberAge;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
        this.memberNickName = memberNickName;
        this.goalCategoryCode = goalCategoryCode;
        this.state = state;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
