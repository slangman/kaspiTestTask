# kaspiTestTask

В проекте две реализации:
- реализация с использованием MySQL в ветке master
- реализация с использованием In-memory базы данных H2 в ветке testH2Database

Точка входа в приложение в классе java.com.hustleind.SpringBootWebApp

После запуска необходимо войти в консоль базы данных H2: http://localhost:8080/console и указать параметры:
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:kaspi-test
User Name: sa
поле Password оставить пустым.

При вводе иных параметров в этих полях необходимо изменить аналогичные параметры в файле resources.config.application.yml

Описание API: http://localhost:8080/swagger-ui.html#/

