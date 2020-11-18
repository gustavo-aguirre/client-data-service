package com.intercorp.example.client.dao;

import com.intercorp.example.client.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface  ClientRepository  extends CrudRepository<Client, String> {
}
