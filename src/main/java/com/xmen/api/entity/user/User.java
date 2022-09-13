package com.xmen.api.entity.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class User{
    @Id
    private String _id;
    private String nome;
    private String senha;

    public String getId() {
        return _id;
    }
    public void setId(String _id) {
        this._id = _id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
