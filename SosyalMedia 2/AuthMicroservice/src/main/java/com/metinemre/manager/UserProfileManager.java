package com.metinemre.manager;

import com.metinemre.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.metinemre.config.RestApis.CREATE_USER;

@FeignClient(url = "http://service-loadbalancer-user:9091/dev/v1/user-profile", name = "userProfileManager")
public interface UserProfileManager {

    @PostMapping(CREATE_USER)
    ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto);
}
