package com.dalonsogarcia.sports_app.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dalonsogarcia.sports_app.server.entity.ClanMember;

import java.util.List;

@Repository
public class JDBCMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCMemberRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ClanMember> findAll() {
        return jdbcTemplate.query("SELECT id, name, uuid FROM member", (resultSet, rowNum) -> new ClanMember(resultSet));
    }
}
