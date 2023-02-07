library(tidyverse)

f_fast <- file.path("~/Github/TOL203G/HD3/src/V2/data_fast.csv")
f_slow <- file.path("~/Github/TOL203G/HD3/src/V2/data_slow.csv")

df_fast <- read_tsv(f_fast) %>% filter(T > 0)
df_slow <- read_tsv(f_slow) %>% filter(T > 0)


# Plot
png('~/Github/TOL203G/HD3/src/V2/speed_comparison_nonlog.png', width = 700,height = 300)
layout_matrix <- matrix(1:2, ncol=2)
layout(layout_matrix)
plot(df_fast$N, df_fast$T, 'l', xlab='N', ylab='T(N)', main='arraysum_fast')
plot(df_slow$N, df_slow$T, 'l', xlab='N', ylab='T(N)', main='arraysum')
dev.off()
