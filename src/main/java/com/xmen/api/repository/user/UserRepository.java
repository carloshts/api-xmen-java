package com.xmen.api.repository.user;

import java.util.List;

import com.xmen.api.entity.user.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User,String> {
    //@Query('SELECT FROM User WHERE User.nome = :nome')
    public List<User> findByNome(String nome);
    public List<User> findBySenha(String senha);

    @Query(value="{nome:'?0',senha:'?1'}", fields="{'nome' : 1, 'senha' : 1}")
    public List<User> findByLogin(String nome, String senha);
}
