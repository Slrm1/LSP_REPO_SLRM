# Final Exam — Question 1

## Part 1: Shared Resources and Risk

**Shared Resource #1:** The `nextId` field (the counter used to assign IDs).

**Shared Resource #2:** The `requests` `ArrayList` (the shared list that holds request strings).

**Concurrency Problem:** Multiple threads can interleave updates, causing a **race on shared mutable state**. `nextId` can be read and written without a happens-before relationship between threads, and `ArrayList` is **not thread-safe** for concurrent structural changes.

**Why `addRequest()` is unsafe:** It is not an atomic operation end-to-end. Even if `getNextId()` were somehow safe, another thread can still modify `requests` at the same time, corrupting the list. As written, `getNextId()` and `requests.add(...)` can interleave with other threads calling `addRequest()` or `getNextId()`, producing duplicate IDs, skipped IDs, lost updates to `nextId`, or internal `ArrayList` corruption.

---

## Part 2: Evaluate Fixes

**Fix A: Explanation**  
**Not correct.** Synchronizing only `getNextId()` serializes ID generation, but `addRequest()` still performs `requests.add(...)` **outside** that synchronized region (and `ArrayList` is unsafe under concurrent modification). Another thread can still corrupt `requests` while this thread is between steps.

**Fix B: Explanation**  
**Correct.** Synchronizing `addRequest()` makes the whole method body (ID assignment + list update) run **mutually exclusively** for a given `RequestManager` instance, so `nextId` and `requests` are updated as one unit with no interleaving from other `addRequest()` calls.

**Fix C: Explanation**  
**Not correct.** Synchronizing only `getRequests()` protects reads of the list reference, not the **mutations** happening in `addRequest()`. Concurrent `addRequest()` calls can still execute at the same time and break `ArrayList` invariants.

---

## Part 3: Object-Oriented Design (Riel)

**Answer + Explanation**  
`getNextId()` **should not be public**. It is an internal sequencing detail of how requests are stored, not part of the manager’s stable “service contract.” Making it public widens coupling: callers can depend on ID rules and call it in surprising orders, which hurts maintainability. Riel’s guidance favors exposing the smallest surface that supports the object’s responsibility—here, `addRequest` (and possibly read-only access via `getRequests`) is enough.

---

## Part 4: Alternative Synchronization Approach

**Description:** Instead of `synchronized`, use an explicit **reentrant lock** from `java.util.concurrent.locks` so only one thread at a time runs the “assign id + append to list” section. `Lock`/`unlock` in a `try/finally` guarantees the lock is released even on exceptions.

**Code Snippet:**

```java
private final Lock requestLock = new ReentrantLock();

public void addRequest(String studentName) {
    requestLock.lock();
    try {
        int id = getNextId();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        requestLock.unlock();
    }
}
```

(Imports: `java.util.concurrent.locks.Lock`, `java.util.concurrent.locks.ReentrantLock`.)
