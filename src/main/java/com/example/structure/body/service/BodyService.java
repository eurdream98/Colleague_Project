package com.example.structure.body.service;

import com.example.structure.body.domain.Body;
import com.example.structure.body.domain.repository.BodyRepository;
import com.example.structure.body.dto.response.BodyResponse;
import com.example.structure.member.domain.Member;
import com.example.structure.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BodyService {
    private final Body body;
    private final BodyRepository bodyRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
   public List<BodyResponse> getAllBodys(final Integer memberCode){
        final List<Body> bodys = bodyRepository.findAllByMemberCodeMemberCode(memberCode);
        return bodys.stream()
                .map(body -> BodyResponse.from(body))
                .collect(Collectors.toList());
    }
}
