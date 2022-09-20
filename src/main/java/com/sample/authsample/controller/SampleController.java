package com.sample.authsample.controller;

import com.sample.authsample.dto.SampleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("api/sample")
public class SampleController {

    //@PreAuthorize("hasAuthority('ROLE_SAMPLE_VIEWER')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SampleDTO> sample() {

        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getCredentials();

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.setId(jwt.getId());
        sampleDTO.setAutheticated(true);

        return ResponseEntity.ok(sampleDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_SAMPLE_CREATER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void samplePost() {
        System.out.println("Sample Post");
    }

}
