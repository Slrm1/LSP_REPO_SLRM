# Question 2 - Part 1: Design Evaluation

The `OrderProcessor` class has multiple design problems that hurt maintainability and extensibility.

1. **Low cohesion / too many responsibilities**  
   A single class performs order calculation, receipt printing, file persistence, email confirmation, discount policy, and logging. This violates a core object-oriented idea that a class should have one focused responsibility.

2. **Poor encapsulation**  
   Order data fields (`customerName`, `email`, `item`, `price`) are `public`. Any external class can modify them directly, which makes object state hard to control and validate.

3. **Tight coupling to infrastructure**  
   The class directly uses `FileWriter`, console output, and current time (`new Date()`). Because business logic is mixed with I/O and system concerns, changing storage, output format, or logging requires editing this class.

4. **Hard-coded business rules**  
   Tax rate (`0.07`) and discount rule (`price > 500`, `*0.9`) are embedded in method logic. Any policy change requires code edits in the same method, increasing regression risk.

5. **Order-of-operations bug risk**  
   It prints and writes totals before applying discount. This creates inconsistent behavior and demonstrates how mixing concerns makes logic errors easier to introduce.

6. **Weak error handling**  
   A broad `catch(Exception e)` with `printStackTrace()` is not robust. It does not separate recoverable domain errors from I/O errors, and it leaks technical details.

7. **Difficult to test**  
   `processOrder()` has side effects (file write, console print, time usage) and no clear output object. Unit testing requires environment setup and output capture.

From an OO design perspective (including ideas aligned with Riel-style heuristics), this class behaves like a procedural script wrapped in an object rather than a set of collaborating domain-focused classes.

