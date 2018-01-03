package com.gomefinance.hl.security.authentication.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Date;

/**
 * 
 * @Author hzj
 * @Date 2017/6/19 18:12
 * @Description :
 */
public class RememberMeTokenRepositoryImpl extends JdbcTokenRepositoryImpl{

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initDataSource(){
        setDataSource(dataSource);
    }


    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        super.createNewToken(token);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        super.updateToken(series, tokenValue, lastUsed);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        return super.getTokenForSeries(seriesId);
    }

    @Override
    public void removeUserTokens(String username) {
        super.removeUserTokens(username);
    }

    @Override
    public void setCreateTableOnStartup(boolean createTableOnStartup) {
        super.setCreateTableOnStartup(createTableOnStartup);
    }
}
