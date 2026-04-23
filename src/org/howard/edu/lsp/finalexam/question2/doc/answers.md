# Final Exam — Question 2

## Design Explanation (Template Method)

The Template Method pattern lives in `Report.generateReport()`, which is `final` so the workflow cannot be overridden. It always calls `loadData()`, then `formatHeader()`, `formatBody()`, and `formatFooter()` in that fixed order. `StudentReport` and `CourseReport` supply the variable steps: they load their fields in `loadData()` and print different header/body/footer text in the `format*` methods. The driver treats every item as a `Report` and only calls `generateReport()`, which is polymorphism: the same invocation runs different concrete formatting without `instanceof` checks.
