# Blog-BE-ItoR

# Blog 만들기

## 미션 요구사항

1. 미션 진행 방법을 꼭 읽고 진행해주세요
   [미션 진행 방법](https://www.notion.so/46dbd9440a4f4d5e97228011dff70f5a?pvs=21)
2. 해당 ReadMe 를 지우고 erd 및 디렉토리 구조를 작성해주세요
    1. erd를 그리는 방법은 자유입니다
    2. 디렉토리 구조도 자유롭게 설정하셔도 좋습니다
3. 아래 API 요구사항은 API URI를 포함하고 있습니다. 반드시 URI를 지켜서 구현해주세요

`ex) GET posts/all`
![블로그 1주차 erd](https://github.com/user-attachments/assets/db86eb59-bba7-45f0-a559-a92fd5cfc210)
![image](https://github.com/user-attachments/assets/834a9589-d526-47f4-aeab-f27f82226723)

```
/blog-backend
 ├── src
 │   ├── main
 │   │   ├── java/com/blog/app
 │   │   │   ├── config/             # 설정 파일 (보안, CORS 등)
 │   │   │   ├── auth/               # 인증 관련 (로그인, 회원가입)
 │   │   │   │   ├── controller/     # Auth 컨트롤러
 │   │   │   │   ├── dao/            # Auth DAO
 │   │   │   │   ├── mapper/         # Auth Mapper
 │   │   │   │   ├── service/        # Auth 서비스
 │   │   │   │   ├── vo/             # Auth VO (Value Object)
 │   │   │   ├── member/             # 회원 관련
 │   │   │   │   ├── controller/     # Member 컨트롤러
 │   │   │   │   ├── dao/            # Member DAO
 │   │   │   │   ├── mapper/         # Member Mapper
 │   │   │   │   ├── service/        # Member 서비스
 │   │   │   │   ├── vo/             # Member VO
 │   │   │   ├── post/               # 게시물 관련
 │   │   │   │   ├── controller/     # Post 컨트롤러
 │   │   │   │   ├── dao/            # Post DAO
 │   │   │   │   ├── mapper/         # Post Mapper
 │   │   │   │   ├── service/        # Post 서비스
 │   │   │   │   ├── vo/             # Post VO
 │   │   │   ├── comment/            # 댓글 관련
 │   │   │   │   ├── controller/     # Comment 컨트롤러
 │   │   │   │   ├── dao/            # Comment DAO
 │   │   │   │   ├── mapper/         # Comment Mapper
 │   │   │   │   ├── service/        # Comment 서비스
 │   │   │   │   ├── vo/             # Comment VO
 │   │   │   ├── image/              # 이미지 업로드 관련
 │   │   │   │   ├── controller/     # Image 컨트롤러
 │   │   │   │   ├── service/        # Image 서비스
 │   │   │   ├── BlogApplication.java # 메인 애플리케이션
 │   │   ├── resources
 │   │   │   ├── application.yml     # 환경설정 파일
 │   ├── test                        # 테스트 코드
 ├── pom.xml                         # Maven 설정 파일
 └── README.md                        # 프로젝트 설명
```

