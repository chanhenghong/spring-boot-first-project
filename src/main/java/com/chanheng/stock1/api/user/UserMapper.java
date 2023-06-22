package com.chanheng.stock1.api.user;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    //START: For fetch id to latest from database
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    //END:
    @InsertProvider(type = UserProvider.class, method = "buildInsertSql")
    void insert(@Param("user") User user);

    @SelectProvider(type = UserProvider.class, method = "buildSelectByIdSql")
    Optional<User> selectById(@Param("id") Integer id);

    @SelectProvider(type = UserProvider.class, method = "buildSelectSql")
    @Results(id = "userResultMapper", value = {
            @Result(property = "familyName", column = "family_name"),
            @Result(property = "givenName", column = "given_name"),
            @Result(property = "createdAt", column = "created_at")
    })
    List<User> select(@Param("status") Boolean status);
}
