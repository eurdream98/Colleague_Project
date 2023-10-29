package com.example.structure.member.domain.login;

import com.example.structure.member.domain.login.model.GetSocialOAuthRes;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/app/accounts")
public class AccountController {
    private final OAuthService oAuthService;
    public AccountController(OAuthService oAuthService){
        this.oAuthService = oAuthService;
    }

//    @NoAuth
    @GetMapping("/auth/{socialLoginType}")
    public void socialLoginRedirect(@PathVariable(name="socialLoginType")String SocialLoginPath) throws IOException{
        Constant.SocialLoginType socialLoginType = Constant.SocialLoginType.valueOf(SocialLoginPath.toUpperCase());
        oAuthService.request(socialLoginType);
    }

    @ResponseBody
    @GetMapping(value = "/auth/{socialLoginType}/callback")
    public BaseResponse<GetSocialOAuthRes> callback (
            @PathVariable(name = "socialLoginType") String socialLoginPath,
            @RequestParam(name = "code") String code)throws IOException,BaseException {
        System.out.println(">> 소셜 로그인 API 서버로부터 받은 code :" + code);
        Constant.SocialLoginType socialLoginType = Constant.SocialLoginType.valueOf(socialLoginPath.toUpperCase());
        GetSocialOAuthRes getSocialOAuthRes = oAuthService.oAuthLogin(socialLoginType, code);
        return new BaseResponse<>(getSocialOAuthRes);
    }
}
