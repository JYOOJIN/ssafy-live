package com.ssafy.admin.controller;

import java.nio.charset.StandardCharsets;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminUserController {

	private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

	private MemberService memberService;

	public AdminUserController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping(value = "/user")
	public ResponseEntity<?> userList() {
		logger.debug("userList call");
		try {
			List<MemberDto> list = memberService.listMember(null);
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@PostMapping(value = "/user")
	public ResponseEntity<?> userRegister(
			 @org.springframework.web.bind.annotation.RequestBody MemberDto memberDto) {
		logger.debug("userRegister memberDto : {}", memberDto);
		try {
			memberService.joinMember(memberDto);
			List<MemberDto> list = memberService.listMember(null);
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			return ResponseEntity.ok().headers(headers).body(list);
//			return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
//			return ResponseEntity.status(HttpStatus.CREATED).body(cnt);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@Operation(summary = "회원정보", description = "입력한 회원 아이디를 이용하여 회원에 대한 정보를 조회.")
	@Parameters({
			@Parameter(name = "userid", description = "회원아이디", required = true, in = ParameterIn.PATH, example = "hissam"),
//			@Parameter(name = "param1", description = "파라미터1", required = true, in = ParameterIn.QUERY)
//			@Parameter(name = "param2", description = "파마미터2", required = false, in = ParameterIn.PATH) 
	})
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "성공!!"),
			@ApiResponse(responseCode = "400", description = "파라미터 오류!!") })
	@GetMapping(value = "/user/{userid}")
	public ResponseEntity<?> userInfo(
			@Parameter(required = true, description = "검색할 사용자의 아이디") @PathVariable("userid") String userId) {
		logger.debug("userInfo userid : {}", userId);
		try {
			MemberDto memberDto = memberService.getMember(userId);
			if (memberDto != null) {
//				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
				return ResponseEntity.ok().headers(headers).body(memberDto);
			} else
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//				return ResponseEntity.notFound().build();
				return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@Operation(summary = "회원정보수정", description = "회원정보를 수정.")
	@PutMapping(value = "/user")
	public ResponseEntity<?> userModify(
			@RequestBody(description = "수정할 회원정보.", required = true, content = @Content(schema = @Schema(implementation = MemberDto.class))) @org.springframework.web.bind.annotation.RequestBody MemberDto memberDto) {
		logger.debug("userModify memberDto : {}", memberDto);
		try {
			memberService.updateMember(memberDto);
			List<MemberDto> list = memberService.listMember(null);
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			return ResponseEntity.ok().headers(headers).body(list);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@Operation(summary = "회원정보삭제", description = "회원정보를 삭제.")
	@DeleteMapping(value = "/user/{userid}")
	public ResponseEntity<?> userDelete(
			@Parameter(required = true, description = "삭제할 사용자의 아이디") @PathVariable("userid") String userId) {
		logger.debug("userDelete userid : {}", userId);
		try {
			memberService.deleteMember(userId);
			List<MemberDto> list = memberService.listMember(null);
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
			return ResponseEntity.ok().headers(headers).body(list);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
//		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error : " + e.getMessage());
	}

}
