#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <time.h>

int main() {
    char str[] = "ball";
    clock_t start, end;
    double cpu_time_used;
    printf("Original String: %s\n", str);
    start = clock();
    for (int i = 0; i < strlen(str); i++) {
        if (str[i] >= 'A' && str[i] <= 'Z') {
            str[i] += 32;
        }
    }
    end = clock();
    cpu_time_used = (double)(end - start)/CLOCKS_PER_SEC;
    printf("Converted String: %s\n", str);
    printf("Time taken: %f seconds\n", cpu_time_used);
    return 0;
}