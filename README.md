# kaspiTestTask

В проекте две реализации:
- реализация с использованием MySQL в ветке master
- реализация с использованием In-memory базы данных H2 в ветке testH2Database
<hr>
Точка входа в приложение в классе java.com.hustleind.SpringBootWebApp
<hr>
После запуска необходимо войти в консоль базы данных H2: http://localhost:8080/console и указать параметры:<br>
<br>
Driver Class: org.h2.Driver<br>
JDBC URL: jdbc:h2:mem:kaspi-test<br>
User Name: sa<br>
поле Password оставить пустым.<br>
<br>
При вводе иных параметров в этих полях необходимо изменить аналогичные параметры в файле resources.config.application.yml
<hr>
Описание API: http://localhost:8080/swagger-ui.html#/

