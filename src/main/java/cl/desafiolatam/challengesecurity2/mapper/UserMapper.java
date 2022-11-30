package cl.desafiolatam.challengesecurity2.mapper;

import cl.desafiolatam.challengesecurity2.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from users where email = #{email}")
    Users findByEmail(@Param("email") String email);

}
