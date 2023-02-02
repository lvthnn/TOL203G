library(tidyverse)

f <- file.path("~/Github/TOL203G/HD3/src/V2/data_fast.csv")
f_slow <- file.path("~/Github/TOL203G/HD3/src/V2/data_slow.csv")

df <- read_tsv(f)
df_slow <- read_tsv(f_slow)

df <- df %>%
  full_join(df_slow, by="N", suffix=c("f", "s"))

plot(df$N, df$Tf, 'l')
