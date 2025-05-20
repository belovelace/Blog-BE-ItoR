# 1) Build 단계: Gradle로 JAR 생성
FROM gradle:8-jdk17 AS builder
WORKDIR /app

# --▶ wrapper 스크립트와 JAR을 명시적 복사
COPY gradlew gradlew.bat ./
COPY gradle/wrapper/gradle-wrapper.properties gradle/wrapper/
COPY gradle/wrapper/gradle-wrapper.jar         gradle/wrapper/

# --▶ build 스크립트 복사
COPY build.gradle settings.gradle ./

# 캐시 효율을 위한 의존성만 먼저 빌드
RUN chmod +x gradlew \
  && ./gradlew clean assemble --no-daemon --stacktrace

# --▶ 프로젝트 전체 소스 복사
COPY . .

# 복사 확인 (ls 출력으로 gradle-wrapper.jar 존재 확인)
RUN ls -al gradle/wrapper && \
    ./gradlew bootJar --no-daemon --stacktrace \

# 2) Run 단계: 경량 JRE에 JAR 복사 및 실행
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# builder에서 만든 실행용 JAR을 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 애플리케이션 포트
EXPOSE 8282

# 컨테이너 시작 시 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]
