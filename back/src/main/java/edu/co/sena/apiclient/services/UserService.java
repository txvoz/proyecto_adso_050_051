package edu.co.sena.apiclient.services;

import edu.co.sena.apiclient.constants.Constants;
import edu.co.sena.apiclient.contracts.RolResponseDto;
import edu.co.sena.apiclient.contracts.UserRequestCreateDto;
import edu.co.sena.apiclient.contracts.UserRequestUpdateAvatarDto;
import edu.co.sena.apiclient.contracts.UserResponseDetailDto;
import edu.co.sena.apiclient.entities.RolEntity;
import edu.co.sena.apiclient.entities.UserEntity;
import edu.co.sena.apiclient.exceptions.ResourceNotFoundException;
import edu.co.sena.apiclient.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RolService rolService;

    public long create(UserRequestCreateDto dto){
        UserEntity entity = new UserEntity();

        entity.setFullName(dto.getFullName());
        entity.setColor(dto.getColor()); // Hexadecimal #ff00011
        entity.setBornDate(dto.getBornDate()); // Sea mayor de edd
        entity.setEmail(dto.getEmail()); // formato email
        entity.setPhone(dto.getPhone()); // formato telefono valido para colombia
        entity.setAvatar(dto.getAvatar()); // El nombre de la imagen
        entity.setPassword("1234");

        Long rolId =  dto.getRol();
        RolEntity rol = this.rolService.getRolEntity(rolId);

        entity.setRol(rol);

        //yo debo hacer las validaciones de negocio
        entity = this.repository.save(entity);
        return entity.getId();
    }

    public List<UserResponseDetailDto> getAllUsers(){

        List<UserEntity> usuarios = this.repository.findAll();
        ArrayList<UserResponseDetailDto> dtos = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) {
            UserEntity currentEntity = usuarios.get(i);
            UserResponseDetailDto dto = new UserResponseDetailDto();

            dto.setFullName(currentEntity.getFullName());
            dto.setColor(currentEntity.getColor());
            dto.setEmail(currentEntity.getEmail());
            dto.setEmail(currentEntity.getEmail());
            dto.setPhone(currentEntity.getPhone());
            dto.setId(currentEntity.getId());
            dto.setBornDate(currentEntity.getBornDate());
            dto.setAvatarFilePath(this.getAvatar(currentEntity));

            dto.setRol(RolResponseDto.builder()
                            .id(currentEntity.getRol().getId())
                            .title(currentEntity.getRol().getTitle())
                    .build());

            dtos.add(dto);
        }

        return dtos;
    }

    public UserResponseDetailDto getById(Long id){
        UserEntity entity = this.repository.findById(id).get();

        UserResponseDetailDto dto = new UserResponseDetailDto();

        dto.setFullName(entity.getFullName());
        dto.setColor(entity.getColor());
        dto.setEmail(entity.getEmail());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setId(entity.getId());
        dto.setBornDate(entity.getBornDate());
        dto.setAvatarFilePath(getAvatar(entity));

        dto.setRol(RolResponseDto.builder()
                .id(entity.getRol().getId())
                .title(entity.getRol().getTitle())
                .build());

        return dto;
    }

    public void update(UserRequestCreateDto dto, Long id){
        UserEntity entity = this.repository.findById(id).get();

        entity.setFullName(dto.getFullName());
        entity.setColor(dto.getColor());
        entity.setBornDate(dto.getBornDate());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        this.repository.save(entity);
    }

    public void delete(Long id){
        UserEntity entity = this.repository.findById(id).get();
        this.repository.deleteById(id);
    }

    public void updateAvatar(UserRequestUpdateAvatarDto userUpdateAvatar){

        UserEntity entity = this.repository.findById(userUpdateAvatar.getId()).get();
        entity.setAvatar(userUpdateAvatar.getAvatar());

        this.repository.save(entity);
    }

    private String getAvatar(UserEntity e) {
        if( e.getAvatar() != null && this.existAvatar(e.getAvatar())) {
            return Constants.AVATAR_BASE_PATH + e.getAvatar();
        }

        return Constants.NOT_FOUND_IMAGE;
    }

    private boolean existAvatar(String avatar) {
        String filePath = Constants.PATH_UPLOAD + avatar;
        File file = new File(filePath);
        return  file.exists();
    }

    public UserResponseDetailDto getByEmail(String email){
        UserEntity entity = this.repository.getByEmail(email);

        if(Objects.isNull(entity)) {
            throw new ResourceNotFoundException();
        }

        UserResponseDetailDto dto = new UserResponseDetailDto();

        dto.setFullName(entity.getFullName());
        dto.setColor(entity.getColor());
        dto.setEmail(entity.getEmail());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setId(entity.getId());
        dto.setBornDate(entity.getBornDate());
        dto.setAvatarFilePath(getAvatar(entity));

        dto.setRol(RolResponseDto.builder()
                .id(entity.getRol().getId())
                .title(entity.getRol().getTitle())
                .build());

        return dto;
    }


}
