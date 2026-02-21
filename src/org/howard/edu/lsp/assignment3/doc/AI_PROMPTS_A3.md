### Assignment 3 – AI Prompts and Responses (Excerpts)

This file summarizes several of the prompts I used with a generative AI assistant (Cursor / ChatGPT) while working on Assignment 3, along with brief excerpts of the responses. The full conversation history is available in the Cursor project.

---

#### Prompt 1: Initial Design Brainstorming

**My prompt (excerpt):**

> I have an Assignment 2 ETL pipeline implemented in a single Java class. For Assignment 3, I need to redesign it to be more object-oriented while keeping the same behavior. Here is the code for my current `ETLPipeline` class. Please propose an OO design and class breakdown that preserves the same input, output, and error handling.

**AI assistant response (excerpt):**

> The current `ETLPipeline` class combines file I/O, parsing, transformation, and statistics in one place. For Assignment 3, you can break this into several classes:
> - `ETLApp` as the main entry point.
> - `ETLConfiguration` for file paths and header.
> - `ETLStatistics` for tracking rows read/transformed/skipped.
> - `ProductRecord` and `TransformedProductRecord` as domain objects.
> - `RowParser` to parse CSV lines into `ProductRecord`.
> - `ProductTransformer` to apply the discount, category, and price range rules.
> - `RowProcessor` to coordinate one line at a time.
> - `CsvETLRunner` to orchestrate reading, writing, and summary printing.

I used this as the starting point for my class structure and then adapted details to fit the course requirements.

---

#### Prompt 2: Verifying Transformation Logic

**My prompt (excerpt):**

> Please help me move the `transformRow` and `determinePriceRange` methods into a new `ProductTransformer` class that works with `ProductRecord` and `TransformedProductRecord` objects. The behavior must match exactly: same discount for Electronics, same rounding, same Premium Electronics rule, and same price range thresholds.

**AI assistant response (excerpt):**

> You can create `ProductTransformer` with a `transform(ProductRecord record)` method and a private `determinePriceRange(BigDecimal price)` helper. Inside `transform`, convert the name to uppercase, apply a 10% discount for Electronics, round to 2 decimal places with `RoundingMode.HALF_UP`, and then change the category to `Premium Electronics` when the final price is greater than 500.00 and the original category was `Electronics`. Finally, compute the `priceRange` based on thresholds at 10.00, 100.00, and 500.00.

I compared this suggested logic to my Assignment 2 code and ensured that the BigDecimal operations, rounding, and comparisons were the same.

---

#### Prompt 3: Ensuring Same Error Handling and Statistics

**My prompt (excerpt):**

> In Assignment 2, I increment `rowsRead` for each non-header line, skip blank lines, and skip invalid lines (wrong field count, invalid product ID, invalid price). I also print a summary at the end. How can I keep this behavior the same when splitting the code across multiple classes?

**AI assistant response (excerpt):**

> Keep the counting responsibilities in an `ETLStatistics` class. In your main loop, increment `rowsRead` for each non-header line. Have a `RowProcessor` that receives the raw line and the statistics object. If the line is blank, it should increment `rowsSkipped` and return `null`. If parsing fails, it should also increment `rowsSkipped`. When transformation succeeds, increment `rowsTransformed` and return the transformed CSV line. After processing all lines, call `statistics.printSummary(outputFile)` with the same message format as Assignment 2.

I followed this guidance but checked that the printout format and skip conditions matched my original implementation.

---

#### Prompt 4: Reflection and Documentation Help

**My prompt (excerpt):**

> I need to write a 1–2 page reflection comparing Assignment 2 and Assignment 3, explaining how the new solution is more object-oriented and how I used AI. Please help me draft a reflection that I can edit and make my own.

**AI assistant response (excerpt):**

> The reflection should describe how the Assignment 2 design was a single class that mixed multiple responsibilities, while Assignment 3 uses multiple classes with clearer responsibilities and domain objects. Discuss how you used objects, classes, encapsulation, and composition (and optionally polymorphism) in the new design. Also explain how you verified that both versions produce the same output, and how you used the AI assistant as a brainstorming and drafting tool but reviewed and adapted the suggestions yourself.

I used this response as a starting point and then customized the reflection text to accurately describe my own design choices and testing process.

---

You can refer back to the full AI transcript in Cursor if you need the complete prompt and response history for this assignment.

