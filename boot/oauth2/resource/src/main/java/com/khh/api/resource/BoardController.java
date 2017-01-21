package com.khh.api.resource;

import com.khh.api.resource.domain.Board;
import com.omnicns.web.spring.security.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController extends Controller{

	@GetMapping(path = "/list")
	public Board list(){
		SecurityUtil.getGrantedAuthorityList().forEach(at->{
			log.debug("-----"+at);
		});
		Board board = new Board((long) 1,"44","55","66");
		return board;
	}
	@GetMapping(path = "/admin")
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PreAuthorize("#oauth2.hasScope('babo')")
	public String admin(){
		SecurityUtil.getGrantedAuthorityList().forEach(at->{
			log.debug("-----"+at);
		});
		return "ok";
	}
}
