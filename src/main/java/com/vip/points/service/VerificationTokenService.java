package com.vip.points.service;


import com.vip.points.model.VerificationToken;

public interface VerificationTokenService {
    VerificationToken save(VerificationToken token);

    VerificationToken findByToken(String token);
}
