import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

if __name__ == '__main__':
    data = np.loadtxt('data_randomsort.txt')
    rate = np.mean(data)

    sns.histplot(data, stat='proportion')
    plt.xlabel('Keyrslutími')
    plt.ylabel('Hlutfall')
    plt.axvline(x=rate, color='red', linestyle='--')

    plt.savefig('randomsort_1Kints.png', dpi=1000, orientation='landscape')
