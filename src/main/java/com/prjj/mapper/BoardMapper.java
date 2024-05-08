package com.prjj.mapper;

import com.prjj.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
            Insert Into board (title,content,writer)
            VALUES (#{title}, #{content},#{writer}) 
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Board board);


    @Select("""
            SELECT*
            FROM board WHERE id = #{id}
            """)
    Board selectByid(Integer id);


    @Select("""
            SELECT *
            FROM board
            ORDER BY id DESC
            """)
    List<Board> selectAll();

    @Delete("""
            DELETE FROM board
            WHERE id = #{id}
            """)
    void deleteById(Integer id);

    @Update("""
            UPDATE board
            SET title=#{title},content=#{content},writer=#{writer}
            WHERE id= #{id}
            """)
    void update(Board board);
}
