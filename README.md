# Build
mvn clean package && docker build -t org.example/TaskRest .

# RUN

docker rm -f TaskRest || true && docker run -d -p 8080:8080 -p 4848:4848 --name TaskRest org.example/TaskRest 