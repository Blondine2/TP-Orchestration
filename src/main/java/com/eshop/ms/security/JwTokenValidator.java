package com.eshop.ms.security;

import java.security.interfaces.RSAPublicKey;
import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.eshop.ms.model.UserContext;
import com.eshop.ms.setting.InfraSettings;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Service
public class JwTokenValidator {
	
	private JWSVerifier verifier;
	
	@PostConstruct
	public void init() {
		verifier = new RSASSAVerifier((RSAPublicKey) InfraSettings.keyPairLoader().getPublic());
		
		
	}
	public UserContext transform(String token) {
		try {
			SignedJWT signedJwt = SignedJWT.parse(token);
			if(!signedJwt.verify(verifier)) {
				throw new RuntimeException(" Impossible to verify this token, it is invalid !");
			}
			if (!validate(signedJwt.getJWTClaimsSet())) {
				throw new RuntimeException(" Impossible to verify this token, it is invalid !");
			}
			UserContext usercontext = new UserContext();
			usercontext.setSubject(signedJwt.getJWTClaimsSet().getSubject());
			
			return usercontext;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	private boolean validate(JWTClaimsSet claims) {
		return validateTokenExpiration(claims) && validateTokenIssuer(claims);
	}
	
	private boolean validateTokenExpiration(JWTClaimsSet claims) {
		return Instant.now().isBefore(claims.getExpirationTime().toInstant());
	}
	private boolean validateTokenIssuer(JWTClaimsSet claims) {
		return claims.getIssuer().equalsIgnoreCase("ESHOP.MEMBERSHIP") ? true : false;
	}
}
