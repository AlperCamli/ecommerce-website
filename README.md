# Nature E-commerce Backend

This Spring Boot project provides a basic e-commerce API with JWT-based authentication.

## Building

```bash
./gradlew build
```

## Running

Set the following environment variables before running the application:

- `DB_URL` – JDBC connection string to PostgreSQL
- `DB_USERNAME` – database username
- `DB_PASSWORD` – database password
- `JWT_SECRET` – secret key used for signing JWT tokens

Then start the app:

```bash
./gradlew bootRun
```

## Testing

Run unit tests with:

```bash
./gradlew test
```

