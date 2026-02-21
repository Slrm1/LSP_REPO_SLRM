### Assignment 3 Reflection: Object-Oriented Redesign of ETL Pipeline

#### Comparison of Assignment 2 and Assignment 3 Designs

My Assignment 2 solution implemented the entire ETL pipeline inside a single `ETLPipeline` class under `org.howard.edu.lsp.assignment2`. That class directly handled reading from the input CSV file, parsing and validating each line, transforming the data, writing output, and printing summary statistics. All of the logic lived in one file, which made it straightforward but tightly coupled and harder to extend or test in isolation.

In Assignment 3, I redesigned the solution to use multiple collaborating classes under the package `org.howard.edu.lsp.assignment3`. Instead of a single monolithic class, I now have dedicated classes for configuration (`ETLConfiguration`), statistics tracking (`ETLStatistics`), domain objects (`ProductRecord` and `TransformedProductRecord`), parsing (`RowParser`), transformation (`ProductTransformer`), coordination of a single line (`RowProcessor`), orchestration of the entire pipeline (`CsvETLRunner`), and the entry point (`ETLApp`). Each class has a clearer and narrower responsibility, and together they implement the same behavior as Assignment 2.

#### How Assignment 3 Is More Object-Oriented

Assignment 3 is more object-oriented in several ways:

- **Separation of concerns**: The reading/writing of files, parsing of CSV lines, application of business rules, and tracking of statistics are handled by separate classes. This avoids mixing unrelated responsibilities in a single class.
- **Domain modeling**: The input row is modeled as a `ProductRecord` object and the transformed row is modeled as a `TransformedProductRecord`. This makes the code more expressive and easier to reason about than passing around raw arrays of `String`.
- **Encapsulation**: Implementation details are hidden behind clear public methods. For example, the discount rules and price range logic are encapsulated inside `ProductTransformer`, and the counter fields are private inside `ETLStatistics`.
- **Composability**: The `ETLApp` class wires up the pipeline by composing objects (`RowParser`, `ProductTransformer`, `RowProcessor`, `CsvETLRunner`) instead of doing all work itself. This makes it easier to change or replace components in the future.

#### Object-Oriented Concepts Used

- **Object and Class**: I introduced several new classes to represent distinct concepts in the pipeline:
  - `ETLConfiguration` represents configuration data such as file paths and headers.
  - `ETLStatistics` represents the mutable statistics for the ETL run.
  - `ProductRecord` and `TransformedProductRecord` represent the domain data before and after transformation.
  - `RowParser`, `ProductTransformer`, `RowProcessor`, and `CsvETLRunner` represent services that perform specific tasks.
- **Encapsulation**: Each class keeps its fields private and exposes only the methods needed by other classes. For example, callers cannot directly change the internal counters in `ETLStatistics`; they must use methods such as `incrementRowsRead()` and `incrementRowsTransformed()`. This hides the internal representation and protects invariants.
- **Composition**: The pipeline is built through composition. `ETLApp` creates the configuration, statistics, parser, transformer, and row processor, then passes them to `CsvETLRunner`. `RowProcessor` composes a `RowParser` and a `ProductTransformer`. This is a key OO idea: larger behavior emerges from composing smaller, focused objects.
- **(Optional) Polymorphism and Inheritance**: The current design does not rely heavily on inheritance hierarchies; instead, it favors composition. However, the design makes it easy to introduce polymorphism later. For example, I could define an interface such as `LineTransformer` and have `ProductTransformer` implement it, or create different `ETLRunner` implementations for other input formats. I chose not to introduce unnecessary inheritance here to keep the design simple and focused on the assignment requirements.

#### Preserving Behavior and Testing

The Assignment 3 implementation is intended to behave exactly the same as Assignment 2:

- It uses the same relative input and output paths: `data/products.csv` and `data/transformed_products.csv`.
- It writes the same CSV header line: `ProductID,Name,Price,Category,PriceRange`.
- It applies the same transformations:
  - Converts the product name to uppercase.
  - Applies a 10% discount for products in the `Electronics` category.
  - Rounds prices to two decimal places using round-half-up.
  - Changes the category to `Premium Electronics` when the discounted price is greater than 500.00 and the original category was `Electronics`.
  - Computes the same `PriceRange` values (`Low`, `Medium`, `High`, `Premium`) based on the final rounded price.
- It uses the same rules for skipping invalid rows and for counting rows read, transformed, and skipped.

To confirm that Assignment 3 behaves the same as Assignment 2, I used the following testing approach:

1. **Normal case with valid input**: I ran the original Assignment 2 program and saved the generated `data/transformed_products.csv`. Then I ran the Assignment 3 `ETLApp` and compared its output file to the Assignment 2 file to ensure they matched (same lines, same formatting). I also verified that the printed summary statistics (rows read/transformed/skipped) were the same.
2. **Missing input file**: I temporarily renamed or removed `data/products.csv` and ran the Assignment 3 program. It printed the same error message as Assignment 2: `Error: Input file 'data/products.csv' not found.` and did not create a new output file.
3. **Empty input file**: I tested with an input file that contains only the header or has no data rows. In this case, the program writes the header to `transformed_products.csv`, does not write any data rows, and prints a summary showing that zero rows were transformed.
4. **Invalid and blank lines**: I confirmed that blank lines, lines with the wrong number of fields, and lines with invalid product IDs or prices are all skipped consistently and counted in the `rowsSkipped` total.

By running these tests and comparing outputs and console messages, I verified that the new object-oriented design for Assignment 3 preserves the exact behavior of my Assignment 2 solution while improving structure and clarity.

#### Use of Generative AI and Adaptation

For this assignment, I used a generative AI assistant (Cursor / ChatGPT) to help me redesign my ETL pipeline to be more object-oriented. I provided my original Assignment 2 `ETLPipeline` code and the Assignment 3 instructions, and asked the assistant to propose an OO decomposition. The assistant suggested breaking the solution into multiple classes, including configuration, statistics, domain objects, parsing, transformation, and a runner class.

I adapted these suggestions in several ways:

- I kept the class names and package name consistent with the course guidelines (`org.howard.edu.lsp.assignment3` and one public class per file).
- I carefully checked that the logic in `ProductTransformer` matched my original `transformRow` and `determinePriceRange` methods from Assignment 2, including the exact rounding behavior and threshold values.
- I ensured that the new code used the same error messages, header line, and relative file paths so that graders can run either version and see identical behavior.
- I reviewed and edited the AI-generated Javadocs and comments for accuracy and clarity, and removed any text that did not match what my code actually does.

Overall, the AI assistant helped me think about how to decompose the pipeline into objects and how to name and connect the classes. I still made design decisions myself, wrote and organized the source files, and verified that the updated implementation behaves exactly like my original Assignment 2 solution.

