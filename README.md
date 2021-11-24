# KYC demo application

This is a demo application for a KYC use case. 

[Link to live demo](https://kyc-demo-af.azurewebsites.net/)

## Installation

This project requires git, NPM, java and maven to run locally

```shell
git clone https://github.com/aForsund/kyc-demo.git

cd kyc-demo/src/kyc-client 

npm install

cd ../..

mvnw package && java -jar target/kyc-demo-0.0.1-SNAPSHOT.jar
```

## About

Dette prosjektet er laget med Vue.js front end og Spring Boot back end. Man kan søke på person eller selskap. Spring Boot kjører klienten og handterer spørringer mot brreg og stacc sin API for kodetesten for henholdsvis selskap og personer.


### Søk på person

JSON objektet gjøres om til Person POJO før det returneres til klienten. Hensikten med dette er at man kan bruke denne metoden til å sammenligne roller i selskap (fra selskaps spørringen) med personer på PEP listen.

### Søk på selskap

JSON objektet returnerer selskapsroller, og dette gjøres igjen om til Person POJO. For hver selskapsrolle/person gjøres et nytt API-kall mot person, og hver person blir videre markert som PEP dersom man får et treff på navn og fødselsdato. 

