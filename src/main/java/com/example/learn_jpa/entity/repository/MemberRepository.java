package com.example.learn_jpa.entity.repository;

import com.example.learn_jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
