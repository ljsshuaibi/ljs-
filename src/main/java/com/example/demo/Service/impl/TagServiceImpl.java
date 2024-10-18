package com.example.demo.Service.impl;

import com.example.demo.Service.TagService;
import com.example.demo.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private com.example.demo.Dao.TagDao TagDao;
    @Override
    public List<Tag> SelectAllTag(){
        return TagDao.SelectAll();
    }
    @Override
    public int EditTag(Tag tag){
        return TagDao.EditTag(tag);
    }
    @Override
    public int DeleteTag(Tag tag){
        return TagDao.DeleteTag(tag);
    }
    @Override
    public int AddTag(Tag tag){
        return TagDao.AddTag(tag);
    }
}
