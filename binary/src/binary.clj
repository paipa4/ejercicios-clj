(ns binary
  (:require [clojure.string :as string]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn decimal [number]
  (loop [n-seq (map #(Integer. (str %)) (str number))
         n (- (count n-seq) 1)
         resultado '()]
    (if (empty? n-seq)
      resultado
      (recur (nthrest n-seq 1)
             (- n 1)
             (conj resultado (* (exp 2 n) (first n-seq)))))))

(defn to-decimal [number]
  (if (re-matches #"^\d+$" number)
    (reduce + (decimal number))
    0))
