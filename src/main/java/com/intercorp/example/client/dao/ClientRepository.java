package com.intercorp.example.client.dao;

import com.intercorp.example.client.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface  ClientRepository  extends CrudRepository<Client, String>, QueryByExampleExecutor<Client> {
    List<Client> findAll();
}
