package com.fastcampus.dmaker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.dmaker.dto.CreateDeveloper;
import com.fastcampus.dmaker.dto.DeveloperDetailDto;
import com.fastcampus.dmaker.dto.DeveloperDto;
import com.fastcampus.dmaker.dto.EditDeveloper;
import com.fastcampus.dmaker.service.DMakerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
	private final DMakerService dMakerService;

	@GetMapping("/developers")
	public List<DeveloperDto> getAllDevelopers() {
		log.info("GET /developers HTTP/1.1");
		return dMakerService.getAllDevelopers();
	}

	@GetMapping("/developers/{memberId}")
	public DeveloperDetailDto getDeveloperDetail(@PathVariable("memberId") String memberId) {
		log.info("GET /developers/{} HTTP/1.1", memberId);
		return dMakerService.getDeveloperDetail(memberId);
	}

	@PostMapping("/create-developers")
	public CreateDeveloper.Response createDevelopers(
		@RequestBody @Valid CreateDeveloper.Request request
	) {
		log.info("request : {}", request);
		return dMakerService.createDeveloper(request);
	}

	@PutMapping("/developers/{memberId}")
	public DeveloperDetailDto editDeveloperDetail(
		@PathVariable("memberId") String memberId,
		@RequestBody @Valid EditDeveloper.Request request
	) {
		return dMakerService.editDeveloperDetail(memberId, request);
	}
}
