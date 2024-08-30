package com.example.likecomment.Client;

import com.example.likecomment.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "userClient", url = "https://api.icebuckwheat.kro.kr")
public interface UserClient {

    @GetMapping("/api/login/getalluser")
    List<UserDto> getAllUsers();
}
