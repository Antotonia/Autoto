package com.spmy.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public interface UserMapper {
    @Select({"select * from user where id = #{id}"})
    Map<String,Object> findById(@Param("id") int id);
}


