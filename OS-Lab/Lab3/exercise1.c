#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>

int main()
{
    pid_t pid = fork();
    switch (pid)
    {
        case -1:
            perror("fork failed");
            exit(EXIT_FAILURE);
        case 0:
            printf("child: %d, parent: %d\n", getpid(), getppid());
            exit(EXIT_SUCCESS);
        default:
            printf("parent: %d\n", getpid());
    }
}