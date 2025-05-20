# 1) Build 단계: Gradle로 JAR 생성
FROM gradle:8-jdk17 AS builder
WORKDIR /app

# Gradle Wrapper 스크립트 및 JAR 복사
COPY gradlew gradlew.bat ./
COPY gradle/wrapper/gradle-wrapper.properties gradle/wrapper/
COPY gradle/wrapper/gradle-wrapper.jar gradle/wrapper/

# 빌드 스크립트 복사
COPY build.gradle settings.gradle ./

# 의존성 설치 및 어셈블
RUN chmod +x gradlew && \
    ./gradlew clean assemble --no-daemon --stacktrace

# 프로젝트 전체 소스 복사
COPY . .

# 실행용 JAR 생성
RUN ./gradlew bootJar --no-daemon --stacktrace

# 2) Run 단계: 경량 JRE에 JAR 복사 및 실행
FROM eclipse-temurin:17-jre-jammy AS runtime
WORKDIR /app

# builder 스테이지에서 만든 실행용 JAR 가져오기
COPY --from=builder /app/build/libs/*.jar app.jar

# 애플리케이션 포트
EXPOSE 8282

# 컨테이너 시작 시 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]
