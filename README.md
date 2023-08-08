
# OmniVerse API 🌌

OmniVerse API is a straightforward API that provides access only to the basic CRUD concept routes, enabling efficient and consistent data manipulation.

Our API uses the ViaCEP API, a well-known API that returns the data of a specific address based on the provided postal code (CEP).
## Setup 🔧

OmniVerse API is an API built on top of the Java Spring Boot framework, designed to be easily installed and deployed. 

For an easy setup, you'll need a MySQL server, but the API itself is prepared to accept any DB you want. Follow [MySQL Documentation](https://dev.mysql.com/doc/mysql-getting-started/en) link in order to setup a working server.

1. First thing you'll need after your MySQL server is running is to setup the API to be able to connect to it. You'll need to modify [**application.properties**](https://github.com/lucasapchagas/Omniverse/blob/main/src/main/resources/application.properties) file to your own needs. 

    - `spring.datasource.url`, you must provide your MySQL server url.
    - `spring.datasource.username`, you must provide your MySQL server username.
    - `spring.datasource.password`, you must provide your MySQL server password.

    ❗**If you provide an url for a database which is not previously created the API will not start. Use `CREATE database <db_name>;` in order to properly create it.**    

2. Building it 🔨

    To build the project, you need to have Java 17 installed, but you can easily change the version by modifying the application's [**pom.xml**](https://github.com/lucasapchagas/Omniverse/blob/main/pom.xml) file. The project uses Maven as the build platform, which brings all the conveniences of Maven.

    - You can build it just by running `./mvnw pacakge` in the project root folder, the target file will be generated at `/target/` folder. 

3. Using it 😯

    Utilizing the API is as simple as modifying, understanding, and building it. Given that Java runs on the JVM, deploying the API becomes effortless—simply run the compiled JAR on any cloud service.

- You can just use a [PRE-RELEASE](https://github.com/lucasapchagas/Omniverse/releases/tag/SNAPSHOT) instead of compiling it. Please, always use the latest one.
- In order to run it you must use the following command `java -jar OmniVerse-0.0.1-SNAPSHOT.jar`. By default it will try to open the api to [`http://localhost:8080/`](http://localhost:8080/).

## Features 🪶

- Uses **viacep api** in order to register users address.
- Migrations with flyway library.
- Data validation with spring boot data validation.
- JPA design pattern.


## API Usage 🍪

The OmniVerse API is user-friendly and comprises only 5 possible routes that align with the CRUD standard.

You can use popular API testing tools like Insomnia. We have created a configuration that can be accessed on pastebin by [clicking here](https://pastebin.com/f1rBDfZP). Import it into your Insomnia to streamline your testing process.

### What is an user?
Example:
```json
{
    "id": 8,
    "name": "Lucas",
    "email": "lucas2@gmail.com",
    "address": {
        "cep": "69050500",
        "place": "Rua Peru",
        "complement": "",
        "neighborhood": "Parque 10 de Novembro",
        "locality": "Manaus",
        "uf": "AM"
    }
}
```

#### Register a user

```http
  POST /user
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | User name |
| `email` | `string` | Valid email |
| `cep` | `string` | Valid cep, just numbers. |

#### Returns an user

```http
  GET /user/{id}
```

#### Returns all users

```http
  GET /user
```

#### Delete a user

```http
  DELETE /user/{id}
```

#### Update a user

Just the field you want to modify is needed as a Parameter. User id is a **must have**.

```http
  PUT /user
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `int` | User id|
| `name` | `string` | User name |
| `email` | `string` | Valid email |
| `cep` | `string` | Valid cep, just numbers. |


## Roadmap

- [x]  Implement JPA pattern.
- [x]  Usage of **ViaCEP API** in order to generate user's adress.
- [x]  Implement Flyway migrations to our database.
- [x]  Implement Spring boot data validation.
- [ ]  Implement Spring boot security module.
- [ ]  Implement JSON Web Token usage.



