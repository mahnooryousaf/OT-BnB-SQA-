# bnb-rental
BNB RENTAL

# Tests

There are 3 tests so far:

- The phase 3 test

- The phase 4 JUnit test

- The phase 5 Integration test

## How to run the Phase 3 Test

<strong>Make sure you are in the base folder (outermost) of the project</strong>

To run all the tests, run the following command:
```
bash test.sh
```

To run a specific test, run the following command (substitute testName with the name of the test you want to run):
```
bash test.sh testName
```

## How to run the Phase 4 JUnit Test

<strong>Make sure you are in the Phase2 folder</strong>

1) compile:

```
javac -cp "junit-platform-console-standalone-1.8.2.jar" *.java
```

2) run:

To run LoginTest for statement coverage
```
java -jar "junit-platform-console-standalone-1.8.2.jar" -cp "." --select-class=LoginTest
```

To run TransactionTest for decision and loop coverage
```
java -jar "junit-platform-console-standalone-1.8.2.jar" -cp "." --select-class=TransactionTest
```

## How to run the Phase 5 Integration test:

<strong>Once again, make sure you are in the base folder (outermost) of the project</strong>

To run daily script:
```
bash daily.sh
```

To run weekly script:
```
bash weekly.sh
```