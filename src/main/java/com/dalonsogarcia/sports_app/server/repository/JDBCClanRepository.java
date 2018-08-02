package com.dalonsogarcia.sports_app.server.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dalonsogarcia.sports_app.server.entity.Clan;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

@Repository
public class JDBCClanRepository implements ClanRepository {

    private final static Logger LOGGER = LoggerFactory.getLogger(JDBCClanRepository.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCClanRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Clan> findAll() {
        return jdbcTemplate.query("SELECT id, name, uuid FROM clan", (resultSet, rowNum) -> new Clan(resultSet));
    }

    @Override
    public Clan findById(final long id) {
        LOGGER.info("Request to find id: {}", id);
        return jdbcTemplate.query("SELECT id, name, uuid FROM clan WHERE id = ?", new Object[] { id }, (resultSet, rowNum) -> new Clan(resultSet)).get(0);
    }

    @Override
    public Clan save(final Clan clan) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement("INSERT INTO clan(name) VALUES (?)", new String[] {"id"});
                    ps.setString(1, clan.getName());
                    return ps;
                },
                keyHolder);
        return this.findById(keyHolder.getKey().longValue());
    }

    @Override
    public Clan findByUuid(final UUID uuid) {
        return jdbcTemplate.query("SELECT id, name, uuid FROM clan WHERE uuid = ?", new Object[] { uuid }, (resultSet, rowNum) -> new Clan(resultSet)).get(0);
    }
}
