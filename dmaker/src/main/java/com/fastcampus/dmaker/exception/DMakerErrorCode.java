package com.fastcampus.dmaker.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DMakerErrorCode {
	LEVEL_EXPERIENCE_YEAR_NOT_MATCH("개발자 레벨과 연차가 맞지 않습니다."),
	DUPLICATE_MEMBER_ID("Member Id가 중복되는 사용자가 있습닏."),
	NO_DEVELOPER("개발자 정보를 찾을 수 없습니다."),
	INTERNAL_SERVER_ERROR("서버에 오류가 발생했습니다."),
	INVALID_REQUEST("잘못된 요청입니다.");

	private String message;
}
