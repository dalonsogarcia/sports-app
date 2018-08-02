package com.dalonsogarcia.sports_app.server.entity;

import com.dalonsogarcia.sports_app.server.request.CreateClanRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Clan {

    private long id;
    private String name;
    private UUID uuid;

    public Clan(final ResultSet resultSet) throws SQLException {
        this.id = resultSet.getLong("id");
        this.name = resultSet.getString("name");
        this.uuid = UUID.nameUUIDFromBytes(resultSet.getBytes("uuid"));
    }

    private Clan(final String name) {
        this.name = name;
    }

    public static Clan fromRequest(final CreateClanRequest createClanRequest) {
        return new Clan(createClanRequest.getName());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
}
