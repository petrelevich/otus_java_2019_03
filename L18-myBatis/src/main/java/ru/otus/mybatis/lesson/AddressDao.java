package ru.otus.mybatis.lesson;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AddressDao {

    @Insert("insert into address(id, personId, city) values (#{id}, #{personId}, #{city})")
    int insert(Address person);

    @Select("select * from address where id = #{id}")
    Address selectOne(int id);

}
