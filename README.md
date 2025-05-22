# ConfigLib

**ConfigLib** — це Java-бібліотека для валідації конфігураційних JSON-файлів згідно зі схемою. Вона дозволяє перевірити, чи відповідає наданий конфігураційний файл `config.json` правилам, визначеним у `schema.json`.

## Опис

Бібліотека включає такі компоненти:

- `SchemaParser` — парсить JSON-схему у внутрішнє представлення.
- `ConfigParser` — парсить конфігураційний JSON.
- `ConfigValidator` — перевіряє відповідність конфігурації схемі.
- `ConfigLib` — головний клас з методом `main`, який поєднує всі частини.

## Дизайн-документ

Докладніше читайте у [Design Document](https://docs.google.com/document/d/1FszHYRTbPc9nYaFggIKzqvvThzB0MW7Dc4najh3bPNk/edit?hl=RU&tab=t.0).

## Збірка проєкту

Збірка виконується за допомогою Maven. Переконайтеся, що у вас встановлено JDK 22 (або відредагуйте `pom.xml` для використання іншої версії).

Команда для збірки:

    mvn clean install

## Запуск

Для запуску програми потрібні два файли:

- `schema.json` — опис очікуваної структури
- `config.json` — конфігураційний файл, що перевіряється

Команда для запуску:

    java -cp target/ConfigLib-1.0-SNAPSHOT.jar org.example.ConfigLib

## Запуск тестів

    mvn test

## Покриття тестами (Code Coverage)

Для генерації звіту з покриття тестами за допомогою JaCoCo виконайте:

    mvn jacoco:prepare-agent test jacoco:report

Звіт буде доступний за адресою:

    target/site/jacoco/index.html
