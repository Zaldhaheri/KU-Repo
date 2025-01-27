#include <stdio.h>
#include "pthread.h"
#include "semaphore.h"
#include <unistd.h>

#define NUM_PHILO 5
#define NUM_FORKS 5

#define COLOR_RESET   "\033[0m"
#define COLOR_RED     "\033[31m"
#define COLOR_GREEN   "\033[32m"
#define COLOR_YELLOW  "\033[33m"
#define COLOR_BLUE    "\033[34m"
#define COLOR_MAGENTA "\033[35m"
#define COLOR_CYAN    "\033[36m"

sem_t forks[NUM_FORKS];

void philosopher(void *arg) {
    int id = *(int *)arg;
    int left_fork = id;
    int right_fork = (id + 1) % NUM_PHILO;

    while (1) {
        printf(COLOR_RED "Philosopher %d is thinking\n" COLOR_RESET, id);
        usleep(100);

        sem_wait(&forks[right_fork]);
        printf(COLOR_BLUE "Philosopher %d got right fork %d\n" COLOR_RESET, id, right_fork);

        sem_wait(&forks[left_fork]);
        printf(COLOR_MAGENTA "Philosopher %d got left fork %d\n" COLOR_RESET, id, left_fork);

        printf(COLOR_YELLOW "Philosopher %d is eating\n" COLOR_RESET, id);
        usleep(100000); 

        sem_post(&forks[left_fork]);
        sem_post(&forks[right_fork]);
        printf(COLOR_GREEN "Philosopher %d put down forks %d and %d\n" COLOR_RESET, id, left_fork, right_fork);

        usleep(100000);
    }
}


int main()
{
    pthread_t philosophers[NUM_PHILO];
    int ids[NUM_PHILO];

    for (int i = 0; i < NUM_FORKS; ++i) {
        sem_init(&forks[i], 0, 1);
    }


    for (int i = 0; i < NUM_PHILO; ++i) {
        ids[i] = i;
        pthread_create(&philosophers[i], NULL, (void *(*)(void *))philosopher, &ids[i]);
    }

    for (int i = 0; i < NUM_PHILO; ++i) {
        pthread_join(philosophers[i], NULL);
    }

    for (int i = 0; i < NUM_FORKS; ++i) {
        sem_destroy(&forks[i]);
    }

    return 0;
}