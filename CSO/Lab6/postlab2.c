long loop(long a, long b) {
    long result = 1;  // Initialize the result to 1

    while (a < b) {
        result *= (a + b);  // Multiply the result by (a + b)
        a++;               // Increment 'a'
    }

    return result;  // Return the final result
}