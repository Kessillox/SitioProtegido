package cl.desafiolatam.challengesecurity2.mapper;

import cl.desafiolatam.challengesecurity2.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {//En esta interfaz se realizan las consultas a la base de datos,

    @Select("select * from users where email = #{email}")//Para iniciar, debe escribir el método abstracto y anotarlo con @Select, dentro de la anotación va la consulta en SQL. Los parámetros se pasan en la consulta con un #{}
    Users findByEmail(@Param("email") String email);//se reciben también como parámetros en el método para ser anotado 

}
