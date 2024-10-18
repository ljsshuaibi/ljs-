package com.example.demo.Service;

import com.example.demo.entity.Tag;

import java.util.List;

public interface TagService {
    public List<Tag> SelectAllTag();
    public int EditTag(Tag tag);
    public int DeleteTag(Tag tag);
    public int AddTag(Tag tag);
}
