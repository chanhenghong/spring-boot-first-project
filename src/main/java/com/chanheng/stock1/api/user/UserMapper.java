package com.chanheng.stock1.api.user;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface UserMapper {

    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @InsertProvider(type = UserProvider.class, method = "buildInsertSql")
    void insert(@Param("user") User user);

    @SelectProvider(type = UserProvider.class, method = "buildSelectByIdSql")
    Optional<User> selectById(@Param("id") Integer id);
}
