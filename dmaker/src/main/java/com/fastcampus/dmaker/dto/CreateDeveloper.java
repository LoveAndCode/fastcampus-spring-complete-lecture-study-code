package com.fastcampus.dmaker.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fastcampus.dmaker.entity.Developer;
import com.fastcampus.dmaker.type.DeveloperLevel;
import com.fastcampus.dmaker.type.DeveloperSkillType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateDeveloper {

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Request {
		@NotNull
		private DeveloperLevel developerLevel;
		@NotNull
		private DeveloperSkillType developerSkillType;
		@NotNull
		@Min(0)
		private Integer experienceYears;
		@NotNull
		@Size(min = 3, max = 50, message = "memberId size must 3 to 50")
		private String memberId;
		@NotNull
		@Size(min = 3, max = 20, message = "name size must 3 to 20")
		private String name;

		@Min(value = 18)
		private String age;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Response {
		private DeveloperLevel developerLevel;
		private DeveloperSkillType developerSkillType;
		private Integer experienceYears;
		private String memberId;

		public static Response fromEntity(Developer developer) {
			return Response.builder()
				.developerLevel(developer.getDeveloperLevel())
				.developerSkillType(developer.getDeveloperSkillType())
				.experienceYears(developer.getExperienceYears())
				.memberId(developer.getMemberId())
				.build();
		}
	}
}
