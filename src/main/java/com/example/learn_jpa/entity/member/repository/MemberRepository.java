package com.example.learn_jpa.entity.member.repository;

import com.example.learn_jpa.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
