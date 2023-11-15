long try(long x) {
    long long result = 0;
    long long count = 64;

    while (count != 0) {
        result += result;
        result |= x;
        x >>= 1;
        count--;;
    }

    return result;
}