# MultiCalculator
- This library is designed for educational purposes.
- It includes four main functional areas: engineering polskayaCalculator, loan polskayaCalculator, deposit polskayaCalculator and chart polskayaCalculator.

 - ### [How to start](#How-to-start)
 - ### [Engineer](#Engineer-Calculator)
 - ### [Chart](#Chart)
 - ### [Credit](#Credit)
 - ### [Deposit](#Deposit)
 - ### [See JavaDoc](docs/index.html)
 - ### [Example](#Example)

## How to start
 - You can add it to your project as a maven-dependency.
   ``` <repositories>
          <repository>
              <id>MultiCalculator-mvn-repo</id>
              <url>https://raw.github.com/belkamydog/MultiCalculator/mvn-repo/</url>
              <snapshots>
                  <enabled>true</enabled>
                  <updatePolicy>always</updatePolicy>
              </snapshots>
          </repository>
    </repositories>
    <dependescies>
        <dependency>
            <groupId>com.devcolibri</groupId>
            <artifactId>com.devcolibri.newlib</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies> ```
## Engineer Calculator
   - Includes four classes, you can work with them both separately and through the main class [_**EngineerCalculator**_](docs/Engineer/EngineerCalculator.html).
   - You can use a separate class [**_Polskaya_**](docs/Engineer/Polskaya/Polskaya.html) to translate an expression into reverse Polish notation.
   - Or use the [_**PolskayaCalculator**_](docs/Engineer/PolskayaCalculator/PolskayaCalculator.html) class to evaluate the reverse polish notation expression.
   - There is also a class [_**ValidationAndPreparing**_](docs/Engineer/ValidationAndPreparing/ValidationAndPreparing.html) that validates an infix notation expression.
   - [_**EngineerCalculator**_](docs/Engineer/EngineerCalculator.html) the class includes all other classes in the package and performs a full evaluation of the expression if it has passed [_**ValidationAndPreparing**_](docs/Engineer/ValidationAndPreparing/ValidationAndPreparing.html).
## Chart
   - Takes an infix expression and the domain of the function definition and calculate an array of coordinates to plot the graph. In the function, use the variable x.
   - [see javadoc](docs/Chart/Chart.html)
## Credit
   - It is used to calculate a loan with different types of payments, including a detailed monthly report.
   - [see javadoc](docs/Credit/Credit.html)
## Deposit
   - It is used to calculate income on deposits with and without different types of capitalization, and includes a detailed report.
   - [see javadoc](docs/Deposit/DepositCalculator.html)
## Example
   #### Engineer example
   ```
        EngineerCalculator engineerCalculator = new EngineerCalculator("1+1", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        System.out.println(calculate.getResult()); // == 2.0
        // or
        System.out.println(calculate.getResultString()); //  == "2"
   ```
#### Polskaya example
   ```
       Polskaya polskaya = new Polskaya("2+2");
       polskaya.calculatePolska();
       System.out.println(polskaya.getResultString()); // "2 2 +"
   ```
#### Validation example
   ```
      ValidationAndPreparing validationExpression = new ValidationAndPreparing("2(1+1)SiN(30)");
      System.out.println(validation.isValid()); // "true"
      System.out.println(validation.getInfixExpression()); // "2*(1+1)*s(30)"
   ```
#### Credit example
   ```
        Credit credit = new Credit(Credit.creditPaymentType.annuity, 10000.0, 21.0, 1,
               Credit.creditTermType.year, LocalDate.of(2024, 1, 1));
        credit.calculate();
        // ...get results
   ```
#### Deposit example
   ```
        DepositCalculator DepositCalculator = new DepositCalculator(1, 1, "day", 12, 0, true, LocalDate.of(2024, 1, 1), "day");
        DepositCalculator.calculate();
        // ...get results
   ```