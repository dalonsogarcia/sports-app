package com.dalonsogarcia.sports_app.server.repository;

import com.dalonsogarcia.sports_app.server.entity.ClanMember;

import java.util.List;

public interface MemberRepository {
    List<ClanMember> findAll();
}
