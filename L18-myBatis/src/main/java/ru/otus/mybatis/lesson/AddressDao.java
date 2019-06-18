package ru.otus.mybatis.lesson;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PersonDao {

    @Insert("insert into person (id, first_name, last_name) values (#{id}, #{firstName}, #{lastName})")
    int insert(Person person);

    @Select("select * from person where id = #{id}")
    Person selectOne(int id);

}
