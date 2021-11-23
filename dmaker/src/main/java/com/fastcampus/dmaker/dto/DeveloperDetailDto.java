package com.fastcampus.dmaker.dto;

import com.fastcampus.dmaker.entity.Developer;
import com.fastcampus.dmaker.type.DeveloperLevel;
import com.fastcampus.dmaker.type.DeveloperSkillType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDetailDto {
	private DeveloperLevel developerLevel;
	private DeveloperSkillType developerSkillType;
	private Integer experienceYears;
	private String memberId;
	private String name;
	private int age;

	public static DeveloperDetailDto fromEntity(Developer developer) {
		return DeveloperDetailDto.builder()
			.developerLevel(developer.getDeveloperLevel())
			.developerSkillType(developer.getDeveloperSkillType())
			.experienceYears(developer.getExperienceYears())
			.memberId(developer.getMemberId())
			.name(developer.getName())
			.age(developer.getAge())
			.build();
	}
}
