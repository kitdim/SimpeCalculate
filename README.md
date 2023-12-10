# SimpleConsoleCalculator
[![Maintainability](https://api.codeclimate.com/v1/badges/2d7415a0eb3673f6d2bd/maintainability)](https://codeclimate.com/github/kitdim/SimpeCalculate/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/2d7415a0eb3673f6d2bd/test_coverage)](https://codeclimate.com/github/kitdim/SimpeCalculate/test_coverage)
[![Java CI](https://github.com/kitdim/SimpeCalculate/actions/workflows/java-ci.yml/badge.svg?branch=main)](https://github.com/kitdim/SimpeCalculate/actions/workflows/java-ci.yml)

### Тестовое задание на позицию Java/Kotlin разработчика в компанию Byndyusoft

В качестве тестового задания предлагаем написать на Java или Kotlin консольный калькулятор (можно с веб-интерфейсом), который принимает входную строку, содержащую математическое выражение (целые и десятично-дробные числа, знаки +, -, *, / и скобки) и выводит в консоль результат его вычисления. Задание предполагает самостоятельную реализацию парсинга и расчета математического выражения.

Главным критерием при оценке задания является использование при разработке TDD и принципов SOLID. Архитектура решения должна обеспечивать расширение списка поддерживаемых операций при минимальном и максимально безболезненном для существующей функциональности внесении изменений в исходный код. Код должен быть легко читаем и отформатирован в едином стиле, содержать минимальное число поясняющих комментариев.

### Пример консольного ввода:

Введите выражение: 1+2-3

Результат: 0

Примеры с унарным минусом (добавлено для дополнительного пояснения):

-3+2

2*(3)

2-(3)

Результатом будет публично доступный репозиторий на GitHub с исходным кодом тестового задания.
