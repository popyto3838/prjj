package com.prjj.mapper;

import com.prjj.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO member
            (email, password, nick_name)
            VALUES (#{email}, #{password}, #{nickName})
            """)
    void insert(Member member);


    @Select("""
            SELECT*
            FROM member
            ORDER BY id DESC
            """)
    List<Member> selectAll();


    @Select("""
            SELECT*
            FROM member
            WHERE id=#{id}
            """)
    Member selectById(Integer id);

    @Delete("""
            DELETE FROM member
            WHERE id=#{id}
            """)
    void deleteById(Integer id);


    @Update("""
            UPDATE member
            SET password=#{password}, nick_name=#{nickName}
            WHERE id=#{id}
            """)
    void update(Member member);

    @Select("""
            SELECT*
            FROM member
            WHERE email=#{email}       
            """)
    Member selectByEmail(String email);
}
