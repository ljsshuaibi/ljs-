package com.example.demo.Dao;

import com.example.demo.entity.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagDao {
    @Select("select * from tag")
    public List<Tag> SelectAll();
    @Update("update tag set TagName=#{TagName},Count=#{Count} where TagName=#{TagName}")
    public int EditTag(Tag tag);
    @Delete("delete from tag where TagName=#{TagName}")
    public int DeleteTag(Tag tag);
    @Insert("insert into tag(TagName,Count) values(#{TagName},#{Count})")
    public int AddTag(Tag tag);
    @Select("select * from tag where TagName=#{TagName}")
    public Tag SelectByName(String TagName);

}
