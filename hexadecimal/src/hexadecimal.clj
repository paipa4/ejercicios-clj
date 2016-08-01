(ns hexadecimal
   (:require [clojure.string :as string]))

(def hexa {\a 10, \b 11, \c 12, \d 13, \e 14, \f 15})

(defn exp [x n]
  (reduce * (repeat n x)))

(defn to-number [string]
  (map #(Integer. (str (hexa % %))) string))

(defn hex-to-int [string]
  (if (re-matches #"^[0-9A-Fa-f]+$" string)
    (reduce + (map-indexed #(* %2 (exp 16 %1))
                           (reverse (to-number string))))
    0))
