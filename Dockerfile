FROM airhacks/glassfish
COPY ./target/TaskRest.war ${DEPLOYMENT_DIR}
