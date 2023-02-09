import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import expon
import seaborn as sns

if __name__ == '__main__':
    data = np.loadtxt('data_randomsort.txt')
    rate = np.mean(data)

    sns.histplot(data, stat='proportion')
    plt.xlabel('Keyrslutími')
    plt.ylabel('Hlutfall')
    plt.axvline(x=rate, color='red', linestyle='--')

    X = np.linspace(0, np.max(data), 1000)
    p = expon.pdf(X, scale=1/0.1456)
    plt.plot(X, p)

    plt.savefig('Randomsort_1Kints.png', dpi=1000, orientation='landscape')
