package com.fastcampus.dmaker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.dmaker.entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
	Optional<Developer> findByMemberId(String memberId);
}
