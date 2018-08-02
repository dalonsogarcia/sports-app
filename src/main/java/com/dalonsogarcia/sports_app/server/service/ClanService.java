package com.dalonsogarcia.sports_app.server.service;

import com.dalonsogarcia.sports_app.server.entity.Clan;
import com.dalonsogarcia.sports_app.server.request.CreateClanRequest;

import java.util.List;
import java.util.UUID;

public interface ClanService {
    UUID createClan(CreateClanRequest createClanRequest);

    List<Clan> getAllClans();

    Clan getClanForUuid(UUID uuid);
}
