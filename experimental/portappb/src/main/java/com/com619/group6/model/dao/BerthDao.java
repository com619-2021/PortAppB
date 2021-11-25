package com.com619.group6.model.dao;

import com.com619.group6.model.Berth;

import java.util.List;

public interface BerthDao {
    void create(Berth berth);
    List<Berth> getAll();
    Berth getOne(long Id);
    Berth getOne(String name);
    void update(String name, Berth details);
    void delete(Berth berth);
}
