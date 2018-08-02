package com.dalonsogarcia.sports_app.server.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ClanMember {

    private long id;
    private String name;
    private UUID uuid;

    public ClanMember(final ResultSet resultSet) throws SQLException {
        this.id = resultSet.getLong("id");
        this.name = resultSet.getString("name");
        this.uuid = UUID.nameUUIDFromBytes(resultSet.getBytes("uuid"));
    }

    public ClanMember(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }
}
