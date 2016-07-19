(ns crypto-square
  (:require [clojure.string :as string]))

(defn normalize-plaintext [word]
  (string/join "" (re-seq #"[\w]+" (string/lower-case word))))

(defn square-size [frase]
  (->
     frase
    (normalize-plaintext)
    (count)
    (Math/sqrt)
    (Math/ceil)
    (int)))

(defn plaintext-segments [frase]
  (map #(string/join %)(partition-all(square-size frase)
                                     (normalize-plaintext frase))))
(defn combine [frase]
  (let [coll  (plaintext-segments frase)]
    (map-indexed (fn [i _]
                   (clojure.string/join "" (map #(get % i) coll)))
                 (first coll))))

(defn normalize-ciphertext [frase]
    (string/join " " (combine frase)))

(defn ciphertext [frase]
    (string/join "" (combine frase)))

