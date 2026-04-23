# AI Usage — Question 3

**AI Tools Used:** Cursor (Claude)

**Prompts Used (2–5 max):**

1. Add JUnit 5 tests for GradeCalculator matching exam counts (boundary + assertThrows).
2. Trim extra tests so requirements stay clear.

**How AI Helped (2–3 sentences):**  
AI suggested initial test names and assertions. I verified boundaries (90 for “A”, 60 for passing) against the implementation and kept two distinct `assertThrows` cases for invalid scores.

**Reflection (1–2 sentences):**  
Naming tests after the rule being checked makes failures easier to debug than one giant test method.
