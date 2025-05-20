# 1) Build 단계: Gradle로 JAR 생성
FROM gradle:8-jdk17 AS builder
WORKDIR /app

# 의존성 캐시 최적화
COPY build.gradle settings.gradle gradlew gradle/ ./
RUN chmod +x gradlew \
  && ./gradlew clean --no-daemon assemble --skip-tests

# 소스 전체 복사 후 bootJar 실행
COPY . .
RUN ./gradlew bootJar --no-daemon

# 2) Run 단계: 경량 JRE에 JAR 복사 및 실행
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# builder에서 만든 실행용 JAR을 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 애플리케이션 포트
EXPOSE 8282

# 컨테이너 시작 시 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]
