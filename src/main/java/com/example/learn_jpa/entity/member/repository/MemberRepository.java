package com.example.learn_jpa.entity.member.repository;

import com.example.learn_jpa.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByAccountId(String accountId);

    Optional<List<Member>> findByPassword(String password);
}
