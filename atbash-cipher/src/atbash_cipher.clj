(ns atbash-cipher
  (:require [clojure.string :as string])
  (:require [clojure.string :refer [lower-case join]]))

(def abc (into {} (map #(vector (char (+ 97 %)) (char (- 122 %))) (range 0 26))))

(defn encode [word]
  (->>
  (lower-case word)
  (map #( get abc % %))
  (join "")
  (re-seq #"[a-z\d]")
  (partition 5 5 "")
  (map #(join %))
  (join " ")))
