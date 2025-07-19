# Sliding-Window-concepts

  **Imagine you're looking at a long line of houses, and you can only see 3 houses at a time through a small window. You slide this window one house to the right each time to see the next group of 3 houses.**

That’s what sliding window means in programming too!

👉 **Example:**
Let’s say you have this list of numbers:

[1, 3, 5, 2, 8, 6, 4]

And you want to find the maximum sum of 3 consecutive numbers.

Instead of calculating the sum of every 3-number group separately, you:

  -> Take the first 3: 1 + 3 + 5 = 9

  -> Slide the window 1 step: Now you have 3 + 5 + 2 = 10 (just remove 1, add 2)

  -> Again slide: 5 + 2 + 8 = 15

  -> And so on…

You're using the previous sum to calculate the next, saving time and effort.
