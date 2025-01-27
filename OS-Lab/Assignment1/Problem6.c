#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main() {
    pid_t pid_original = getpid();
    pid_t ppid_original = getppid();

    printf("Original process with PID %d and PPID %d\n", pid_original, ppid_original);

    pid_t pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        printf("Child process with PID %d and PPID %d\n", getpid(), getppid());

        pid_t pid_grandchild = fork(); 

        if (pid_grandchild < 0) {

            perror("Fork failed");
            exit(EXIT_FAILURE);
        } else if (pid_grandchild == 0) {

            printf("Grandchild process with PID %d and PPID %d\n", getpid(), getppid());
            printf("Grandchild process is exiting\n");
            exit(EXIT_SUCCESS);
        } else {

            wait(NULL);
            printf("Child process with PID %d and PPID %d\n", getpid(), getppid());
            printf("Child process is exiting\n");
            exit(EXIT_SUCCESS);
        }
    }else {

        wait(NULL);
        printf("Parent process with PID %d and PPID %d\n", getpid(), getppid());
        sleep(2);

        char *args[] = {"ps", NULL};
        execvp("ps", args);

        perror("execvp failed");
        exit(EXIT_FAILURE);
    }
    return 0;
}
