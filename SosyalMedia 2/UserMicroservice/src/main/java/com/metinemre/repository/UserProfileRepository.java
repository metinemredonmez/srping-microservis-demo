package com.metinemre.repository;

import com.metinemre.document.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {
}
