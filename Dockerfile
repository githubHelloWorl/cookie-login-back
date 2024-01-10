# Docker 镜像构建
FROM maven:3.6-openjdk-17-slim as builder

# 设置阿里云 Maven 镜像
COPY settings.xml /usr/share/maven/ref/

# 设置工作目录并复制代码到容器中
WORKDIR /
COPY pom.xml .
COPY src ./src

# 构建发布版本
RUN mvn package -DskipTests

# 在容器启动时运行 Web 服务
CMD ["java", "-jar", "target/sportsReserveSys-0.0.1-SNAPSHOT.jar"]
