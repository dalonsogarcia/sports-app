package com.dalonsogarcia.sports_app.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalonsogarcia.sports_app.server.entity.Clan;
import com.dalonsogarcia.sports_app.server.repository.ClanRepository;
import com.dalonsogarcia.sports_app.server.request.CreateClanRequest;

import java.util.List;
import java.util.UUID;

@Service
public class ClanServiceImpl implements ClanService {

    private final ClanRepository clanRepository;

    @Autowired
    public ClanServiceImpl(final ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    @Override
    public UUID createClan(final CreateClanRequest createClanRequest) {
        return this.clanRepository.save(Clan.fromRequest(createClanRequest)).getUuid();
    }

    @Override
    public List<Clan> getAllClans() {
        return clanRepository.findAll();
    }

    @Override
    public Clan getClanForUuid(final UUID uuid) {
        return clanRepository.findByUuid(uuid);
    }
}
