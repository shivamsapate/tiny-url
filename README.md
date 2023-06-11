
# TinyURL

### What is tinyURL?
TinyURL is a URL shortening web service, which provides short aliases for redirection of long URLs.


### Technology stack
- Java-11
- maven plugin
- SpringBoot
- H2 database


### Installation

TinyUrl required [Java11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html) to run.

Install the dependencies and devDependencies and start the server.

```sh
cd tiny-url
mvn clean install
```

### Apis

#### Redirection api
GET http://localhost:8080/{alias}

#### Creation of Redirect with alias
POST http://localhost:8080/
#### Request:

```
{
    "alias":"data",
    "url":"http://www.facebook.com"
}
```


