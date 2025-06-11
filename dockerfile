# FROM eclipse-temurin:17-jre
FROM docker.io/eclipse-temurin:17-jre

WORKDIR /app

COPY flight_Function_api/target/*.jar flight-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "flight-api.jar"]

# ./mvnw clean package
# docker build -t flight-api .
#  podman build -f Dockerfile




# podman machine ssh
# cd /etc/containers/registries.conf.d/
# ls  # 查看是否存在 999-podman-machine.conf
# sudo vi /etc/containers/registries.conf.d/999-podman-machine.conf
# :wq

# exit




# unqualified-search-registries = ["registry.docker-cn.com", "docker.io"]

# [[registry]]
# prefix = "docker.io"
# location = "registry.docker-cn.com"

# [[registry]]
# prefix = "quay.io"
# location = "quay.mirrors.ustc.edu.cn"

# [[registry]]
# prefix = "*"
# location = "registry.docker-cn.com"





# [registries.search]
# registries = ['docker.io', 'docker.m.daocloud.io', 'hub-mirror.c.163.com', 'registry.docker-cn.com']

# [[registry]]
# prefix = "docker.io"
# location = "docker.m.daocloud.io"



# 6. 推荐国内镜像源（V2 格式）
# Docker 中国官方：registry.docker-cn.com
# 阿里云：registry.cn-hangzhou.aliyuncs.com（需注册账号）
# 网易云：hub-mirror.c.163.com
# USTC 镜像：docker.mirrors.ustc.edu.cn