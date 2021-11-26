package com.com619.group6.model.dao;

import com.com619.group6.model.Berth;

import java.util.List;

public interface BerthDao {
    void create(Berth newBerth);
    Berth getOne(long Id);
    Berth getOne(String name);
    List<Berth> getAll();
    void update(String name, Berth details);
    void deleteOne(Berth berth);
    void deleteAll();
}
