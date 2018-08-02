package com.dalonsogarcia.sports_app.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalonsogarcia.sports_app.server.entity.ClanMember;
import com.dalonsogarcia.sports_app.server.repository.MemberRepository;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<ClanMember> getAllMembers() {
        return this.memberRepository.findAll();
    }
}
