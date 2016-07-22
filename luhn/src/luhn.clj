(ns luhn
  (:require [clojure.string :as string]))

(def nums {\0 0, \1 1, \2 2, \3 3, \4 4, \5 5, \6 6, \7 7, \8 8, \9 9})

(defn sum [n]
  (let [n (* n 2)]
    (if (<= 10 n)
      (- n 9)
      n)))

(defn create-coll [n]
  (map nums (filter #(list %) (str n))))

(defn change [coll func]
  (map-indexed (fn [index b]
                 (if (func index)
                   (sum b)
                   b)) coll))

(defn length-even? [number]
  (even? (count (str number))))

(defn checksum [number]
  (mod (if (length-even? number)
         (reduce + (change (create-coll number) even?))
         (reduce + (change (create-coll number) odd?)))
       10))

(defn valid? [n]
  (zero? (checksum n)))

(defn add-check-digit [n]
  (let [m (* n 10)]
     (+ m (- 10 (checksum m)))))

