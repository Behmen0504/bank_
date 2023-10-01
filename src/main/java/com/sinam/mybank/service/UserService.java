package com.sinam.mybank.service;//package com.sinam.bank.service;
//
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//    private final FavoriteRepository favoriteRepository;
//    private final OrderRepository orderRepository;
//
//    public List<UserDTO> getUsers() {
////        log.info("ActionLog.getUsers start");
//        List<UserDTO> userDTOS = UserMapper.INSTANCE.mapEntitiesToDtos(userRepository.findAll());
////        log.info("ActionLog.getUsers end");
//        return userDTOS;
//    }
//
//    public UserDTO getUser(Long id) {
////        log.info("ActionLog.getUser start");
//        UserDTO userDTO = UserMapper.INSTANCE.mapEntityToDto(userRepository.findById(id).get());
////        log.info("ActionLog.getUser end");
//        return userDTO;
//    }
//
//    public void addUser(UserRequestDTO requestDTO) {
////        log.info("ActionLog.addUser start");
//        UserEntity userEntity = UserMapper.INSTANCE.mapUserRequestDtoToEntity(requestDTO);
////        userRepository.save(userEntity);
//        log.info("ActionLog.addUser end");
//    }
//
//    public void updateUser(Long id, UserRequestDTO userRequestDTO) {
////        log.info("ActionLog.updateUser start");
//        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> {
////            log.error("ActionLog.updateUser.error user not found with id: {}", id);
//            throw new NotFoundException("USER_NOT_FOUND");
//        });
//        userEntity.setName(userRequestDTO.getName());
//        userEntity.setSurname(userRequestDTO.getSurname());
//        userEntity.setEmail(userRequestDTO.getEmail());
//        userEntity.setPhoneNumber(userRequestDTO.getPhoneNumber());
//        userEntity.setPassword(userRequestDTO.getPassword());
//        userEntity.setGender(userRequestDTO.getGender());
//        userEntity.setStatus(userRequestDTO.getStatus());
//
//        userRepository.save(userEntity);
//        log.info("ActionLog.updateUser end");
//    }
//
//    @Transactional
//    public void deleteUser(Long id) {
////        log.info("ActionLog.deleteUser start");
//        var user = userRepository.findUserEntityByIdAndStatus(id, Status.ENABLE);
//        if (user == null) {
////            log.error("ActionLog.deleteUser.error user not found with id: {}", id);
//            throw new NotFoundException("USER_NOT_FOUND");
//        }
//        favoriteRepository.deleteByUser_Id(id);
//        List<OrderEntity> orderEntities = orderRepository.getOrderEntitiesByUser_Id(id);
//        if (orderEntities != null) {
//            orderEntities.forEach(orderEntity -> orderEntity.setStatus(Status.DISABLE));
//            orderRepository.saveAll(orderEntities);
//        }
//        user.setStatus(Status.DISABLE);
//        userRepository.save(user);
////        log.info("ActionLog.deleteUser end");
//    }
//}
