package com.chanheng.stock1.api.user;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public String buildInsertSql(){
        return new SQL(){{
            INSERT_INTO("users");
            VALUES("uuid", "#{user.uuid}");
            VALUES("username", "#{user.username}");
            VALUES("family_name", "#{user.familyName}");
            VALUES("given_name", "#{user.givenName}");
            VALUES("gender", "#{user.gender}");
            VALUES("dob", "#{user.dob}");
            VALUES("phone", "#{user.phone}");
            VALUES("biography", "#{user.biography}");
            VALUES("status", "#{user.status}");
        }}.toString();
    }

    public String buildSelectByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("id = #{id}");
        }}.toString();
    }
}
