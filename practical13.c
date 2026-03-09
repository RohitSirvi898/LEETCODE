#include <stdio.h>
#include <stdbool.h>

#define MAX 10
#define RESOURCE_TYPES 3

// Function to calculate if the system is in a safe state
bool isSafe(int processes[], int avail[], int alloc[][RESOURCE_TYPES], int max[][RESOURCE_TYPES], int n) {
    int need[MAX][RESOURCE_TYPES];
    bool finish[MAX];
    int work[RESOURCE_TYPES];
    int safeSeq[MAX];
    int count = 0;

    // 1. Calculate Need Matrix (Need = Max - Allocation)
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < RESOURCE_TYPES; j++) {
            need[i][j] = max[i][j] - alloc[i][j];
        }
        finish[i] = false;
    }

    // 2. Initialize Work to Available resources
    for (int i = 0; i < RESOURCE_TYPES; i++) {
        work[i] = avail[i];
    }

    // 3. Check for safe sequence
    while (count < n) {
        bool progressMade = false;
        for (int i = 0; i < n; i++) {
            // If process is not finished and its needs can be satisfied with work
            if (!finish[i]) {
                bool canExecute = true;
                for (int j = 0; j < RESOURCE_TYPES; j++) {
                    if (need[i][j] > work[j]) {
                        canExecute = false;
                        break;
                    }
                }

                if (canExecute) {
                    // Add allocated resources back to work and mark process as finished
                    for (int j = 0; j < RESOURCE_TYPES; j++) {
                        work[j] += alloc[i][j];
                    }
                    finish[i] = true;
                    safeSeq[count++] = processes[i];
                    progressMade = true;
                }
            }
        }

        // If no progress is made in a full pass, the system is in an unsafe state
        if (!progressMade) {
            printf("\nSystem is NOT in a safe state!\n");
            return false;
        }
    }

    // 4. Print Safe Sequence if system is safe
    printf("\nSystem is in a safe state.\nSafe Sequence: ");
    for (int i = 0; i < n; i++) {
        printf("P%d ", safeSeq[i]);
    }
    printf("\n");
    return true;
}

int main() {
    int n; // Number of processes
    int processes[MAX];
    int avail[RESOURCE_TYPES];
    int alloc[MAX][RESOURCE_TYPES];
    int max[MAX][RESOURCE_TYPES];

    printf("--- Banker's Algorithm: Safety Check ---\n");
    printf("Enter number of processes (Max %d): ", MAX);
    scanf("%d", &n);

    // Initialize Process IDs
    for (int i = 0; i < n; i++) {
        processes[i] = i;
    }

    printf("Enter available resources for the %d types (space separated): ", RESOURCE_TYPES);
    for (int i = 0; i < RESOURCE_TYPES; i++) {
        scanf("%d", &avail[i]);
    }

    printf("Enter the Allocation matrix (rows: processes, columns: resources):\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < RESOURCE_TYPES; j++) {
            scanf("%d", &alloc[i][j]);
        }
    }

    printf("Enter the Maximum matrix (rows: processes, columns: resources):\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < RESOURCE_TYPES; j++) {
            scanf("%d", &max[i][j]);
        }
    }

    // Run the safety check
    isSafe(processes, avail, alloc, max, n);

    return 0;
}