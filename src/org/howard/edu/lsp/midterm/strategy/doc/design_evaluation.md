# Question 3 - Part 1: Design Evaluation

The original `PriceCalculator` uses a chain of hard-coded `if` statements tied to string values. This causes maintenance issues because each new customer type requires modifying existing code, which violates the open/closed principle and increases regression risk.  

The class also mixes policy selection and calculation logic in one method, reducing cohesion. As discount rules grow, the method becomes harder to test and reason about, and business rules remain tightly coupled to a single implementation.

