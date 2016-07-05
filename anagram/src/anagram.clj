(ns anagram
  (:require [clojure.string :as string]))

(defn filtro [quiero]
  (fn [elemento]
   (and (= (sort quiero)
           (sort (string/lower-case elemento)))
        (not (= quiero elemento)))))

(defn anagrams-for [a coll]
  (filter (filtro (string/lower-case a)) coll))
