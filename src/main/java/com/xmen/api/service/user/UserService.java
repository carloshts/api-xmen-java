package com.xmen.api.service.user;

import com.xmen.api.dto.ReturnDTO;
import com.xmen.api.entity.user.User;
import com.xmen.api.repository.user.UserRepository;

import org.springframework.http.HttpStatus;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ReturnDTO createUser(User user){
        ReturnDTO returnDTO = new ReturnDTO();
        if(user.getNome() == null){
            returnDTO.setCode(Long.valueOf(204));
            returnDTO.setMessage("Campo obrigatorio NOME.");
            returnDTO.setObject(null);
            return returnDTO;
        }
        try{
            returnDTO.setCode(Long.valueOf(201));
            returnDTO.setMessage("Cadastro feito com sucesso");
            returnDTO.setObject(userRepository.save(user));
            return returnDTO;
        }catch(Exception e){
            returnDTO.setCode(Long.valueOf(500));
            returnDTO.setMessage("Erro:"+e.getMessage());
            returnDTO.setObject(e);
            return returnDTO;
        }
        
    }
}
