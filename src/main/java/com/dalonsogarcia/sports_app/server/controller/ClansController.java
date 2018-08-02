package com.dalonsogarcia.sports_app.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.dalonsogarcia.sports_app.server.entity.Clan;
import com.dalonsogarcia.sports_app.server.repository.ClanRepository;
import com.dalonsogarcia.sports_app.server.request.CreateClanRequest;
import com.dalonsogarcia.sports_app.server.service.ClanService;

import java.util.List;
import java.util.UUID;

@RestController
public class ClansController {

    private final ClanService clanService;

    @Autowired
    public ClansController(final ClanService clanService) {
        this.clanService = clanService;
    }

    @GetMapping("/clans")
    @ResponseBody
    public List<Clan> getAllClans() {
        return clanService.getAllClans();
    }

    @PostMapping("/clans")
    public ResponseEntity createClan(final @RequestBody CreateClanRequest createClanRequest) {
        final UUID newClanUUID = clanService.createClan(createClanRequest);
        final UriBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.pathSegment("/api", "/clans", newClanUUID.toString(),"/");
        return ResponseEntity.created(uriBuilder.build()).build();
    }

    @GetMapping("/clans/{uuid}")
    @ResponseBody
    public Clan getClanForId(final @PathVariable UUID uuid) {
        return clanService.getClanForUuid(uuid);
    }
}
