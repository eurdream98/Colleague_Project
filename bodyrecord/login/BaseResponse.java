package com.example.structure.member.domain.login;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@ToString
public class BaseResponse<T> {
    private final T data;

    public BaseResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}