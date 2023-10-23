package com.example.structure.body.presentation;

import com.example.structure.body.dto.response.BodyResponse;
import com.example.structure.body.service.BodyService;
import com.example.structure.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/body/log")
public class BodyController {
    private final BodyService bodyService;
    /*로그인 한 유저의 체성분 모두 조회*/
    @GetMapping
    public ResponseEntity<List<BodyResponse>> getBody(

    ){

        final List<BodyResponse> bodyResponses = bodyService.getAllBodys(1);
        return ResponseEntity.ok(bodyResponses);
    }
}
