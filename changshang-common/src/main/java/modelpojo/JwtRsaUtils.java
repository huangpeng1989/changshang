/**
 * Copyright (c) 2007 Beijing Shiji Kunlun Software Co., Ltd. All Rights Reserved.
 * $Id$
 */
package modelpojo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author davin.shi
 * @since 2021-05-25
 */
public class JwtRsaUtils {

    public static final String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCDRrZDlfhzcpa9HlxXtZJsEEzZOrbzLIceEf0D/aYHEzoCa90eIoxQYRMFFWfCRiFU0afd/txtrZB5NjLZ6/KmLVaN2FHkKhqXSk9nwZWwqZX7INVtgjkLX6ow/Ax3oOsTQqs8hQk8TRsj/leLXlBuomT9hVIHIuLQFAGR2W5yiGsEOwqxmRW+OzntwB406Mms2NMVsHCphymHSGXEhS27Kbtc6jGdxhbuQIYMvLSmuVKCh7oK+yoMYB/tF4eUzOLuhaUHeZGum1rbfAyQp3SAZpAf8YadIMubAFkDJ1/K27wGqZ94lS6SNJL+Oj2FggyM7Vxf6DmEh/VoXZDJd4JlAgMBAAECggEAfBXL1IieZqmqmCppiLJlK+YgbbjVE3hEY4UHTs1kMQ3YaE+Cm6h2TsfjTYvVHsphWSYvcWQlATrs89XqLRicrLzwMnWFupCdv+GKuv09u9YgoVaAxtkviHOtkE2+jxk4+mSrLTJm72vGurgAEgldJ6YypXxuc7ZjA+HVNgJ7JqAz+Mjt9yNF1/5+e8wdH+m/a+nfn2b7gBul6EZp9eOJqcFmrVS1Cw3cQw3IvQQqXbKb7rvIm7Py7+BD9w7Mic0a6snmc/9kjPkLUSHDQsujnOSjrENUO1ovl8lwUYQ2P2uLXNV/yKZvDT45rN307fFupz05r3GFMaxeuTNxEVB3xQKBgQDSl6SfOxUWeZAa9SyhlTKPOKx6CTPFRG625QP+VgCVY4P7TOqB6uXAPMntOdEW+9uVV2nlzbHTj1Uda0S0/NPAEAPrar5CTOjiTBMctYjPsbiYJ2B416JA+hoCevlIrwpuVUTrDVGVejDlD1yoYHsbV6DBtLeNaSoQNzWBrEfgDwKBgQCflPJVS6wdvI2BSrIr4saPELnZShWh9snYqb7t8gjmqEtQxxtkxJ84c5LjrYmfeEVyeqpZ9G1TYajoUVZNRk2DDybj6NIzxTxcbMqEf3OZb7ubnvXP29MwZv+N8yhVpwUPhWT/79cIWy8WlfR3J6/e6Rp/RFzgLjip0jwjWAtCSwKBgHAUxUj56P9NM6UlV9unzIDtaN6Kh0M2aLZurPFwVF8t19Cn3yfGHQFzWQUpAF97LCMPowzrrPksD+DYdnjdFtXhsDRbW2duB4RpeMKO24Gu1NAmJPIr0e9DLRSk3ogQoTyXpVZ0gDdOETfYNThoIR0sRiLSS963WevHdnLNfnOBAoGAJEgE4IeX1hrsQRzubTPd2OEAn/pL+MrXET9mfUqt42MX3IGoJLzfRkJgfwsRYwRBJcnluRXtVSu67zau3FrDfKyRNvfT8plBI/JICN/BNH1Gthbp5BwiY7rHF0rVPMQATosRb27kAK5aglQNhJmtTozIzW6Jfx6DG3kE2zRFOwkCgYAgn7FHX2Jj6XEW2oe+MBi938mr2PeTNSkxyojTj3vSd5kq4cqDcrhX5t3/yTnkSwKiNF6w7Oi+TtAG+7RGzPkEW3R48NKG6DUx2OXi8nxrZYaQyEu8QeAzc3DEzILYIh7n36XSA5UkHMqzV3DR2rsOpK56Bs+H5U1wVmEX08MdOw==";

    public static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg0a2Q5X4c3KWvR5cV7WSbBBM2Tq28yyHHhH9A/2mBxM6AmvdHiKMUGETBRVnwkYhVNGn3f7cba2QeTYy2evypi1WjdhR5Coal0pPZ8GVsKmV+yDVbYI5C1+qMPwMd6DrE0KrPIUJPE0bI/5Xi15QbqJk/YVSByLi0BQBkdlucohrBDsKsZkVvjs57cAeNOjJrNjTFbBwqYcph0hlxIUtuym7XOoxncYW7kCGDLy0prlSgoe6CvsqDGAf7ReHlMzi7oWlB3mRrpta23wMkKd0gGaQH/GGnSDLmwBZAydfytu8BqmfeJUukjSS/jo9hYIMjO1cX+g5hIf1aF2QyXeCZQIDAQAB";

    public static final String ISSUER = "kunlun";

    public static final String SUBJECT = "clota";

    public static final String PREFERRED_USERNAME = "preferred_username";

    /**
     * 获取私钥
     *
     * @param priStr
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String priStr) {

        byte[] keyBytes = Base64.getDecoder().decode(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        PrivateKey privateKey=null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    /**
     * 获取公钥
     *
     * @param pubStr
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String pubStr) throws Exception {

        byte[] keyBytes = Base64.getDecoder().decode(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    public static String generateJwtToken(Map<String, String> parameters) {
        LocalDateTime nowTime = LocalDateTime.now();
        Instant issuerAt = Instant.ofEpochSecond(nowTime.toEpochSecond((ZoneOffset.ofHours(8))));
        Instant expiration = Instant.ofEpochSecond(nowTime.plusHours(10).toEpochSecond(ZoneOffset.ofHours(8)));

        DefaultClaims claims = new DefaultClaims();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            claims.put(entry.getKey(), entry.getValue());
        }
        claims.setIssuedAt(Date.from(issuerAt));
        claims.setExpiration(Date.from(expiration));
        claims.setIssuer(ISSUER);
        claims.setId(UUID.randomUUID().toString());
        claims.setSubject(SUBJECT);
        claims.put("typ", "Bearer");
        String token = Jwts.builder()
                .setClaims(claims)
                .setHeaderParam("typ", Header.JWT_TYPE)
                .signWith(SignatureAlgorithm.RS256,JwtRsaUtils.getPrivateKey()).compact();
        return token;
    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        Claims claims = Jwts.parser().setSigningKey(getPrivateKey()).parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static PrivateKey getPrivateKey() {
        String encodedPrivateKey = JwtRsaUtils.privateKey;
        PrivateKey privateKey = JwtRsaUtils.getPrivateKey(encodedPrivateKey);
        return privateKey;
    }
}
