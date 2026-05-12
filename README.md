# PracticalWork4Spring

## Что сделано для оценки "5"
- Добавлена валидация полей моделей через аннотации (`@NotBlank`, `@Size`, `@Email`, `@Positive`).
- В контроллерах добавлена обработка `BindingResult`, чтобы приложение не падало при некорректном вводе.
- В шаблонах добавлен вывод ошибок валидации рядом с полями.
- Для `menuItems` добавлена страница формы `menuItemForm.html`.

## Как подключить PostgreSQL
1. Установите PostgreSQL и создайте БД:
   ```sql
   CREATE DATABASE pgs;
   ```
2. Проверьте логин/пароль пользователя БД (пример: `postgres` / `123123`).
3. Откройте файл:
   `demo/src/main/resources/application.properties`
4. Укажите свои параметры:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/pgs
   spring.datasource.username=postgres
   spring.datasource.password=123123
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
5. Запустите приложение:
   ```bash
   cd demo
   mvn spring-boot:run
   ```

## Если видите ошибку Hibernate про JdbcEnvironment/Dialect
Обычно это значит, что нет подключения к БД. Проверьте:
- PostgreSQL действительно запущен;
- URL, логин, пароль в `application.properties`;
- драйвер PostgreSQL есть в зависимостях Maven.
