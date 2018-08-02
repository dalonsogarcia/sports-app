package com.dalonsogarcia.sports_app.server.repository;

import com.dalonsogarcia.sports_app.server.entity.Clan;

import java.util.List;
import java.util.UUID;

public interface ClanRepository {

    List<Clan> findAll();

    Clan findById(long id);

    Clan save(Clan clan);

    Clan findByUuid(UUID id);
}
