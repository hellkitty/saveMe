package org.heartbeater.saveme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/member/*")
public class MemberController {

	@RequestMapping(value="register")
	public void memberRegister(){
		
	}
}
