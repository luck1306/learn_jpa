package com.example.learn_jpa.entity.dummy;

import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Dummy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Dummy(String data, Long member) {
        this.data = data;
        this.member = member;
    }

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "member_id")
    private Long member;

    private String data;
}
