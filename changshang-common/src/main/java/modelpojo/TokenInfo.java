package modelpojo;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by lufei on 2017/7/16.
 */
public class TokenInfo {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenInfo.class);

    private static final String ENCRYPT_KEY = "KLWK234XSE095OK0Y7KERF345TFH23OP";

    private static String HENGXIAN = "_";

    private String token;

    private Long accountId;

    private Long companyId;

    private Long organizeId;

    private Long scenicId;

    private Long channelOrgId;

    //产生时间，秒
    private long createTime;
    //有效时长，秒
    private long expire;

    public TokenInfo() {
    }

    public TokenInfo(Long accountId, Long companyId, Long organizeId , long expire) {
        this(accountId,companyId,organizeId,0L,0L,expire);
    }

    public TokenInfo(Long accountId, Long companyId, Long organizeId, Long scenicId, Long channelOrgId, long expire) {
        this.accountId = Objects.isNull(accountId) ? 0L : accountId;
        this.companyId = Objects.isNull(companyId) ? 0L : companyId;
        this.organizeId = Objects.isNull(organizeId) ? 0L : organizeId;
        this.scenicId = Objects.isNull(scenicId) ? 0L : scenicId;
        this.channelOrgId = Objects.isNull(channelOrgId) ? 0L : channelOrgId;
        this.createTime = System.currentTimeMillis() / 1000;
        this.expire = expire;
        this.token = createToken( this.accountId, this.companyId, this.organizeId, this.scenicId, this.channelOrgId, this.createTime, this.expire);
    }

    /**
     * 解析出token字符串中包含的内容(by:zhofueng)
     *
     * @param token
     * @return
     */
    public static TokenInfo parseOldToken(String token) {
        token = StringUtils.replace(token, " ", "+");
        String tokenSource = null;
        try {
            tokenSource = DesUtils.decryptString(ENCRYPT_KEY, token);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
                | BadPaddingException | UnsupportedEncodingException e) {
            return null;
        }
        if (StringUtils.isBlank(tokenSource)) {
            return null;
        }
        String[] tokens = tokenSource.split(HENGXIAN);
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setAccountId(Long.parseLong(tokens[0]));
        tokenInfo.setCompanyId(Long.parseLong(tokens[1]));
        tokenInfo.setOrganizeId(Long.parseLong(tokens[2]));
        tokenInfo.setScenicId("null".equals(tokens[3])?0L:Long.parseLong(tokens[3]));
        tokenInfo.setChannelOrgId("null".equals(tokens[4])?0L:Long.parseLong(tokens[4]));
        tokenInfo.setCreateTime(Long.valueOf(tokens[5]));
        tokenInfo.setExpire(Long.valueOf(tokens[6]));
        return tokenInfo;
    }

    /**
     * 解析出token字符串中包含的内容(by:zhofueng)
     *
     * @param token
     * @return
     */
    public static TokenInfo parseToken(String token) {
//        token = StringUtils.replace(token, " ", "+");
//        String tokenSource = null;
        Claims claims;
        try {
//            tokenSource = DesUtils.decryptString(ENCRYPT_KEY, token);
             claims = JwtRsaUtils.parseJWT(token);
        } catch (Exception e) {
            TokenInfo tokenInfo = parseOldToken(token);
            return tokenInfo;
        }
        if (Objects.isNull(claims)) {
            return null;
        }
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setAccountId(Objects.isNull(claims.get("accountId"))?0L:Long.parseLong(claims.get("accountId").toString()));
        tokenInfo.setCompanyId(Objects.isNull(claims.get("companyId"))?0L:Long.parseLong(claims.get("companyId").toString()));
        tokenInfo.setOrganizeId(Objects.isNull(claims.get("organizeId"))?0L:Long.parseLong(claims.get("organizeId").toString()));
        tokenInfo.setScenicId(Objects.isNull(claims.get("scenicId"))?0L:Long.parseLong(claims.get("scenicId").toString()));
        tokenInfo.setChannelOrgId(Objects.isNull(claims.get("channelOrgId"))?0L:Long.parseLong(claims.get("channelOrgId").toString()));
        tokenInfo.setCreateTime(claims.getIssuedAt().getTime());
        tokenInfo.setExpire(claims.getExpiration().getTime());
        return tokenInfo;
    }


    /**
     * 生成token
     *
     * @param userId
     * @param companyId
     * @param expire    秒
     * @return
     */
    private static String createToken(Long userId,Long companyId,Long organizeId, Long scenicId, Long channelOrgId, Long createTime, Long expire) {

        HashMap<String, String> map = new HashMap<>();
        map.put("accountId", userId.toString());
        map.put("companyId", companyId.toString());
        map.put("organizeId", organizeId.toString());
        map.put("scenicId", scenicId.toString());
        map.put("channelOrgId", channelOrgId.toString());
        String token = JwtRsaUtils.generateJwtToken(map);
//        String message = String.format("%s_%s_%s_%s_%s_%s_%s", userId, companyId, organizeId, scenicId, channelOrgId, createTime, expire);
//        String token = null;
//        try {
//            token = DesUtils.encryptString(ENCRYPT_KEY, message);
//            token = token.trim();
//        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
//                | BadPaddingException | UnsupportedEncodingException e) {
//            LOGGER.error("get token error!", e);
//        }
        return token;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "accountId=" + accountId +
                ", companyId=" + companyId +
                ", organizeId=" + organizeId +
                ", scenicId=" + scenicId +
                ", channelOrgId=" + channelOrgId +
                ", createTime=" + createTime +
                ", expire=" + expire +
                '}';
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Long organizeId) {
        this.organizeId = organizeId;
    }

    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public Long getChannelOrgId() {
        return channelOrgId;
    }

    public void setChannelOrgId(Long channelOrgId) {
        this.channelOrgId = channelOrgId;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(System.currentTimeMillis());
        System.out.println(date.getTime());

        String str = "Unf529q1iL+ofRE4Lpo3GWEl35rY5PSvpJUbAmCdG31FyBTQUBVSLFJ3+dvatYi/qH0ROC6aNxndEN/ZUz4Rii28Ap7Va1lb73oOT6R4eIyBO0WZeF6Ttg==" ;
        String str2 = "x7DB9EuEQNM2llj/G7Mwka7m/mg2qhBgk0WMAKplZtN7I71+pOWOvMewwfRLhEDTJcbB2mHzwVvKeyNnLtD7xVdd1nF1Szyc0MzmxT9e/vGBO0WZeF6Ttg==" ;
//        TokenInfo tokenInfo = TokenInfo.parseToken(str);
//        String token = TokenInfo.createToken(tokenInfo.getAccountId(),tokenInfo.getCompanyId(),tokenInfo.getOrganizeId(),tokenInfo.getScenicId(), tokenInfo.getChannelOrgId(), System.nanoTime(), 10 * 60 * 60 * 1000L);
//        System.out.println("token:"+token);
//        System.out.println(tokenInfo);
//        System.out.println(tokenInfo.getOrganizeId());
//        System.out.println(tokenInfo.getChannelOrgId());

//        String token = new TokenInfo(1L,2L,3L,0L, 0L, 10 * 60 * 60 * 1000L).getToken();
        TokenInfo tokenInfo = TokenInfo.parseToken(str);
        TokenInfo tokenInfo2 = TokenInfo.parseToken(str2);
//        System.out.println(str);
        System.out.println(tokenInfo); System.out.println(tokenInfo2);
//        System.out.println(tokenInfo.getAccountId());
//        System.out.println(tokenInfo.getCompanyId());
//        System.out.println(tokenInfo.getOrganizeId());
//        System.out.println(tokenInfo.getScenicId());
//        System.out.println(tokenInfo.getChannelOrgId());
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(new Date(tokenInfo.getCreateTime())));
//        System.out.println(simpleDateFormat.format(new Date(tokenInfo.getExpire())));
    }
}
