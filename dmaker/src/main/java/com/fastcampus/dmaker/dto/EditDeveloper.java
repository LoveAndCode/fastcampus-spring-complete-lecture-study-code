package com.fastcampus.dmaker.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fastcampus.dmaker.type.DeveloperLevel;
import com.fastcampus.dmaker.type.DeveloperSkillType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class EditDeveloper {

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
		@Max(20)
		private Integer experienceYears;
	}
}
