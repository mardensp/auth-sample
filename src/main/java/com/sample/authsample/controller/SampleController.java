package com.sample.authsample.controller;

import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sample")
public class SampleController {

    @PreAuthorize("hasAuthority('ROLE_SAMPLE_VIEWER')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void sample() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("Sample");
    }

    @PreAuthorize("hasAuthority('ROLE_SAMPLE_CREATER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void samplePost() {
        System.out.println("Sample Post");
    }

}
