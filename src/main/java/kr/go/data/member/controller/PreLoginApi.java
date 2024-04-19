package kr.go.data.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.go.data.member.dto.LoginDto;
import kr.go.data.member.dto.SignUpDto;
import kr.go.data.util.annotation.NoAuth;
import kr.go.data.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Tag(name = "로그인 이전에 사용하는 API", description = "header에 token값 필요하지 않음")
public interface PreLoginApi {

    @NoAuth
    @Operation(summary = "[회원가입] 이메일 중복 확인")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용 가능한 이메일입니다.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 200,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"사용 가능한 이메일입니다.\"\n" +
                                                              "}"))),
            @ApiResponse(responseCode = "400", description = "이메일 형식을 맞춰주세요.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 400,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"이메일 형식을 맞춰주세요.\"\n" +
                                                              "}"))),
            @ApiResponse(responseCode = "409", description = "이미 사용중인 이메일입니다.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 409,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"이미 사용중인 이메일입니다.\"\n" +
                                                              "}")))
    })
    @GetMapping("exists/email")
    ResponseEntity<CustomApiResponse<?>> checkEmailExists(@RequestParam String email);

    @NoAuth
    @Operation(summary = "[회원가입] 전화번호 중복 확인")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용 가능한 전화번호입니다.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 200,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"사용 가능한 전화번호입니다.\"\n" +
                                                              "}"))),
            @ApiResponse(responseCode = "400", description = "전화번호 형식을 맞춰주세요.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 400,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"전화번호 형식을 맞춰주세요.\"\n" +
                                                              "}"))),
            @ApiResponse(responseCode = "409", description = "이미 사용중인 전화번호입니다.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 409,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"이미 사용중인 전화번호입니다.\"\n" +
                                                              "}")))
    })
    @GetMapping("exists/phone")
    ResponseEntity<CustomApiResponse<?>> checkPhoneExists(@RequestParam String phone);

    @NoAuth
    @Operation(summary = "[회원가입] 아이디 중복 확인")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용 가능한 아이디입니다.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 200,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"사용 가능한 아이디입니다.\"\n" +
                                                              "}"))),
            @ApiResponse(responseCode = "400", description = "아이디는 영문자와 숫자만 포함할 수 있습니다.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 400,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"아이디는 영문자와 숫자만 포함할 수 있습니다.\"\n" +
                                                              "}"))),
            @ApiResponse(responseCode = "409", description = "이미 사용중인 아이디입니다.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 409,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"이미 사용중인 아이디입니다.\"\n" +
                                                              "}")))
    })
    @GetMapping("exists/userId")
    ResponseEntity<CustomApiResponse<?>> checkUserIdExists(@RequestParam String userId);

    @NoAuth
    @Operation(summary = "[회원가입] 회원가입")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "회원가입에 성공하였습니다.",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\n" +
                                                              "    \"status\": 201,\n" +
                                                              "    \"data\": null,\n" +
                                                              "    \"message\": \"회원가입에 성공하였습니다.\"\n" +
                                                              "}"),
                            schema = @Schema(implementation = CustomApiResponse.class))),
            @ApiResponse(responseCode = "409", description = "이미 사용중인 정보입니다.",
                    content = @Content(mediaType = "application/json",
                            examples = {
                                    @ExampleObject(name = "이미 사용중인 이메일", value = "{\n" + "    \"status\": 409,\n" + "    \"data\": null,\n" + "    \"message\": \"이미 사용중인 이메일입니다.\"\n" + "}"),
                                    @ExampleObject(name = "이미 사용중인 아이디", value = "{\n" + "    \"status\": 409,\n" + "    \"data\": null,\n" + "    \"message\": \"이미 사용중인 아이디입니다.\"\n" + "}"),
                                    @ExampleObject(name = "이미 사용중인 전화번호", value = "{\n" + "    \"status\": 409,\n" + "    \"data\": null,\n" + "    \"message\": \"이미 사용중인 전화번호입니다.\"\n" + "}")
                            },
                            schema = @Schema(implementation = CustomApiResponse.class))),
            @ApiResponse(responseCode = "400", description = "입력 형식 오류",
                    content = @Content(mediaType = "application/json",
                            examples = {
                                    @ExampleObject(name = "아이디 형식 오류", value = "{\n" + "    \"status\": 400,\n" + "    \"data\": null,\n" + "    \"message\": \"아이디는 영문자와 숫자만 포함할 수 있습니다.\"\n" + "}"),
                                    @ExampleObject(name = "전화번호 형식 오류", value = "{\n" + "    \"status\": 400,\n" + "    \"data\": null,\n" + "    \"message\": \"전화번호 형식을 맞춰주세요.\"\n" + "}"),
                                    @ExampleObject(name = "이메일 형식 오류", value = "{\n" + "    \"status\": 400,\n" + "    \"data\": null,\n" + "    \"message\": \"이메일 형식을 맞춰주세요.\"\n" + "}")
                            },
                            schema = @Schema(implementation = CustomApiResponse.class)))
    })
    @PostMapping("sign-up")
    ResponseEntity<CustomApiResponse<?>> signUp(@RequestBody SignUpDto.Req dto);

    @NoAuth
    @Operation(summary = "[로그인] 로그인", description = "response header에 token 값 존재")
    @PostMapping("login")
    ResponseEntity<CustomApiResponse<?>> login(@RequestBody LoginDto.Req dto);
}
