# Blog-BE-ItoR : Blog 만들기 프로젝트

본 프로젝트는 가천대학교 교내 IT학술동아리 ${'Leets'}$에서 수행한 토이 프로젝트 입니다. <br>
${'신은지/main'}$ 브랜치에서만 제가 작성한 코드를 보실 수 있습니다.

## 6가지 제한
1. spring security 사용 금지
2. jpa 사용 금지
3. lombok 사용금지
4. indent 최대 2칸 허용
5. rds 사용 금지
6. 20줄이 넘는 함수 작성 금지


## ERD

![블로그 1주차 erd](https://github.com/user-attachments/assets/db86eb59-bba7-45f0-a559-a92fd5cfc210)

## 요구사항 정의서

![image](https://github.com/user-attachments/assets/834a9589-d526-47f4-aeab-f27f82226723)

## 디렉토리
```
Blog-BE-ItoR/
├── .gitattributes
├── .gitignore
├── build.gradle
├── main.iml
├── uploads/
├── src/
│  ├── main/
│  │  ├── java/
│  │  │  └── com/
│  │  │     └── blog/
│  │  │        ├── BlogApplication.java
│  │  │        ├── config/
│  │  │        │  └── WebMvcConfig.java
│  │  │        ├── comment/
│  │  │        │  ├── controller/
│  │  │        │  │  └── CommentController.java
│  │  │        │  ├── dao/
│  │  │        │  │  └── CommentDao.java
│  │  │        │  ├── exception/
│  │  │        │  │  └── CommentException.java
│  │  │        │  ├── mapper/
│  │  │        │  │  └── CommentMapper.java
│  │  │        │  ├── record/
│  │  │        │  │  ├── CommentCreateRecord.java
│  │  │        │  │  └── CommentRecord.java
│  │  │        │  └── service/
│  │  │        │     ├── CommentService.java
│  │  │        │     └── CommentServiceImpl.java
│  │  │        ├── member/
│  │  │        │  ├── controller/
│  │  │        │  │  └── MemberController.java
│  │  │        │  ├── mapper/
│  │  │        │  │  └── MemberMapper.java
│  │  │        │  ├── service/
│  │  │        │  │  └── MemberService.java
│  │  │        │  └── vo/
│  │  │        │     └── MemberVo.java
│  │  │        ├── kakaologin/
│  │  │        │  ├── config/
│  │  │        │  │  └── WebConfig.java
│  │  │        │  ├── controller/
│  │  │        │  │  └── KakaoLoginController.java
│  │  │        │  ├── service/
│  │  │        │  │  └── KakaoLoginService.java
│  │  │        │  └── util/
│  │  │        │     └── KakaoLoginUtil.java
│  │  │        ├── mypage/
│  │  │        │  ├── controller/
│  │  │        │  │  └── MyPageController.java
│  │  │        │  ├── mapper/
│  │  │        │  │  └── MyPageMapper.java
│  │  │        │  ├── record/
│  │  │        │  │  ├── MyInfoRecord.java
│  │  │        │  │  ├── MyInfoUpdateRecord.java
│  │  │        │  │  ├── PasswordChangeRecord.java
│  │  │        │  │  └── ProfileImgUploadRecord.java
│  │  │        │  └── service/
│  │  │        │     └── MyPageService.java
│  │  │        └── post/
│  │  │           ├── controller/
│  │  │           │  └── PostController.java
│  │  │           ├── dao/
│  │  │           │  └── PostDao.java
│  │  │           ├── exception/
│  │  │           │  └── PostException.java
│  │  │           ├── mapper/
│  │  │           │  └── PostMapper.java
│  │  │           ├── record/
│  │  │           │  └── PostRecord.java
│  │  │           └── service/
│  │  │              ├── PostService.java
│  │  │              └── PostServiceImpl.java
│  │  ├── resources/
│  │  │  ├── application.properties
│  │  │  ├── mapper/
│  │  │  │  ├── CommentMapper.xml
│  │  │  │  ├── MemberMapper.xml
│  │  │  │  ├── MyPageMapper.xml
│  │  │  │  ├── OauthMapper.xml
│  │  │  │  └── PostMapper.xml
│  │  │  └── static/
│  │  │     └── (css, js, images…)
│  │  └── webapp/
│  │     └── WEB-INF/
│  │        └── views/
│  │           ├── kakaologin.jsp
│  │           └── (기타 .jsp 파일)
│  └── test/
│     └── java/
│        └── com/
│           └── blog/
│              └── (단위 테스트)

```
