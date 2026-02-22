Good. Clean. Structured. Pattern-first.
This is your **Sliding Window Canonical Bucket Table**, organized strictly by **learning level (pattern depth)** — not difficulty.

---

# 🧠 Sliding Window – Canonical Pattern Levels

---

## 🔵 Level 1 — Fixed Size Window (Mechanical Foundation)

> Window length is constant `k`.

| Level | Category              | Pattern Core                   | Canonical LeetCode Problems |
| ----- | --------------------- | ------------------------------ | --------------------------- |
| 1     | Fixed Sum / Average   | Maintain running sum of size k | 643                         |
| 1     | Fixed Freq Match      | Compare freq arrays of size k  | 438, 567                    |
| 1     | Fixed Window Extremes | Max/min in window              | 239                         |
| 1     | Rolling Stream Window | Online fixed window            | 346                         |

**Master this before moving ahead.**

---

## 🔵 Level 2 — Variable Window (Expand–Shrink Core Pattern)

> Window grows right, shrinks left to maintain validity.

| Level | Category                | Pattern Core             | Canonical LeetCode Problems |
| ----- | ----------------------- | ------------------------ | --------------------------- |
| 2     | Longest Valid Substring | No duplicates constraint | 3                           |
| 2     | At Most K Replacements  | Maintain maxFreq trick   | 424                         |
| 2     | Flip/Change ≤ K         | Budget constraint        | 1004                        |
| 2     | Minimum Size Subarray   | Shrink to satisfy sum    | 209                         |
| 2     | Max Erasure Value       | Unique constraint + sum  | 1695                        |

**This is the main sliding window engine.**

---

## 🔵 Level 3 — AtMost(K) Framework (Exact-K Derivation Layer)

> Most important interview multiplier.

| Level | Category                  | Pattern Core            | Canonical LeetCode Problems |
| ----- | ------------------------- | ----------------------- | --------------------------- |
| 3     | At Most K Distinct        | distinct ≤ k            | 340, 159                    |
| 3     | Exactly K Distinct        | atMost(k) - atMost(k-1) | 992                         |
| 3     | Exactly K Odds            | same subtraction trick  | 1248                        |
| 3     | Binary Subarrays With Sum | atMost conversion       | 930                         |

**If you master Level 3 → most “hard-looking” problems collapse.**

---

## 🔵 Level 4 — Counting Windows (Contribution Technique)

> Instead of max/min, count number of valid windows.

| Level | Category                    | Pattern Core         | Canonical LeetCode Problems |
| ----- | --------------------------- | -------------------- | --------------------------- |
| 4     | Count Subarrays Product < K | contribution pattern | 713                         |
| 4     | Count Substrings with ABC   | count while valid    | 1358                        |
| 4     | Nice Subarrays              | hybrid count         | 1248                        |

**Key formula:**
`ans += (right - left + 1)`

---

## 🔵 Level 5 — Monotonic Structure + Window

> Window + ordered data structure.

| Level | Category                | Pattern Core    | Canonical LeetCode Problems |
| ----- | ----------------------- | --------------- | --------------------------- |
| 5     | Sliding Window Maximum  | Monotonic deque | 239                         |
| 5     | Shortest Subarray ≥ K   | Prefix + deque  | 862                         |
| 5     | Constrained Subsequence | Window + deque  | 1425                        |

---

## 🔵 Level 6 — Hybrid Window Patterns

> Window merges with other paradigms.

| Level | Category                        | Pattern Core                    | Canonical LeetCode Problems |
| ----- | ------------------------------- | ------------------------------- | --------------------------- |
| 6     | Window + Prefix Sum             | Needed when negatives exist     | 862, 560                    |
| 6     | Window + DP                     | Window defines range, DP scores | 1423                        |
| 6     | Window + Multi Constraint       | Maintain 2+ invariants          | 992 + 209 type              |
| 6     | Window + Concatenation Matching | Structured freq windows         | 30                          |

---

# 📌 Mastery Order (Strict)

1 → Fixed Window
2 → Variable Window
3 → AtMost Framework
4 → Counting Pattern
5 → Monotonic Window
6 → Hybrids

---

If you want next, I can prepare:

* A **Sliding Window Template Sheet (Java)** for each level
* A **30-second Pattern Recognition Flow**
* Or a **Hybrid Mapping Table (Sliding Window × Prefix × Deque × DP)**

Tell me which layer you want to sharpen next.
