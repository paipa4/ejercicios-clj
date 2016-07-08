(ns trinary
  (:require [clojure.string :as string]))

(def to-digit {\0 0, \1 1, \2 2})

(defn exp [x n]
  (reduce * (repeat n x)))

(defn to-decimal [number]
  (if (every? identity (map to-digit number))
    (reduce + (map-indexed #(* %2 (exp 3 %1))
                           (reverse (map to-digit number))))0))

