package com.example.Sprint7Final.controllers;

import com.example.Sprint7Final.dtos.TeamRequestDto;
import com.example.Sprint7Final.dtos.TeamResponseDto;
import com.example.Sprint7Final.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
@CrossOrigin
public class TeamController {

	private final TeamService teamService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<TeamResponseDto> getTeams() {
		return teamService.getTeams();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public TeamResponseDto createTeam(@RequestBody TeamRequestDto teamRequestDto) {
		return teamService.createTeams(teamRequestDto);
	}

	@GetMapping("/{companyId}")
	public List<TeamResponseDto> getTeamsByCompanyId(@PathVariable Long companyId) {
		return teamService.getTeamsByCompanyId(companyId);
	}

}