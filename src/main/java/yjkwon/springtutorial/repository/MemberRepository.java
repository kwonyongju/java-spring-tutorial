package yjkwon.springtutorial.repository;

import yjkwon.springtutorial.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    List<Member> findAll();
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Member save(Member member);
}
