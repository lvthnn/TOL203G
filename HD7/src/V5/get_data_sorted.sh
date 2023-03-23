#!/bin/bash
for (( i=1; i<=100000; i*=2 ))
do
  echo "Running sim for n =" $i
  java CompareBST_Sim.java $i 10 sorted >> data_sorted.csv
done
