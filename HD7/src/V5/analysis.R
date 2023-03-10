  library(tidyverse)
  
  header <- c("n", "trials", "type", "opt_height", "avg_height", "avg_time", "sd_time")
  
  df <- read.csv("~/Github/TOL203G/HD7/src/V5/data.csv", sep="\t", header=FALSE)
  
  
  colnames(df) <- header
  df$type <- trimws(df$type)
