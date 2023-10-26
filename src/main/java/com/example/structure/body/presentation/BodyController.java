package com.example.structure.body.presentation;

import com.example.structure.body.dto.response.BodyResponse;
import com.example.structure.body.service.BodyService;
import com.example.structure.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.structure.member.domain.MemberState.ACTIVE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/body/log")
public class BodyController {
    private final BodyService bodyService;
    /*로그인 한 유저의 체성분 모두 조회*/
    @GetMapping("/{memberCode}")
    public ResponseEntity<List<BodyResponse>> getBody(@PathVariable Integer memberCode){


        final List<BodyResponse> bodyResponses = bodyService.getAllBodys(memberCode);
        return ResponseEntity.ok(bodyResponses);
    }
}
//new Member(1,"고동환","김동환",'남',25,"010","eurd","빙색이",3,ACTIVE,localDateTime1,localDateTime2)