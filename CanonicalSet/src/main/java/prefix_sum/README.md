Understood. This is your **Prefix Sum Mastery Bucket List** — structured like a serious MAANG-level preparation sheet.

Goal:
If a problem smells like cumulative aggregation, subarray count, range sum, or frequency difference → it must fall into one of these buckets.

---

# 🧠 PREFIX SUM – Canonical Level-wise Mastery List

---

# 🔹 LEVEL 1 — Basic Prefix Sum (Static Range Query)

> If the problem asks multiple range sum queries → build prefix once.

### Core Idea

`prefix[i] = sum(0 → i-1)`

| Pattern         | LeetCode | Problem                        | When to Choose        |
| --------------- | -------- | ------------------------------ | --------------------- |
| 1D prefix sum   | 303      | Range Sum Query – Immutable    | Multiple queries      |
| Running sum     | 1480     | Running Sum of 1D Array        | Basic build           |
| 2D prefix sum   | 304      | Range Sum Query 2D – Immutable | Submatrix sum         |
| Pivot index     | 724      | Find Pivot Index               | Left sum = right sum  |
| Left-right diff | 2574     | Left and Right Sum Differences | Precompute both sides |

---

# 🔹 LEVEL 2 — Prefix Sum + HashMap (Subarray Count)

> If question says:

* number of subarrays
* count subarrays with sum = K
* cumulative frequency

### Core Formula

If `prefix[j] - prefix[i] = k`
Then `prefix[i] = prefix[j] - k`

| Pattern          | LeetCode | Problem                            | When to Choose    |
| ---------------- | -------- | ---------------------------------- | ----------------- |
| Subarray sum = K | 560      | Subarray Sum Equals K              | Count subarrays   |
| Binary sum       | 930      | Binary Subarrays With Sum          | 0/1 array         |
| Nice subarrays   | 1248     | Count Number of Nice Subarrays     | Exactly K odds    |
| Divisible by K   | 974      | Subarray Sums Divisible by K       | Mod bucket        |
| Continuous sum   | 523      | Continuous Subarray Sum            | Sum multiple of k |
| Longest sum K    | 325      | Maximum Size Subarray Sum Equals k | Length variant    |

---

# 🔹 LEVEL 3 — Prefix Sum + Modulo / Frequency Bucket

> Whenever you see:

* divisible
* remainder
* equal 0 mod k

| Pattern            | LeetCode | Problem                       | Why             |
| ------------------ | -------- | ----------------------------- | --------------- |
| Remainder bucket   | 974      | Divisible by K                |                 |
| Equal 0/1 count    | 525      | Contiguous Array              | Map 0→-1        |
| Balanced string    | 1371     | Longest Substring Vowels Even | Bitmask prefix  |
| Make sum divisible | 1590     | Make Sum Divisible by P       | Remove shortest |

---

# 🔹 LEVEL 4 — Prefix Sum + Sliding Window Hybrid

> When:

* exactly K → atMost(K) - atMost(K-1)
* subarray with condition + count

| Pattern            | LeetCode | Problem                   |
| ------------------ | -------- | ------------------------- |
| Exactly K distinct | 992      | Subarrays with K Distinct |
| Nice subarrays alt | 1248     | Sliding window version    |
| Binary sum alt     | 930      | AtMost trick              |

---

# 🔹 LEVEL 5 — Prefix Sum + Monotonic Structure

> When you need max/min over range difference.

| Pattern      | LeetCode | Problem                       |
| ------------ | -------- | ----------------------------- |
| Max subarray | 53       | Kadane (prefix optimized)     |
| Max circular | 918      | Maximum Sum Circular Subarray |
| Min subarray | 1590     | Remove shortest subarray      |
| Range diff   | 2016     | Maximum Difference            |

---

# 🔹 LEVEL 6 — 2D Prefix Sum (Matrix Problems)

> If problem says:

* rectangle sum
* submatrix
* count submatrices

| Pattern           | LeetCode | Problem                         |
| ----------------- | -------- | ------------------------------- |
| Basic 2D prefix   | 304      | Range Sum Query 2D              |
| Count submatrix   | 1074     | Submatrix Sum Equals K          |
| Max rectangle sum | 363      | Max Sum Rectangle ≤ K           |
| Count all ones    | 1504     | Count Submatrices With All Ones |

---

# 🔹 LEVEL 7 — Difference Array (Inverse Prefix)

> Range update problems.

### Core Idea

Instead of updating every index:

* mark start++
* mark end+1--

Then prefix once.

| Pattern                   | LeetCode | Problem                   |
| ------------------------- | -------- | ------------------------- |
| Range addition            | 370      | Range Addition            |
| Corporate flight bookings | 1109     | Corporate Flight Bookings |
| Car pooling               | 1094     | Car Pooling               |
| Shifting letters          | 2381     | Shifting Letters II       |

---

# 🔹 LEVEL 8 — Advanced Prefix State Compression

> Hardcore MAANG separator level.

| Pattern         | LeetCode | Problem                              |
| --------------- | -------- | ------------------------------------ |
| Bitmask prefix  | 1371     | Vowels Even Count                    |
| 2D compression  | 1074     | Submatrix Sum                        |
| Prefix + DP     | 1425     | Constrained Subsequence Sum          |
| Prefix + Greedy | 798      | Smallest Rotation with Highest Score |

---

# 🧠 30-Second Prefix Sum Decision Framework

### Step 1 — Does it ask:

* subarray count?
* range sum?
* divisible?
* equal frequency?
* multiple queries?

If yes → Prefix candidate.

---

### Step 2 — Is it counting subarrays?

→ Use `prefix + hashmap`

---

### Step 3 — Is it divisible / mod related?

→ Store remainder frequency.

---

### Step 4 — Is it 2D matrix?

→ Build 2D prefix.

---

### Step 5 — Is it range update?

→ Difference array.

---

# 📌 Prefix Sum Mastery Checklist

You are strong when:

* [ ] Can derive prefix formula instantly
* [ ] Can solve 560 without thinking
* [ ] Can handle negative numbers
* [ ] Can convert exactly K to atMost trick
* [ ] Can implement 2D prefix from memory
* [ ] Understand mod bucket collision logic
* [ ] Can apply difference array correctly

---

# 🔥 Most Important 10 (Must Master Cold)

1. 560 – Subarray Sum Equals K
2. 974 – Subarray Divisible by K
3. 1248 – Nice Subarrays
4. 930 – Binary Subarrays
5. 525 – Contiguous Array
6. 1074 – Submatrix Sum Equals K
7. 1109 – Corporate Flight Bookings
8. 1590 – Make Sum Divisible by P
9. 918 – Circular Subarray
10. 1371 – Vowels Even Count