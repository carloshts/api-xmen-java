package com.xmen.api.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xmen.api.dto.ReturnDTO;
import com.xmen.api.entity.user.User;
import com.xmen.api.repository.user.UserRepository;

import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
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
    public ReturnDTO findByNome(String nome){
        ReturnDTO returnDTO = new ReturnDTO();
        try {
            List<User> users = new ArrayList<>();
            if(!nome.isEmpty()) users = userRepository.findByNome(nome);
            returnDTO.setObject(users);
            returnDTO.setCode(Long.valueOf(200));
            returnDTO.setMessage("Pesquisa Realizada Com sucesso!");
            return returnDTO;
        } catch (Exception e) {
            returnDTO.setCode(Long.valueOf(500));
            returnDTO.setMessage("Erro:"+e.getMessage());
            returnDTO.setObject(e);
            return returnDTO;
        }
    }
    public ReturnDTO findAll(){
        ReturnDTO returnDTO = new ReturnDTO();
        try {
            List<User> users = new ArrayList<>();
            users = userRepository.findAll();
            returnDTO.setObject(users);
            returnDTO.setCode(Long.valueOf(200));
            returnDTO.setMessage("Pesquisa Realizada Com sucesso!");
            return returnDTO;
        } catch (Exception e) {
            returnDTO.setCode(Long.valueOf(500));
            returnDTO.setMessage("Erro:"+e.getMessage());
            returnDTO.setObject(e);
            return returnDTO;
        }
    }
    public ReturnDTO login(String nome, String senha){
        ReturnDTO returnDTO = new ReturnDTO();
        try {
            List<User> user = userRepository.findByLogin(nome, senha);
            if(!user.isEmpty()){
                returnDTO.setObject(user);
                returnDTO.setCode(Long.valueOf(200));
                returnDTO.setMessage("Pesquisa Realizada Com sucesso!");
            }else{
                returnDTO.setObject(null);
                returnDTO.setCode(Long.valueOf(204));
                returnDTO.setMessage("Usuário não encontrado.");
            }    
            return returnDTO;
        } catch (Exception e) {
            returnDTO.setCode(Long.valueOf(500));
            returnDTO.setMessage("Erro:"+e.getMessage());
            returnDTO.setObject(e);
            return returnDTO;
        }
    }
    public ReturnDTO loginFindOne(String nome, String senha){
        ReturnDTO returnDTO = new ReturnDTO();
        try {
            User user = new User();
            user.setNome(nome);
            user.setSenha(senha);
            Example<User> ex = Example.of(user);
            Optional<User> userFind = userRepository.findOne(ex);
            if(userFind.isPresent()){
                returnDTO.setObject(user);
                returnDTO.setCode(Long.valueOf(200));
                returnDTO.setMessage("Pesquisa Realizada Com sucesso!");
            }else{
                returnDTO.setObject(null);
                returnDTO.setCode(Long.valueOf(204));
                returnDTO.setMessage("Usuário não encontrado");
            }
                
            return returnDTO;
        } catch (Exception e) {
            returnDTO.setCode(Long.valueOf(500));
            returnDTO.setMessage("Erro:"+e.getMessage());
            returnDTO.setObject(e);
            return returnDTO;
        }
    }
    public ReturnDTO updateUser(User user, String id){
        ReturnDTO returnDTO = new ReturnDTO();
        if(user.getNome() == null){
            returnDTO.setCode(Long.valueOf(204));
            returnDTO.setMessage("Campo obrigatorio NOME.");
            returnDTO.setObject(null);
            return returnDTO;
        }
        try{
            Optional<User> userPersist = userRepository.findById(id);
            if(userPersist.isPresent()){
                User userUpdated = userPersist.get();
                userUpdated.setNome(user.getNome());
                userUpdated.setSenha(user.getSenha());
                returnDTO.setCode(Long.valueOf(201));
                returnDTO.setMessage("Cadastro feito com sucesso");
                returnDTO.setObject(userRepository.save(userUpdated));
            }else{
                returnDTO.setCode(Long.valueOf(204));
                returnDTO.setMessage("Usuário não encontrado");
                returnDTO.setObject(null);
            }
            return returnDTO;
        }catch(Exception e){
            returnDTO.setCode(Long.valueOf(500));
            returnDTO.setMessage("Erro:"+e.getMessage());
            returnDTO.setObject(e);
            return returnDTO;
        }
    }

    public ReturnDTO deleteUser(String id){
        ReturnDTO returnDTO = new ReturnDTO();
        try{
            Optional<User> userPersist = userRepository.findById(id);
            if(userPersist.isPresent()){
                 returnDTO.setCode(Long.valueOf(200));
                returnDTO.setMessage("Exclusão feita com sucesso");
                userRepository.deleteById(id);
                returnDTO.setObject(null);
            }else{
                returnDTO.setCode(Long.valueOf(204));
                returnDTO.setMessage("Usuário não encontrado");
                returnDTO.setObject(null);
            }
            return returnDTO;
        }catch(Exception e){
            returnDTO.setCode(Long.valueOf(500));
            returnDTO.setMessage("Erro:"+e.getMessage());
            returnDTO.setObject(e);
            return returnDTO;
        }
    }
}
