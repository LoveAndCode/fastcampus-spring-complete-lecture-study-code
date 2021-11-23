package com.fastcampus.dmaker.service;

import static com.fastcampus.dmaker.exception.DMakerErrorCode.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.dmaker.dto.CreateDeveloper;
import com.fastcampus.dmaker.dto.DeveloperDetailDto;
import com.fastcampus.dmaker.dto.DeveloperDto;
import com.fastcampus.dmaker.dto.EditDeveloper;
import com.fastcampus.dmaker.entity.Developer;
import com.fastcampus.dmaker.exception.DMakerException;
import com.fastcampus.dmaker.repository.DeveloperRepository;
import com.fastcampus.dmaker.type.DeveloperLevel;
import com.fastcampus.dmaker.type.DeveloperSkillType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DMakerService {
	private final DeveloperRepository developerRepository;
	private final EntityManager entityManager;

	@Transactional
	public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
		validateCreateDeveloperRequest(request);

		Developer developer = Developer.builder()
			.memberId(request.getMemberId())
			.developerLevel(DeveloperLevel.JUNIOR)
			.developerSkillType(DeveloperSkillType.FRONT_END)
			.experienceYears(2)
			.name("Olaf")
			.age(5)
			.build();
		developerRepository.save(developer);
		return CreateDeveloper.Response.fromEntity(developer);
	}

	private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
		// business validation
		validateDeveloperLevel(request.getDeveloperLevel(), request.getExperienceYears());
		developerRepository.findByMemberId(request.getMemberId())
			.ifPresent(developer -> {
				throw new DMakerException(DUPLICATE_MEMBER_ID);
			});

	}

	private void validateDeveloperLevel(DeveloperLevel developerLevel, Integer experienceYears) {
		if (developerLevel == DeveloperLevel.SENIOR && experienceYears < 10) {
			throw new DMakerException(LEVEL_EXPERIENCE_YEAR_NOT_MATCH);
		}

		if (developerLevel == DeveloperLevel.JUNGNIOR
			&& experienceYears < 4
			|| experienceYears > 10) {
			throw new DMakerException(LEVEL_EXPERIENCE_YEAR_NOT_MATCH);
		}

		if (developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
			throw new DMakerException(LEVEL_EXPERIENCE_YEAR_NOT_MATCH);
		}
	}

	public List<DeveloperDto> getAllDevelopers() {
		return developerRepository.findAll()
			.stream()
			.map(DeveloperDto::fromEntity)
			.collect(Collectors.toList());
	}

	public DeveloperDetailDto getDeveloperDetail(String memberId) {
		return developerRepository.findByMemberId(memberId)
			.map(DeveloperDetailDto::fromEntity)
			.orElseThrow(() -> new DMakerException(INVALID_REQUEST));
	}

	@Transactional
	public DeveloperDetailDto editDeveloperDetail(String memberId, EditDeveloper.Request request) {
		validateDeveloperLevel(request.getDeveloperLevel(), request.getExperienceYears());

		Developer developer = developerRepository.findByMemberId(memberId)
			.orElseThrow(() -> new DMakerException(NO_DEVELOPER));

		developer.setDeveloperLevel(request.getDeveloperLevel());
		developer.setDeveloperSkillType(request.getDeveloperSkillType());
		developer.setExperienceYears(request.getExperienceYears());

		return DeveloperDetailDto.fromEntity(developer);
	}
}
