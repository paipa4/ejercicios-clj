(ns beer-song
  (:require [clojure.string :as string]))


(defn prim [n]
  (if (= n 1)
      "1 bottle of beer on the wall, 1 bottle of beer.\n"
  (if (= n 0)
      "No more bottles of beer on the wall, no more bottles of beer.\n"
      (str n " bottles of beer on the wall, " n " bottles of beer.\n"))))


(defn med [n]
  (if (= n 1)
    "Take it down and pass it around, "
  (if (= n 0)
    "Go to the store and buy some more, "
    "Take one down and pass it around, ")))


(defn ult [n]
  (if (= n 1)
      "1 bottle of beer on the wall.\n"
  (if (= n 0)
      "no more bottles of beer on the wall.\n"
  (if (< n 0)
      "99 bottles of beer on the wall.\n"
      (str n " bottles of beer on the wall.\n")))))


(defn verse [a]
  (str (prim a) (med a) (ult (- a 1))))


(defn sing [a & b]
  (let [end (or b 0)]
       (loop [current a
              result []]
         (if (>= current end)
           (recur (dec current)
                  (conj result (verse current)))
           (string/join "\n" result)))))



(range 6 17)
