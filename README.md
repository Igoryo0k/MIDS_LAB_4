# ConfigLib

ConfigLib — це Java-бібліотека для валідації конфігураційних JSON-файлів згідно зі схемою. Вона дозволяє перевірити, чи відповідає наданий `config.json` правилам, заданим у `schema.json`.

## Опис

Бібліотека складається з таких компонентів:

- `SchemaParser` — парсить JSON-схему у внутрішнє представлення.
- `ConfigParser` — парсить JSON-конфіг.
- `ConfigValidator` — перевіряє відповідність конфігу схемі.
- `ConfigLib` — точка входу (main), що поєднує всі частини.

## Дизайн-документ

Докладніше читайте у Design Document:  

()

## Збірка проєкту

Збірка виконується через Maven. Переконайтесь, що встановлено JDK 22 (або змініть pom.xml на іншу версію).

Команда для збірки:

    mvn clean install

## Запуск

Для запуску програми потрібно мати два файли:

- `schema.json` — опис очікуваної структури
- `config.json` — конфігураційний файл, що перевіряється

Команда для запуску:

    java -cp target/ConfigLib-1.0-SNAPSHOT.jar org.example.ConfigLib

## Запуск тестів

    mvn test

## Покриття тестами (Code Coverage)

Генерація звіту за допомогою JaCoCo:

    mvn jacoco:prepare-agent test jacoco:report

Звіт буде доступний тут:

    target/site/jacoco/index.html
