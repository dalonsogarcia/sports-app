package com.dalonsogarcia.sports_app.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalonsogarcia.sports_app.server.entity.ClanMember;
import com.dalonsogarcia.sports_app.server.service.MemberService;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members")
    public List<ClanMember> getAllMembers() {
        return this.memberService.getAllMembers();
    }
}
