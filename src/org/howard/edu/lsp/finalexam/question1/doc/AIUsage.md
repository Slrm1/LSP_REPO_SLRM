# AI Usage — Question 1

**AI Tools Used:** Cursor (Claude)

**Prompts Used (2–5 max):**

1. Scaffold final exam answers for Howard LSP final (concurrency + submission layout).
2. Tighten explanations for synchronized fixes and non-synchronized lock snippet.

**How AI Helped (2–3 sentences):**  
AI helped organize the required answer headings and draft clear concurrency explanations. I reviewed each fix against the Java Memory Model and `ArrayList` thread-safety rules and adjusted wording where I wanted it to match my own understanding.

**Reflection (1–2 sentences):**  
Writing this reinforced that **synchronizing the smallest method** is not always enough—the unit that must be atomic is the **whole compound update**, not just one line inside it.
