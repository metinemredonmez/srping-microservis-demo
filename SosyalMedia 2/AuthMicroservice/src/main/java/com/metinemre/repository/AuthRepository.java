package com.metinemre.repository;

import com.metinemre.entity.Auth;

public interface AuthRepository extends MyGenericRepo<Auth,Long> {
    Boolean existsByUserNameAndPassword(String userName, String password);
}
