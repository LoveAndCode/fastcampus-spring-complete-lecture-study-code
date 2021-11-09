package com.fastcampus.dmaker.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.dmaker.entity.Developer;
import com.fastcampus.dmaker.repository.DeveloperRepository;
import com.fastcampus.dmaker.type.DeveloperLevel;
import com.fastcampus.dmaker.type.DeveloperSkillType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DMakerService {
	private final DeveloperRepository developerRepository;

	@Transactional
	public void createDeveloper() {
		Developer developer = Developer.builder()
			.developerLevel(DeveloperLevel.JUNIOR)
			.developerSkillType(DeveloperSkillType.FRONT_END)
			.experienceYears(2)
			.name("Olaf")
			.age(5)
			.build();


		developerRepository.save(developer);
	}
}
