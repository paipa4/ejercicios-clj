(ns word-count
  (:require [clojure.string :as string]))

(def frase
  "one fish two fish red fish blue fish")


(defn count-key [h k]
  (assoc h k (count (get h k))))


(defn count-keys [h k-list]
  (loop [claves k-list
         jash h]
    (if (> (count claves) 0)
      (recur (rest claves)
             (count-key jash (first claves)))
      jash)))


(defn word-count [cont]
  (let [palabras (string/split cont #"\W+")
        grupos  (group-by string/lower-case palabras)]
    (count-keys grupos (keys grupos))))

(fn? type)


