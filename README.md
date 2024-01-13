# Struts2 Todo Application
This is a simple todo application.  
This app is implemented by Struts2(Web Application Framework) and Tomcat(Servlet Container) and MySQL(Database Server), Maven(Build Tool). We use Docker to construct Tomcat and MySQL.

## Getting Started

### Prerequisites
Download and install [Maven](https://maven.apache.org/index.html) and Docker.

### Getting this app
Using the command below clones this repository.
```cli
gh repo clone NK-shinonomesora/struts-application
```

### Building this app
Running the command below in order.
```cli
 cd <sample_dir>/maven/my-webapp
 mvn package
```
If the build is successful, target/my-webapp.war is created.

### Deploying this app to Tomcat
Running the command below.
```cli
cp target/my-webapp.war ../../tomcat/webapps/
```

### Running this app
Running the command below in order.
```cli
cd ../../tomcat
docker-compose up -d
```
Then Tomcat and MySQL invoke.
Open browser and access to localhost:8888/my-webapp/index.action.